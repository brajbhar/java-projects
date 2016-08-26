package org.cybercafe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"org.cybercafe.service", "org.cybercafe.controller", "org.cybercafe.repository"})
public class TestCyberomApplication implements CommandLineRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(TestCyberomApplication.class, args);
    }
    
    @Override
    public void run(String... strings ) throws Exception {
    	
    }
}
