package net.kbt.lagoon;

import java.math.BigDecimal;

class Salary {
  private Integer netto;

  private Salary(Integer nettoSalary) {
    this.netto = nettoSalary;
  }

  static Salary calculatePln(int monthNettoSalary, BigDecimal currencyRate) {
    return new Salary(
        currencyRate.multiply(
            new BigDecimal(monthNettoSalary)
        ).intValue()
    );
  }

  public Integer getNetto() {
    return netto;
  }
}
