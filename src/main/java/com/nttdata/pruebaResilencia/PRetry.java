package com.nttdata.pruebaResilencia;

public class PRetry {
	
	public void pRetry(int error) {
		
		int umbral = 9;
		
		try {
			
			System.out.println("He fallado");
			Thread.sleep(1000);
			
			if(error >= umbral) {
				System.err.println("He pasado el umbral de fallos");
			}
			
		} catch (Exception e) {
				
		}
	}
}
