package net.kbt.lagoon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CountryController {
  private CountryService countryService;

  public CountryController(CountryService countryService) {
    this.countryService = countryService;
  }

  @GetMapping("/countries")
  public List<SimpleCountry> getList() {
    return countryService.getCountries()
        .stream()
        .map(SimpleCountry::fromCountry)
        .collect(Collectors.toList());
  }
}
