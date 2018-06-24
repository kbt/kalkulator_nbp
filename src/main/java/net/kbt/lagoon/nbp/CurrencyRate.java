package net.kbt.lagoon.nbp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyRate {
  private BigDecimal mid;

  public BigDecimal getMid() {
    return mid;
  }
}
