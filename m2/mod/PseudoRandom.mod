IMPLEMENTATION MODULE PseudoRandom;

FROM LongMath IMPORT
  exp, ln, pi;

VAR
  seed : LONGREAL;                          (* persistent across calls to Random() *)

(**************************************************************************************)
PROCEDURE InitSeed (x : LONGREAL);
  (* accessor (set) function for seed *)
BEGIN
  seed := x;
END InitSeed;

(**************************************************************************************)
PROCEDURE Random (): LONGREAL;
  (* Apply our pseudo-random algorithm to the seed and return the result *)
BEGIN
  seed := seed + pi;                    (* try to scramble up seed as much as possible *)
  seed := exp (5.0 * ln (seed));

  seed := seed - LFLOAT (TRUNC (seed));  (* just keep fractional part, in range 0..1 *)
  RETURN seed;
END Random;

(**************************************************************************************)
BEGIN
  seed := 0.0;                          (* initialize in body of module *)
END PseudoRandom.
