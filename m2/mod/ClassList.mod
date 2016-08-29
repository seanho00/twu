MODULE ClassList;
IMPORT StreamFile, RndFile, RawIO, STextIO, SWholeIO;
FROM StreamFile IMPORT
	ChanId, OpenResults, read, write, raw, old;
TYPE
	NameString = ARRAY [0..30] OF CHAR;
	Student = RECORD
		name : NameString;
		ID : CARDINAL;
		GPA : REAL;
	END;
	Class = ARRAY [0..29] OF Student;
VAR
	cmpt14x : Class;
	idx : CARDINAL;
	oneStudent : Student;
	cid : ChanId;
	res : OpenResults;
BEGIN
	cmpt14x := Class { Student { "Jane Doe", 0, 4.0 } BY 30 };

	StreamFile.Open (cid, "cmpt14x.bin", write+raw, res);
	IF res = opened THEN
		RawIO.Write (cid, cmpt14x);
	END;
	StreamFile.Close (cid);

	STextIO.WriteString ("The file should be");
	SWholeIO.WriteCard (SIZE (cmpt14x), 0);
	STextIO.WriteString (" LOCs long.");
	STextIO.WriteLn;

	idx := 17;
	RndFile.OpenOld (cid, "cmpt14x.bin", read+raw, res);
	IF res = opened THEN
		RndFile.SetPos (cid,
		  RndFile.NewPos (cid, idx-1, SIZE(Student),
		    RndFile.StartPos (cid)));
		RawIO.Read (cid, oneStudent);
	END;
	RndFile.Close (cid);
END ClassList.
