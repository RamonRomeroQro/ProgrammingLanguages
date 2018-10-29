// Java program to illustrate
// sleep() method in Java
import java.lang.*;

class SleepDemo1 implements Runnable {
	Thread t;
	public void run() {
		for (int i = 0; i < 4; i++)
		{
			System.out.println(Thread.currentThread().getName()
												+ "Y" + i);
			try
			{
				// thread to sleep for 1000 milliseconds
				Thread.sleep(1);
			}

			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}



class SleepDemo2 implements Runnable {
	Thread t;
	public void run() {
		for (int i = 0; i < 4; i++)
		{
			System.out.println(Thread.currentThread().getName()
												+ "X" + i);
			try
			{
				// thread to sleep for 1000 milliseconds
				Thread.sleep(1000);
			}

			catch (Exception e)
			{
				System.out.println(e);
			}
		}
	}
}



public class Main {


    public static void main(String[] args) {
			Thread t1 = new Thread(new SleepDemo1());
			Thread t2 = new Thread(new SleepDemo2());

		// call run() function
		t1.start();
		t2.start();

	}
}
