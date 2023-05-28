package microservices.example.currencyexchangesampleservice;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class CurrencyExchangeSampleController {
    @Autowired private Environment environment;

    private static final Logger LOGGER= LoggerFactory.getLogger(CurrencyExchangeSampleController.class);


    @GetMapping(
            "/currency-exchange-sample/fromCurrency/{fromCurrency}/toCurrency/{toCurrency}")

    public ExchangeValue
    retrieveExchangeValue(@PathVariable String fromCurrency,
                          @PathVariable String toCurrency)
    {
        LOGGER.info("Inside validate()");
        BigDecimal conversionMultiple = null;
        ExchangeValue exchangeValue = new ExchangeValue();
        if (fromCurrency != null && toCurrency != null) {
            if (fromCurrency.equalsIgnoreCase("USD")
                    && toCurrency.equalsIgnoreCase("NOK")) {
                conversionMultiple = BigDecimal.valueOf(10.90);
            }
            if (fromCurrency.equalsIgnoreCase("NOK")
                    && toCurrency.equalsIgnoreCase("USD")) {
                conversionMultiple
                        = BigDecimal.valueOf(0.093);
            }
            if (fromCurrency.equalsIgnoreCase("EUR")
                    && toCurrency.equalsIgnoreCase("NOK")) {
                conversionMultiple = BigDecimal.valueOf(12);
            }
            if (fromCurrency.equalsIgnoreCase("GBP")
                    && toCurrency.equalsIgnoreCase("NOK")) {
                conversionMultiple = BigDecimal.valueOf(14);
            }
        }
        exchangeValue = new ExchangeValue(
                1000L, fromCurrency, toCurrency,
                conversionMultiple);
        exchangeValue.setPort(Integer.parseInt(
                environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
