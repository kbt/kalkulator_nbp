package net.kbt.lagoon;

public enum Currency {
  GBP,
  EUR,
  PLN;

  @Override
  public String toString() {
    return this.name()
        .toLowerCase();
  }
}
