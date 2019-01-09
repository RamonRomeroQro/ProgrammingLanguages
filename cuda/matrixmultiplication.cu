// Ramon Romero A01700318
// Cuda Lab 2
// 15/11/18

#include "cuda_runtime.h"
#include <stdio.h>
#include <time.h>
#include <stdlib.h>

#define NUMBER_OF_THREADS 1024



//iterate over the matrix as it were a unidimensional array
__global__ void matrixmultiplication(int *a, int *b, int *c, int ra, int ca, int rb, int cb){
	int id = threadIdx.x + blockIdx.x* blockDim.x;
	int result = 0;
	while (id < ra * cb){
		int idra = id/cb;
		int idcb = id%cb;

		for (int i = 0; i < ca; i++){
			result+= a[idra * ca + i] * b[cb * i + idcb];
		}

		c[id] = result;
		id += blockDim.x * gridDim.x;
	}
}

int main (){
	printf("\nValidation for a non square matrixmultiplication case (3): \n");


/*
3)

original mats
1.00    2.00
3.00    4.00
5.00    6.00

6.00    7.00    8.00
9.00    0.00    1.00

*/
int rows_a = 3;
int cols_a = 2;
int rows_b = 2;
int cols_b = 3;
	int *dev_a, *dev_b, *dev_c;
	int *a, *b, *c;
	int number_of_threads;

//Validate
	if (cols_a == rows_b){
		a = (int *) malloc(sizeof(int) * rows_a * cols_a);
		b = (int *) malloc(sizeof(int) * rows_b * cols_b);
		c = (int *) malloc(sizeof(int) * rows_a * cols_b);
		cudaMalloc((void **)&dev_a, sizeof(int) * rows_a * cols_a);
		cudaMalloc((void **)&dev_b, sizeof(int) * rows_b * cols_b);
		cudaMalloc((void **)&dev_c, sizeof(int) * rows_a * cols_b);


		a[0]=1.00;
		a[1]=2.00;
		a[2]=3.00;
		a[3]=4.00;
		a[4]=5.00;
		a[5]=6.00;

		b[0]=6.00;
		b[1]=7.00;
		b[2]=8.00;
		b[3]=9.00;
		b[4]=0.00;
		b[5]=1.00;


		printf("\nA: \n\n");
		for (int i = 0; i < rows_a * cols_a; i++){
			if (i%cols_a == 0 && i != 0){
				printf("\n");
			}
			printf("%i ", a[i]);
		}
		printf("\n");

		printf("\nB: \n\n");
		for (int i = 0; i < rows_b * cols_b; i++){
			if (i%cols_b == 0 && i != 0){
				printf("\n");
			}
			printf("%i ", b[i]);
		}
		printf("\n");

		cudaMemcpy(dev_a, a, sizeof(int) * rows_a * cols_a, cudaMemcpyHostToDevice);
		cudaMemcpy(dev_b, b, sizeof(int) * rows_b * cols_b, cudaMemcpyHostToDevice);



		number_of_threads = (rows_a*cols_b + NUMBER_OF_THREADS - 1) / NUMBER_OF_THREADS;

		dim3 dimGrid(number_of_threads,1,1);
		dim3 dimBlock(NUMBER_OF_THREADS,1,1);



		matrixmultiplication<<<dimGrid, dimBlock>>>(dev_a, dev_b, dev_c, rows_a, cols_a, rows_b, cols_b);


		cudaMemcpy(c, dev_c, sizeof(int) * rows_a * cols_b, cudaMemcpyDeviceToHost);
		printf("Result Matrix:\n");
		for (int i = 0; i < rows_a * cols_b; i++){
			if (i%cols_b == 0 && i != 0){
				printf("\n");
			}
			printf("%i ", c[i]);
		}
		printf("\n");

		free(a);
		free(b);
		free(c);

		cudaFree(dev_a);
		cudaFree(dev_b);
		cudaFree(dev_c);
	}


	else {
		printf("Cols A must be equal to rows B");
	}
}
