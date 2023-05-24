package com.codekul.java21febspring;

import com.codekul.java21febspring.ioc.Jio;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Java21febspringApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Java21febspringApplication.class, args);
		Jio jio = context.getBean(Jio.class);
		jio.calling();
	}

	@GetMapping("hello")
	public String hello(){
		return "Hello spring";
	}

}
