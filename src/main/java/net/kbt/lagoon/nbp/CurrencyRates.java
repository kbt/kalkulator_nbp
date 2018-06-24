package net.kbt.lagoon.nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRates {
  private String currency;
  private List<CurrencyRate> rates;

  public String getCurrency() {
    return currency;
  }

  public List<CurrencyRate> getRates() {
    return rates;
  }
}
