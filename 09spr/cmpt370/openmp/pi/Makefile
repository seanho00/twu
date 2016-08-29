# OpenMP Makefile
################################

# Paths specific to our project
INC = ./
SRC = ./
OBJ = ./

# Compiler flags
CFLAGS   = -O2 -I. -I$(INC) -fopenmp
CXXFLAGS = -O2 -I. -I$(INC) -fopenmp

# Libraries
LDLIBS   = -lm
OMP_LIB	 = -lgomp
X11_LIB  = -L/usr/X11R6/lib -lX11

# Set compiler executable
CXX	= g++4
CC	= gcc4

#.SILENT: # Make the build run quietly

#########################################################
# Compile rules for basic filetypes
.SUFFIXES: .c .cxx .cpp .cc .h .o

# Rule to build an object file from a C++ source file
$(OBJ)/%.o : %.cxx
	@echo Compile $@...
	$(CXX) -c -o $@ $< $(CXXFLAGS)

# Rule to build an object file from a C source file
$(OBJ)/%.o : %.c
	@echo Compile $@...
	$(CC) -c -o $@ $< $(CFLAGS)

#########################################################
# define rules for the known targets...

pi-leibniz: pi-leibniz.o
	@echo Linking $@...
	$(CC) $< $(OMP_LIB) $(X11_LIB) $(LDLIBS) -o $@

pi-monte: pi-monte.o
	@echo Linking $@...
	$(CC) $< $(OMP_LIB) $(X11_LIB) $(LDLIBS) -o $@

all: pi-leibniz

#########################################################
# Housekeeping

clean: FORCE
	-rm -f *.o          2> /dev/null
	-rm -f *.obj        2> /dev/null
	-rm -f *~     2> /dev/null
	-rm -f .*.swp 2> /dev/null
	-rm -rf ii_files           2> /dev/null
	-rm -f *.{ilk,pdb,sln,suo} 2> /dev/null
	-rm -f core         2> /dev/null
	-rm -f core.*       2> /dev/null
	-rm -f .nfs*        2> /dev/null
	-rm -f .gdb_history 2> /dev/null
	-rm -rf .DS_Store     2> /dev/null

# FORCE TARGET -- Do not remove
FORCE:
