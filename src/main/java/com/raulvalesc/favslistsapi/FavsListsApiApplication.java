package com.raulvalesc.favslistsapi;

import com.raulvalesc.favslistsapi.shared.domain.injectable.Injectable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Injectable.class)
)
public class FavsListsApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(FavsListsApiApplication.class, args);
	}
}
