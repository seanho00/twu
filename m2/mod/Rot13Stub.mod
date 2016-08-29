MODULE Rot13Stub;

FROM STextIO IMPORT
  ReadChar, WriteChar;
FROM SWholeIO IMPORT
  WriteCard;
FROM SIOResult IMPORT
  ReadResult, ReadResults;

VAR
  ch : CHAR;
  ascii : CARDINAL;

BEGIN
  ReadChar (ch);
  WHILE ReadResult() <> endOfLine       (* Read until end of line *)
    DO
      ascii := VAL (CARDINAL, ch);
      WriteCard (ascii, 0);
      WriteChar (VAL (CHAR, ascii));
      ReadChar (ch);
    END;
END Rot13Stub.
