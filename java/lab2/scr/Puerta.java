/*

  Jose Ramon Romero Chavez
  A01700318
  Lenguajes Lab2 Java

*/


public class Puerta{
	private int adentro;
  private int afuera;
	private int lado;

	public Puerta(int a) {
		this.adentro = 0;
		this.afuera = 0;
		this.lado = a;
	}

	public synchronized void entra(Puerta aux) {
		this.adentro++;
		if (this.lado==0){
			System.out.println("Persona llega por puera Oeste");
		}else{
			System.out.println("Persona llega por puerta Este");
		}
	}

	public synchronized void sale(Puerta aux){
		this.afuera++;
		if (this.lado==0){
			System.out.println("Persona sale por puerta Oeste");
		}else{
			System.out.println("Persona sale por puera Este");
		}
	}

	public synchronized int cantidad(){
		return this.adentro - this.afuera;
	}
	public void current(Puerta otra){
		System.out.println("Cantidad de Personas en el Interior del Jardin: "+ (otra.cantidad() + this.cantidad()));
	}
}
