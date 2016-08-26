package org.cybercafe;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("org.cybercafe")
public class CyberomApplication implements CommandLineRunner {
	
    public static void main(String[] args) {
        SpringApplication.run(CyberomApplication.class, args);
    }
    
    @Override
    public void run(String... strings ) throws Exception {
    	
    }
}
