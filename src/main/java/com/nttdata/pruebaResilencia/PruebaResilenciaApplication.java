package com.nttdata.pruebaResilencia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PruebaResilenciaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaResilenciaApplication.class, args);
	}
	
	public void run() throws InterruptedException{
		for(int i=1;i<10;i++) {
			circuitBreaker circuitBreaker = new circuitBreaker();
			// Entro en el close porque tengo error
			circuitBreaker.close(i);
		}
		
		for(int i=0;i<10;i++) {
			PRetry PRetry = new PRetry();
			PRetry.pRetry(i);
		}
	}

}
