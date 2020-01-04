
/*----------------------------------------------------------------
* Actividad de programación: Calculando Pi con threads en Java
* Multithread program
* Fecha: 15-Sep-2018
* Autor: A01700318 Jose Ramon Romero Chavez
*--------------------------------------------------------------*/

import java.util.Random;



class Conejo extends Thread {

  public double current;
  public double goal;
  public double lazy;
  public double status;




  public Conejo(double g) {
      this.current   = 0;
      this.goal=g;
      this.lazy=-1;
      this.status=1;


  }
  public Conejo(double g, double l) {
      this.current   = 0;
      this.goal=g;
      this.lazy=l;
      this.status=1;



  }

    public double getCurrent() {
        return current;
    }


    public void run() {
      while(3>1){
        Random rand = new Random();
        int randomNum = rand.nextInt((1000 - 500) + 1) + 500;
        this.current=getCurrent()+randomNum;
        try
  			{
  				// thread to sleep for 1000 milliseconds

          if (lazy==-1)

            if (randomNum%2==0){
               super.sleep(100);
            }else{
              super.sleep(200);
            }
          else{
            super.sleep((int)this.lazy);


          }

  			}

  			catch (Exception e)
  			{
  				System.out.println(e);
  			}
        if (getCurrent()>=this.goal){
          System.out.println("Conejo llega");
          this.status=2;
          break;

        }
        if (this.status==0){
          //System.out.println("Conejo llega");
          break;

        }

      }


      /*

          if (randomNum%2==0){
            Thread.sleep(200);
            //System.out.println("Bunny: Avanza "+randomNum+" a "+this.current +" duerme 200 ms");

          }else{
            Thread.sleep(100);
            //System.out.println("Bunny: Avanza "+randomNum+" a "+this.current +" duerme 100 ms");

          }

        */





      }



    }
