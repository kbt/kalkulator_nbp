package net.kbt.lagoon;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Component
public class CountryService {
  private static final String COUNTRIES_FILE = "/countries.json";
  private Map<String, Country> countries;

  public CountryService() {
    countries = loadCountries();
  }

  Country getByCode(String code) {
    return Optional.ofNullable(countries.get(code.toUpperCase()))
        .orElseThrow(() -> new CountryNotFoundException(code));
  }

  Collection<Country> getCountries() {
    return countries.values();
  }

  private static Map<String, Country> loadCountries() {
    ObjectMapper jsonMapper = new ObjectMapper();

    try {
      var resource = CountryService.class.getResourceAsStream(COUNTRIES_FILE);
      List<Country> list = jsonMapper.readValue(
          resource,
          new TypeReference<List<Country>>() {
          }
      );

      return list.stream()
          .collect(Collectors.toMap(Country::getCode, Function.identity()));
    } catch (IOException exception) {
      throw new RuntimeException(exception);
    }
  }
}
