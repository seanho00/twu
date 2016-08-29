MODULE BankInterest;

(* Name: Nellie Hacker
 * Student Number: 922001
 * CMPT 140 Fall 2005
 * Lab 00
 * Bank Interest Computation
 *)

FROM STextIO IMPORT
  WriteString, WriteLn, SkipLine;

FROM SWholeIO IMPORT
  WriteCard;

FROM SRealIO IMPORT
  ReadReal, WriteFixed;

CONST
  time = 0.25; (* i.e., one quarter *)

VAR
  principal, rate, interest, withdrawl: REAL;
  quarter: CARDINAL;

BEGIN
  WriteString ("This program computes interest on an account");
  WriteLn;
  WriteString ("quarterly, and then allows for withdrawals.");
  WriteLn;
  WriteLn;
  WriteString ("It was written by");
  WriteLn;
  WriteString ("Nellie Hacker");
  WriteLn;
  WriteString ("for CMPT 140");
  WriteLn;
  WriteString ("Lab 00 Due 14 Sep 2005");
  WriteLn;
  WriteLn;
  WriteString ("What is the opening balance? ");
  ReadReal (principal);
  SkipLine;
  WriteLn;
  WriteString ("What is the annual interest rate? ");
  WriteLn;
  WriteString ("Enter as a decimal; E.g.: 6.5% is 0.065. == ");
  ReadReal (rate);
  SkipLine;
  WriteLn;

  quarter := 1;
  WHILE quarter <= 4
    DO
      interest := principal * rate * time;
      principal := principal + interest;        (* compute new principal *)
      WriteString ("What is the withdrawal in quarter number ");
      WriteCard (quarter, 0);
      WriteString ("? == ");                    (* complete a readable prompt *)
      ReadReal (withdrawl);
      SkipLine;
      WriteLn;
      principal := principal - withdrawl;      (* recompute principal *)
      quarter := quarter + 1;
    END;

  WriteString ("The final balance in your account is $ ");
  WriteFixed (principal, 2, 0);
  WriteLn;

  WriteString ("Press Enter to exit.");
  ReadReal (withdrawl);
END BankInterest.
