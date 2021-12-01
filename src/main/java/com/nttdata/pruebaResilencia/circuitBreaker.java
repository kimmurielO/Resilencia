package com.nttdata.pruebaResilencia;

public class circuitBreaker {
	
	public int thre = 50;
	public int error = 1;
	public int contIntentos = 0;
	
	public void open() throws InterruptedException {
		Thread.sleep(100);
		halfClose();
	}
	
	public void halfClose() throws InterruptedException {
		if(contIntentos < thre) {
			contIntentos++;
			open();
		} else {
			close();
		}
	}
	
	public void close() throws InterruptedException {
		if(error == 1) {
			open();
		} else {
			close();
		}
	}

}
