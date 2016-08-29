/*
 * Compute pi by Monte Carlo calculation of area of a circle
 *
 * parallel version using OpenMP
 */
#include <stdio.h>
#include <stdlib.h>
#include <time.h>	/* clock() */
#include <omp.h>	/* OpenMP */

int main(int argc, char *argv[]) {

    double start_time, end_time;
    double x, y, pi;
    int i, count, num_steps, num_threads;

    const char Usage[] = "Usage: pi <num_steps> (try 2000000)\n";
    if (argc < 2) {
	fprintf(stderr, Usage);
	exit(1);
    }
    num_steps = atoi(argv[1]);

    /* record start time */
    start_time = omp_get_wtime();

    /* do computation -- using all available threads */
    #pragma omp parallel private(x,y) shared(count)
    {

	#pragma omp master 
	{
	    num_threads = omp_get_num_threads();
	    printf("Computing pi via Monte Carlo: %d steps, %d threads\n",
		    num_steps, num_threads);
	}

        #pragma omp for
        for (i=0; i < num_steps; i++) {
            x = (double) rand()/RAND_MAX;
            y = (double) rand()/RAND_MAX;
            if (x*x + y*y < 1) count++;
        }
    }
    pi = 4.0 * count / num_steps;

    /* record end time */
    end_time = omp_get_wtime();

    /* print results */
    printf("pi = %32.30f\n", pi);
    printf("time to compute = %g seconds\n", end_time - start_time);

    return EXIT_SUCCESS;
}
