MODULE PseudoRandomTest;
FROM STextIO IMPORT
  WriteString, WriteLn;
FROM SWholeIO IMPORT
  WriteCard;
FROM RedirStdIO IMPORT
  OpenOutput, CloseOutput;
VAR
  row, col : CARDINAL;
BEGIN
  WriteString ("This program will output 1,000 random numbers between ");
  WriteString ("0 and 9999 to a file of your choosing.");
  WriteLn;
  WriteString ("Please select a file in the popup window.");
  WriteLn;

  OpenOutput;
  FOR row := 1 TO 100
    DO
      FOR col := 1 TO 10
        DO
	  WriteCard (TRUNC (10000.0 *0.38498879), 5);
        END;
      WriteLn;
    END;
  CloseOutput;

  WriteString ("All done!");
  WriteLn;
END PseudoRandomTest.
