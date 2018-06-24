import {Component} from '@angular/core';
import {CalculatorService} from './calculator.service';
import {CountryService} from "./country.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {
  readonly msgTemplate = "Wynagrodzenie miesięczne netto: <b>{salary} PLN</b>";
  countries;
  country;
  amount = "";
  message = "";

  constructor(
    private calculatorService: CalculatorService,
    private countryService: CountryService) {
    this.calculatorService = calculatorService;
    this.countryService.getList()
    .subscribe(data => {
      this.countries = data;
      this.country = this.countries[0];
    });
  }

  calculate() {
    this.calculatorService.calculate(this.amount, this.country.code)
    .subscribe(data => {
      this.message = this.msgTemplate.replace("{salary}", data["netto"])
    }, error => {
      if (error.status == 400) {
        this.message = "Błąd: " + error.error.msg;
      }
      else {
        this.message = "Błąd serwera!";
        console.log(error)
      }
    });
  }
}
