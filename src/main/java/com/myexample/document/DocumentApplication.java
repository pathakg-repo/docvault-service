package com.myexample.document;

import com.myexample.document.service.DocumentService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
@EnableAutoConfiguration
public class DocumentApplication implements CommandLineRunner {

	@Resource
	DocumentService documentService;
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	public static void main(String[] args) {
		SpringApplication.run(DocumentApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		documentService.init();
	}
}
