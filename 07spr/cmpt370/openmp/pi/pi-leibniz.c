/*
 * Compute pi by approximating the area under the curve f(x) = 4 / (1 + x*x)
 * between 0 and 1.
 *
 * parallel version using OpenMP
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>	/* clock() */
#include <omp.h>	/* OpenMP */

int main(int argc, char *argv[]) {

    double start_time, end_time;
    double x, sum=0.0, pi=0.0;
    int i, num_threads;

    const char Usage[] = "Usage: pi <num_steps> (try 200000000)\n";
    if (argc < 2) {
	fprintf(stderr, Usage);
	exit(1);
    }
    int num_steps = atoi(argv[1]);
    double step = 1.0/(double) num_steps;

    /* record start time */
    start_time = omp_get_wtime();

    /* do computation -- using all available threads */
    #pragma omp parallel
    {

	#pragma omp master 
	{
	    num_threads = omp_get_num_threads();
	    printf("Computing pi via Leibniz: %d steps, %d threads\n",
		    num_steps, num_threads);
	}

        #pragma omp for private(x) reduction(+:sum)
        for (i=0; i < num_steps; ++i) {
            x = (i+0.5)*step;
            sum += 4.0/(1.0+x*x);
        }
        #pragma omp master
        {
            pi = step * sum;
        }
    }

    /* record end time */
    end_time = omp_get_wtime();

    /* print results */
    printf("pi = %32.30f\n", pi);
    printf("time to compute = %g seconds\n", end_time - start_time);

    return EXIT_SUCCESS;
}
