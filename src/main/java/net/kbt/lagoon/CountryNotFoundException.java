package net.kbt.lagoon;

public class CountryNotFoundException extends RuntimeException {
  public CountryNotFoundException(String country) {
    super("Country not found: " + country);
  }
}
