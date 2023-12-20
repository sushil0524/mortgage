package com.ing.mortgage;

import com.ing.mortgage.model.InterestRates;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@SpringBootApplication
public class MortgageApplication {

	public static void main(String[] args) {
		SpringApplication.run(MortgageApplication.class, args);
	}


	/*@Bean
	CommandLineRunner runner(InterestRates interestRates){

		return args -> {
			new InterestRates(2,3.5, Timestamp.timest);
		};
	}*/

}
