MODULE SubstitutionTest;

FROM STextIO IMPORT
  WriteString, WriteLn, ReadString, SkipLine;
FROM Substitution IMPORT
  Encode, Decode, CodeString;

TYPE
  String = ARRAY [0..255] OF CHAR;

VAR
  clearText, cipherText : String;
  codeKey : CodeString;

BEGIN
  codeKey := "QAZXSWEDCVFRTGBNHYUJMKIOLP";
  WriteString ("This program will use a substitution cipher with the following key:");
  WriteLn;
  WriteString (codeKey);
  WriteLn;
  WriteString ("Please enter the cleartext to be encrypted: ");
  ReadString (clearText);

  Encode (clearText, cipherText, codeKey);
  WriteString ("Here it is encrypted: ");
  WriteString (cipherText);
  WriteLn;

  Decode (cipherText, clearText, codeKey);
  WriteString ("Here it is decoded again: ");
  WriteString (clearText);
  WriteLn;

END SubstitutionTest.
