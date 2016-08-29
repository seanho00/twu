MODULE Rot13;

FROM STextIO IMPORT
  ReadChar, WriteChar, WriteLn, SkipLine;
FROM SIOResult IMPORT
  ReadResult, ReadResults;

CONST
  ASCIIA = VAL (CARDINAL, 'A');
  ASCIIZ = VAL (CARDINAL, 'Z');
  ASCIIa = VAL (CARDINAL, 'a');
  ASCIIz = VAL (CARDINAL, 'z');

VAR
  ch : CHAR;
  ascii : CARDINAL;

BEGIN
  ReadChar (ch);
  WHILE ReadResult() <> endOfLine       (* Read until end of line *)
    DO
      ascii := VAL (CARDINAL, ch);
      IF (ascii >= ASCIIA) AND (ascii <= ASCIIZ)          (* uppercase letter *)
        THEN
          ascii := ascii + 13;
          IF (ascii > ASCIIZ)                           (* wrap-around *)
            THEN
              ascii := ascii - 26;
            END;
        ELSIF (ascii >= ASCIIa) AND (ascii <= ASCIIz) THEN (* lowercase letter *)
          ascii := ascii + 13;
          IF (ascii > ASCIIz)                           (* wrap-around *)
            THEN
              ascii := ascii - 26;
            END;
        END;
      WriteChar (VAL (CHAR, ascii));
      ReadChar (ch);
    END;
END Rot13.
