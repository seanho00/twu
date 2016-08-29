#include <omp.h>
#include <stdio.h>

int main (int argc, char *argv[]) {
  int id, nthreads;
  #pragma omp parallel private(id)
  {
    id = omp_get_thread_num();
    printf("Hello World from thread %d\n", id);

    #pragma omp single
    {
      nthreads = omp_get_num_threads();
      printf("Hi from %d: There are %d threads\n",id, nthreads);
    }

  }
  return 0;
}
