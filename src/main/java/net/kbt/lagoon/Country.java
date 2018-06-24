package net.kbt.lagoon;

class Country {
  private static final int DAYS_IN_MONTH = 22;

  private String code;
  private String name;
  private Integer taxRate;
  private Integer fixedCost;
  private Currency currency;

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Currency getCurrency() {
    return currency;
  }

  public Integer getTaxRate() {
    return taxRate;
  }

  public Integer getFixedCost() {
    return fixedCost;
  }

  public int getMonthNettoSalary(Integer dailyGrossAmount) {
    var monthlyGross = dailyGrossAmount * DAYS_IN_MONTH;
    var percent = (100.0 - taxRate) / 100;

    return (int) Math.round((monthlyGross - fixedCost) * percent);
  }
}
