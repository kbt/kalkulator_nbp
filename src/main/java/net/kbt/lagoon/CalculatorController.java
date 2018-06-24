package net.kbt.lagoon;

import net.kbt.lagoon.nbp.NbpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class CalculatorController {
  private NbpService nbpService;
  private CountryService countryService;

  @Autowired
  public CalculatorController(NbpService nbpService, CountryService countryService) {
    this.nbpService = nbpService;
    this.countryService = countryService;
  }

  @GetMapping("/calculate")
  public Salary calculate(
      @RequestParam(name = "amount") Integer amount,
      @RequestParam(name = "country") String countryCode) {

    if (amount == null || amount <= 0) {
      throw new IllegalArgumentException("Wartosc powinna byc wieksza niz 0");
    }

    var country = countryService.getByCode(countryCode);
    var currencyRate = nbpService.getCurrencyRate(country.getCurrency());

    return Salary.calculatePln(
        country.getMonthNettoSalary(amount),
        currencyRate);
  }

  @ResponseStatus(value=HttpStatus.BAD_REQUEST)
  @ExceptionHandler(RuntimeException.class)
  public Map<String, String> badRequest(Exception exception) {
    return Collections.singletonMap("msg", exception.getMessage());
  }
}
