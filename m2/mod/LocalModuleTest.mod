MODULE LocalModuleTest;
FROM STextIO IMPORT
	ReadChar;
FROM SRealIO IMPORT
	WriteFixed;

VAR
	pvar : REAL;
	char : CHAR;

MODULE Child1;
	EXPORT c1var;
	VAR
		c1var : REAL;
END Child1;

MODULE Child2;
	IMPORT Child1;
	VAR
		c2var : REAL;
END Child2;

BEGIN
	c1var := 10.0;
	WriteFixed(c1var, 0, 0);
	ReadChar (char);
END LocalModuleTest.
