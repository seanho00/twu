COMPUTE df = n1+n2-2.
COMPUTE poolvar = (((n1-1)*(sd1 ** 2))+((n2-1)*(sd2 ** 2)))/df.
COMPUTE poolsd = sqrt((((n1-1)*(sd1 ** 2))+((n2-1)*(sd2 ** 2)))/(n1+n2)).
COMPUTE d = (x1-x2)/poolsd .
COMPUTE t = (x1-x2)/sqrt(poolvar*((1/n1)+(1/n2))).
COMPUTE sig = 2*(1-(CDF.T(abs(t),df))) .
Variable labels poolsd 'Pooled SD'.
Variable labels d 'Effect Size (d)'.
Variable labels t 't'.
Variable labels sig 'Significance (2-tailed)'.
Formats sig(F8.5).
EXECUTE .

SUMMARIZE
  /TABLES= Outcome x1 x2 poolsd df t sig d
  /FORMAT=VALIDLIST NOCASENUM TOTAL LIMIT=100
  /TITLE='T-test'
  /MISSING=VARIABLE
  /CELLS=NONE.
