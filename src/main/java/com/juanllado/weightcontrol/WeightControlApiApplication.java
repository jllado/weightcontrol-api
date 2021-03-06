package com.juanllado.weightcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
		basePackageClasses = { WeightControlApiApplication.class, Jsr310JpaConverters.class }
)
@SpringBootApplication
public class WeightControlApiApplication {

	public WeightControlApiApplication() { //NOSONAR
		//spring boot app
	}

	public static void main(String[] args) {
		SpringApplication.run(WeightControlApiApplication.class, args);
	}
}
