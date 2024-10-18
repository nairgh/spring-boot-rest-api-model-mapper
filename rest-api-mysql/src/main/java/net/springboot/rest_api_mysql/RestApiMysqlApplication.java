package net.springboot.rest_api_mysql;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RestApiMysqlApplication {
    @Bean
	public ModelMapper modelMapper(){

	 return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(RestApiMysqlApplication.class, args);
	}

}
