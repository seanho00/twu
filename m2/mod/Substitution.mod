IMPLEMENTATION MODULE Substitution;

PROCEDURE IsLetter (ch: CHAR) : BOOLEAN;
  (* check if it's a letter or some other character *)
BEGIN
  RETURN ('A' <= CAP(ch)) AND (CAP(ch) <= 'Z');
END IsLetter;

PROCEDURE AlphaPos (ch: CHAR) : CARDINAL;
  (* index of a letter in the range 0..25 *)
BEGIN
  RETURN ORD(CAP(ch)) - ORD('A');
END AlphaPos;

PROCEDURE DecodeKey (enckey: CodeString; deckey: CodeString);
  (* create a decode key from an encoding key *)
BEGIN
END DecodeKey;

PROCEDURE Encode (src: ARRAY OF CHAR; VAR dst: ARRAY OF CHAR; key: CodeString);
  (* encrypt the source string with the key; store result in dst *)
VAR
  idx : CARDINAL;
BEGIN
  FOR idx := 0 TO LENGTH (src)
    DO
      IF IsLetter (src[idx])
        THEN
          dst[idx] := key[ AlphaPos (src[idx]) ];
        ELSE
          dst[idx] := src[idx];
        END;
  END
  dst[LENGTH(src)] := "";
END Encode;

PROCEDURE Decode (src: ARRAY OF CHAR; VAR dst: ARRAY OF CHAR; key: CodeString);
  (* decode the source string that was encrypted with the given key;
   * store result in dst *)
BEGIN
END Decode;

END Substitution.