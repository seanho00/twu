DESCRIPTIVES
  VARIABLES= day2  /SAVE.

COMPUTE outlier1 = abs(zday2) .
EXECUTE .

RECODE
  outlier1  (3.29 thru Highest = 4) (2.58 thru Highest=3)  (1.96 thru Highest=2)
  (Lowest thru 2=1)  .
EXECUTE .

VALUE LABELS outlier1 
   1 'Absolute z-score less than 2' 2 'Absolute z-score greater than 1.96' 3 'Absolute z-score greater than 2.58' 4 'Absolute z-score greater than 3.29' .

FREQUENCIES
  VARIABLES=outlier1
  /ORDER=  ANALYSIS .

