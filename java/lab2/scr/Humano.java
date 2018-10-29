/*

  Jose Ramon Romero Chavez
  A01700318
  Lenguajes Lab2 Java

*/


import java.util.Random;

public class Humano extends Thread {
	private Puerta oeste;
  private Puerta este;

	public Humano(Puerta oeste, Puerta este) {
		this.oeste = oeste;
		this.este = este;
	}

	public void run() {
		Random r = new Random();
			try {
				sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(r.nextInt(2) == 0){
				oeste.entra(este);
			}else{
				este.entra(oeste);
			}
			try {
				sleep(r.nextInt(1000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			oeste.current(este);
			if( r.nextInt(2) == 0){
				oeste.sale(este);
			}else{
				este.sale(oeste);
			}

	}
}
