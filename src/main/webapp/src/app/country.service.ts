import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CountryService {
  private apiUrl = "/countries";

  constructor(private http: HttpClient) { }

  getList() {
    return this.http.get(this.apiUrl);
  }
}
