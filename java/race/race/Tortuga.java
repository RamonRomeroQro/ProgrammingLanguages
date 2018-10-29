//Ramon romero A01700318

import java.util.Random;

class Tortuga extends Thread {

  public double current;
  public double goal;
  public double speed;
  public double status;
  public Conejo con;


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
          System.out.println("Tortuga llega primero, Finaliza carrera");
          this.status=2;
          break;

        }
        if (this.con.status==2){
          //System.out.println("cone llega");
          break;

        }
      }


      }





}
