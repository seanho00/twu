MODULE HelloWorld;

IMPORT RedirStdIO;

FROM STextIO IMPORT
  ReadChar, WriteChar, WriteString, WriteLn, SkipLine;
FROM SWholeIO IMPORT
  ReadCard, ReadInt, WriteCard, WriteInt;
FROM SRealIO IMPORT
  ReadReal, WriteReal, WriteFloat, WriteFixed;
FROM Strings IMPORT
	Compare, CompareResults;
FROM StreamFile IMPORT
	Open, Close, ChanId, OpenResults, read, write, old, raw;
IMPORT RawIO;
FROM Storage IMPORT
  ALLOCATE, DEALLOCATE;

TYPE
	DoubList = POINTER TO DoubListNode;
	DoubListNode = RECORD
		data : REAL;
		prev, next : DoubList;
	END;

VAR
  card1, card2 : CARDINAL;
  int1, int2 : INTEGER;
  real1, real2 : REAL;
  ans, char1, char2 : CHAR;
	quit, error, bool1, bool2 : BOOLEAN;
	cid1, cid2 : ChanId;
	res : OpenResults;

	dlist : DoubList;

PROCEDURE Delete (VAR head : DoubList; delidx : CARDINAL);
VAR
	cur : DoubList;
	idx : CARDINAL;
BEGIN
	cur := head;
	idx := 0;
	WHILE (idx < delidx) AND (cur # NIL) DO
		cur := cur^.next;
		INC (idx);
	END;

	IF cur = NIL THEN
		WriteString ("node doesn't exist!");
		RETURN;
	END;

	IF delidx = 0 THEN	(* special case: delete head *)
		head := head^.next;
	END;

	IF cur^.prev # NIL THEN
		cur^.prev^.next := cur^.next;
	END;
	IF cur^.next # NIL THEN
		cur^.next^.prev := cur^.prev;
	END;
	DISPOSE (cur);
END Delete;

BEGIN

  WriteString ("All done!  Press Enter to quit.");
  WriteLn;
  ReadCard (card1);
END HelloWorld.
