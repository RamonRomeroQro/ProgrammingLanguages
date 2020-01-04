
// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.
// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <https://www.gnu.org/licenses/>.



public class Test {


    public static void main(String args[]){


        // filling the matrix to test the code


        int start = 0 , end = 2;


        int[][]  matA= new int[end][end];


        int[][]  matB= new int[end][end];


        int[][]  matResult= new int[end][end];



        for(int i = 0; i< end; i++){


            for(int j = 0; j< end; j++){


                matA[i][j]= 1; matB[i][j]= 1;  matResult[i][j] = 0;


            }


        }

        // filling the matrix to test the code

        // the expected result maybe [[2,2][2,2]]


//case
        Thread pool []= new Thread[end];
        for (int i=0; i<end; i++ ) {
        pool[i] = new Thread(new Addmat(matA, matB, matResult, 0, end, i));
        }

        for (int i=0; i<end; i++ ) {
        pool[i].start();
        }

        try {
        for (int i=0; i<end; i++ ) {
        pool[i].join();
        }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }





/*
        //here add, index as the extra parameter to paralelize
        Addmat add1 = new Addmat(matA, matB, matResult, 0, end, 0);


        Addmat add2 = new Addmat(matA, matB, matResult, 0, end, 1);





        Thread t1 = new Thread(add1);


        Thread t2 = new Thread(add2);





        t1.start();
        t2.start();

        try {
          t1.join();
          t2.join();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

*/

      //print the result
      System.out.print(" Example 1 result (BaseCode): \n\n");




        for(int i = 0; i< end; i++){


            for(int j = 0; j< end; j++){


                System.out.print(" " + matResult[i][j]);


            }


            System.out.print("\n");


        }


        /*Test 2*/
        System.out.print(" Example 2 result: \n\n");

        matA[0][0]=1;
        matA[0][1]=1;
        matA[1][0]=1;
        matA[1][1]=1;

        matB[0][0]=1;
        matB[0][1]=1;
        matB[1][0]=1;
        matB[1][1]=1;


        matResult[0][0]=1;
        matResult[0][1]=1;
        matResult[1][0]=1;
        matResult[1][1]=1;


        for (int i=0; i<end; i++ ) {
        pool[i] = new Thread(new Addmat(matA, matB, matResult, 0, end, i));
        }

        for (int i=0; i<end; i++ ) {
        pool[i].start();
        }

        try {
        for (int i=0; i<end; i++ ) {
        pool[i].join();
        }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }


        //print the result



        for(int i = 0; i< end; i++){


            for(int j = 0; j< end; j++){


                System.out.print(" " + matResult[i][j]);


            }


            System.out.print("\n");


        }





/*Test 3*/
System.out.print(" Example 3 result: \n\n");

matA[0][0]=10;
matA[0][1]=1;
matA[1][0]=1;
matA[1][1]=3;

matB[0][0]=0;
matB[0][1]=4;
matB[1][0]=1;
matB[1][1]=5;


matResult[0][0]=1;
matResult[0][1]=1;
matResult[1][0]=0;
matResult[1][1]=0;

for (int i=0; i<end; i++ ) {
pool[i] = new Thread(new Addmat(matA, matB, matResult, 0, end, i));
}

for (int i=0; i<end; i++ ) {
pool[i].start();
}

try {
for (int i=0; i<end; i++ ) {
pool[i].join();
}
} catch (InterruptedException e) {
  e.printStackTrace();
}

//print the result



for(int i = 0; i< end; i++){


    for(int j = 0; j< end; j++){


        System.out.print(" " + matResult[i][j]);


    }


    System.out.print("\n");


}





/*


matB[0][0]=0;
matB[0][1]=4;
matB[1][0]=1;
matB[1][1]=5;


matResult[0][0]=1;
matResult[0][1]=1;
matResult[1][0]=0;
matResult[1][1]=0;


 add1 = new Addmat(matA, matB, matResult, 0, end, 0);


 add2 = new Addmat(matA, matB, matResult, 0, end, 1);





 t1 = new Thread(add1);


 t2 = new Thread(add2);





t1.start();
t2.start();

try {
  t1.join();
  t2.join();
} catch (InterruptedException e) {
  e.printStackTrace();
}



//print the result



for(int i = 0; i< end; i++){


    for(int j = 0; j< end; j++){


        System.out.print(" " + matResult[i][j]);


    }


    System.out.print("\n");


}










*/



    }


}
