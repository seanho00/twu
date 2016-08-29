MANOVA
  beerpos beerneg beerneut winepos wineneg wineneut waterpos waterneg waterneu 
/WSFACTORS  drink(3) imagery(3)
/WSDESIGN = MWITHIN  drink(1) MWITHIN  drink(2) MWITHIN  drink(3)
 /PRINT    
	SIGNIF( UNIV MULT AVERF HF GG ).


MANOVA
  beerpos beerneg beerneut winepos wineneg wineneut waterpos waterneg waterneu 
/WSFACTORS  drink(3) imagery(3)
/WSDESIGN = MWITHIN  imagery(1) MWITHIN  imagery(2) MWITHIN  imagery(3)
 /PRINT    
	SIGNIF( UNIV MULT AVERF HF GG ).