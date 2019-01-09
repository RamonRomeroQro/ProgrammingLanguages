/*
Jose Ramon Romero Chavez
A01700318

*/


public class Addmat implements  Runnable{




    int [][] mat1;  int [][] mat2;  int [][] mat3;


    int begin; int end; int index;





    public Addmat(int[][] m1, int[][] m2, int[][] m3, int b, int e, int i){


        mat1 = m1;  mat2 = m2;  mat3 = m3;  begin = b;  end = e; index = i;



    }





    @Override


    public void run() {


            for(int j = 0; j< end; j++){


                mat3[index][j] =  mat1[index][j]+mat2[index][j]+mat3[index][j];


            }


    }


}
