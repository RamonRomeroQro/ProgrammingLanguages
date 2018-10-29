
/*----------------------------------------------------------------
* Actividad de programación: Calculando Pi con threads en Java
* Multithread program
* Fecha: 15-Sep-2018
* Autor: A01700318 Jose Ramon Romero Chavez
*--------------------------------------------------------------*/

import java.util.Random;

class Tortuga extends Thread {

  public double current;
  public double goal;
  public double speed;
  public double status;


    public Tortuga(double g){
      this.current = 0;
      this.goal = g;
      this.speed=-1;
      this.status=1;


    }

    public Tortuga(double g, double s){
      this.current = 0;
      this.goal = g;
      this.speed=s;
      this.status=1;


    }



    public double getCurrent() {
        return current;
    }


    public void run() {
      while(3>1){

        if (speed==-1){
          Random rand = new Random();
          int randomNum = rand.nextInt((10 - 3) + 1) + 3;
          //System.out.println("Turtle:"+this.current);
          this.current=getCurrent()+randomNum;

        }else{
          this.current=getCurrent()+this.speed;


        }




        if (getCurrent()>=this.goal){
          System.out.println("tortuga llega");
          this.status=2;
          break;

        }
        if (this.status==0){
          //System.out.println("cone llega");
          break;

        }
      }


      }





}
