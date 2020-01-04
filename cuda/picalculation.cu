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



#include "cuda_runtime.h"
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define N 1000000
#define width 1.0 / N



__global__ void parallel_pi(double *sum){
    int index = threadIdx.x + blockIdx.x * blockDim.x;
    int id = index;

    while( id < N){
        double mid = (id + 0.5) * width;
        double height = 4.0 / (1.0 + mid * mid);
        sum[index] = sum[index] + height;
        id = id + blockDim.x * gridDim.x;
    }
}


int main(){
    double area = 0;
    double *p_array;
    double *suma;
    int size = 1000000;
    //allocate array
    suma = (double*) malloc(size * sizeof(double));
    cudaMalloc((void**) &p_array, size * sizeof(double));
    parallel_pi<<<int(1000000/1024)+1, 1024>>>(p_array);
    cudaMemcpy(suma, p_array, size * sizeof(double), cudaMemcpyDeviceToHost);
    //serial suma
    for (int i = 0; i < size; i++) {
        area += suma[i];
    }
    //result
    area = area * width;
    printf("PI= %f \t%i rectangles\n", area, size);
    free(suma);
    cudaFree(p_array);

    return 0;
}
