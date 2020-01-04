
public class Main {


    public static void main(String[] args) {

      /*
      The lengnth of the race.
      The sleeping time of the rabbit
      The speed of the turtle.
      */


          System.out.println("Carrera de 10000 ft, rabbit sleeping time 0 ");

           double g=10000;
           Conejo c= new Conejo(g, 0);
           Tortuga t= new Tortuga(g);


              c.start();
              t.start();



            try {
              c.join();
              t.join();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Carrera de 10000 ft, rabbit sleeping time 500  ");

             g=10000;
             c= new Conejo(g, 500);
             t= new Tortuga(g);


                c.start();
                t.start();

              try {
                c.join();
                t.join();

              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("Carrera de 10000 ft, turtle steps 1000  ");

               g=10000;
               c= new Conejo(g);
               t= new Tortuga(g, 1000);


                  c.start();
                  t.start();

                try {
                  c.join();
                  t.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

              System.out.println("Carrera de 10000 ft, turtle steps 1  ");

               g=10000;
               c= new Conejo(g);
               t= new Tortuga(g, 1);


                  c.start();
                  t.start();

                try {
                  c.join();
                  t.join();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Carrera de 10000 ft");

                 g=10000;
                 c= new Conejo(g);
                 t= new Tortuga(g);


                    c.start();
                    t.start();


                  try {
                    c.join();
                    t.join();

                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }


                  System.out.println("Carrera de 100000 ft");

                   g=100000;
                   c= new Conejo(g);
                   t= new Tortuga(g);


                      c.start();
                      t.start();

                    try {
                      c.join();
                      t.join();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }




    }
}
