************************************************************.
*   Author: Andy Field, University of Sussex, UK    .
************************************************************.

MATRIX.
GET n1 /VARIABLES = n1.
GET r1 /VARIABLES = r1.
GET n2 /VARIABLES = n2.
GET r2 /VARIABLES = r2.
COMPUTE z1 = 0.5*(ln((1+r1)/(1-r1))).
COMPUTE z2 = 0.5*(ln((1+r2)/(1-r2))).
COMPUTE SEdiff = sqrt((1/(n1-3)) + (1/(n2-3))).
COMPUTE zdiff = (z1-z2)/SEdiff.
COMPUTE sigz = 2*(1-cdfnorm(abs(zdiff))).
COMPUTE output = {(r1-r2), zdiff, sigz}.

print "*** Tests of Differences between Independent Correlation Coefficiants ***".
print output /TITLE = "  Raw Difference        z           Sig".
END MATRIX.




