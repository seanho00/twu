# Basic Makefile 
################################

# Paths specific to our project
INC = ./
SRC = ./
OBJ = ./

# Compiler flags
CFLAGS   = -O2 -I. -I$(INC) 
CXXFLAGS = -O2 -I. -I$(INC)

# Libraries
LDLIBS   = -lm

# Set compiler and fluid executable
CXX	= g++
CC	= gcc

# OS-specific changes
UNAME := $(shell uname)
EXE =

ifeq '$(OS)' "Windows_NT"
EXE     = .exe
endif

ifeq '$(OS)' "CYGWIN_NT-5.1"
EXE     = .exe
endif

ifeq ($(strip $(UNAME)),Linux)
CXXFLAGS  += -DLINUX
endif

ifeq ($(strip $(UNAME)),Darwin)
LDLIBS  += -framework CoreFoundation
endif

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

PROG	= DogsAndCats$(EXE)
OBJS	= DogsAndCats.o

$(PROG): $(OBJS)
	@echo Linking $@...
	$(CXX) $(OBJS) $(LDLIBS) -o $@

all: $(PROG)

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
