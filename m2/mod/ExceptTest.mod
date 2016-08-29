MODULE ExceptTest;

FROM M2EXCEPTION IMPORT
	M2Exceptions, IsM2Exception, M2Exception;
FROM EXCEPTIONS IMPORT
	IsExceptionalExecution;
FROM STextIO IMPORT
	WriteString, WriteLn;
FROM SRealIO IMPORT
	WriteFixed;

PROCEDURE FloorDivide (num, denom : REAL) : REAL;
BEGIN
	RETURN FLOAT ( INT (num) / INT (denom) );
EXCEPT
	IF IsExceptionalExecution() AND
	  (M2Exception() = sysException) THEN
		WriteString (" div-by-zero!");
	END;
END FloorDivide;

VAR ptr : POINTER TO REAL;
BEGIN
	WriteFixed ( FloorDivide ( 14.2, 5.9 ), 0, 0 );
	WriteFixed ( FloorDivide (  1.5, 0.5 ), 0, 0 );
	WriteFixed ( FloorDivide (  6.8, 2.1 ), 0, 0 );
EXCEPT
	IF IsExceptionalExecution() THEN
		WriteString (" bummer!");
		RETURN;
	END;
END ExceptTest.
