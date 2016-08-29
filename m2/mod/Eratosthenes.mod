MODULE Eratosthenes;
(* Sieve of Eratosthenes
 * List all primes up to a given number
 * Modula-2 text section 5.9
 *)

FROM STextIO IMPORT
	WriteString, WriteLn, ReadChar;
FROM SWholeIO IMPORT
	ReadCard, WriteCard;
FROM RealMath IMPORT
	sqrt;

(* The primeFlags array must be allocated with fixed size *)
CONST
	veryBiggestSize = 1000;

VAR
	max : CARDINAL;

(* Print out all the primes up to the given number.
 * Pre: maxprime <= veryBiggestSize
 * Post: all primes between 2 and maxprime are printed to screen
 *)
PROCEDURE ListPrimes (maxprime : CARDINAL);
VAR
	primeFlags : ARRAY [1 .. veryBiggestSize] OF BOOLEAN;
	testNum, testNumMultiple : CARDINAL;
BEGIN

	(************* Fill-in code here ***************)

END ListPrimes;

(* Main module code *)
BEGIN
	WriteString ("Welcome to the fearsome Sieve of Eratosthenes!");
	WriteLn;
	WriteString ("You will be dazzled, you will be amazed at the primes!");
	WriteLn;
	WriteString ("Ask me to find all the primes up to: ");
	ReadCard (max);
	IF max > veryBiggestSize
		THEN
			WriteString ("Sorry, I can only find primes up to");
			WriteCard (veryBiggestSize, 0);
		ELSE
			ListPrimes (max);
		END;
END Eratosthenes.
