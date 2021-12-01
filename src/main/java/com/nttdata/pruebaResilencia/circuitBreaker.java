package com.nttdata.pruebaResilencia;

public class circuitBreaker {
	
	public int thre = 9;
	public int contIntentos = 0;
	
	public void open() throws InterruptedException {
		try {
			
			System.out.println("Entro en Open");
			// Espero y me voy a half-close
			Thread.sleep(1000);
			halfClose();
		
		} catch (Exception e) {
			
		}
	}
	
	public void halfClose() throws InterruptedException {
		System.out.println("Entro en Close");
		// Si supero el umbral me voy a close, sino a open
		if(contIntentos < thre) {
			contIntentos++;
			open();
		} else {
			close(0);
		}
	}
	
	public void close(int error) throws InterruptedException {
		System.out.println("Entro en Close");
		if(error > 0) {
			// Si tengo errores me voy a open
			open();
		} else {
			// Si no tengo errores me voy a close
			error = 0;
			close(error);
		}
	}

}
