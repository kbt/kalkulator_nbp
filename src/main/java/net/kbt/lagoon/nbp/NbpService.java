package net.kbt.lagoon.nbp;

import net.kbt.lagoon.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Component
public class NbpService {

  private static Logger logger = LoggerFactory.getLogger(NbpService.class);

  private static final String URL = "http://api.nbp.pl/api/exchangerates/rates/a/%s/?format=json";

  private RestTemplate restTemplate = new RestTemplate();

  public BigDecimal getCurrencyRate(Currency currency) {
    if (currency == Currency.PLN) {
      return new BigDecimal(1);
    }

    var url = String.format(URL, currency.toString());

    BigDecimal rate = restTemplate.getForObject(url, CurrencyRates.class)
        .getRates()
        .get(0)
        .getMid();

    logger.info("Currency {}, rate: {}", currency, rate);

    return rate;
  }
}
