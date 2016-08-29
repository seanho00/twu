MODULE SphereVolume;

IMPORT STextIO, SRealIO;

PROCEDURE CalcVol (radius: REAL; VAR volume : REAL);
CONST
	Pi = 3.14159265358979323846;
BEGIN
	volume := (4.0 / 3.0) * Pi * rad * rad * rad;
END CalcVol;

VAR
	rad, vol : REAL;
BEGIN
	rad := 5.0;
	CalcVol (2.3, vol);
	SRealIO.WriteFixed (vol, 2, 0);
END SphereVolume.
