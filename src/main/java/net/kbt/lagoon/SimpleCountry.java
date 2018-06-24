package net.kbt.lagoon;

public class SimpleCountry {
  private String code;
  private String name;
  private Currency currency;

  public SimpleCountry(String code, String name, Currency currency) {
    this.code = code;
    this.name = name;
    this.currency = currency;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public Currency getCurrency() {
    return currency;
  }

  public static SimpleCountry fromCountry(Country country) {
    return new SimpleCountry(
        country.getCode(),
        country.getName(),
        country.getCurrency()
    );
  }
}
