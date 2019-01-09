#include <stdio.h>
#include <stdlib.h>
#define LIMIT 1000000
#include <stdlib.h>
#include <time.h>
#include <sys/time.h>
#include <sys/types.h>

/*

long num_rects = 100000, i;
 double mid, height, width, area;
 double sum = 0.0;
 width = 1.0 / (double) num_rects;
 mid = (i + 0.5) * width;
 height = 4.0 / (1.0 + mid * mid);
 arr[i]= height;



*/

__global__ void cudapi(double* d_array){
    int i = blockIdx.x * blockDim.x + threadIdx.x;
    double mid, height, width;
    width = 1.0 / (double) LIMIT;
    mid = (i + 0.5) * width;
    height = 4.0 / (1.0 + mid * mid);
    d_array[i]= height;

}

int main(int argc, char* argv[]) {
  //////////INICIALIZACION
  double *p_array;
  double *arr;
  cudaMalloc((void**) &p_array, LIMIT * sizeof(double));
  arr = (double*)malloc(LIMIT * sizeof(double));
  cudapi<<<int(LIMIT/1024)+1, 1024>>>(p_array);
  cudaMemcpy(arr, p_array, LIMIT * sizeof(double), cudaMemcpyDeviceToHost);
  ///////////////
  int i;
  double r=0;
  for (i=0; i<LIMIT; i++){
    printf("%lf\n",arr[i] );
    r=r+arr[0];
  }
  double w=1.0/LIMIT;
  r=r*w;

  fprintf(stdout, "%lf\n", r);
  cudaFree(p_array);
	free(arr);


	return 0;
}
