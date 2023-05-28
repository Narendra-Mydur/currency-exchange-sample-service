package microservices.example.currencyexchangesampleservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeSampleServiceApplication {

	private static final Logger LOGGER= LoggerFactory.getLogger(CurrencyExchangeSampleServiceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeSampleServiceApplication.class, args);

	}

}
