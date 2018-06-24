import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CalculatorService {
  private apiUrl = "/calculate?amount={amount}&country={country}";

  constructor(private http: HttpClient) {
  }

  calculate(amount, country) {
    let url = this.apiUrl
    .replace("{amount}", amount)
    .replace("{country}", country);

    return this.http.get(url);
  }
}
