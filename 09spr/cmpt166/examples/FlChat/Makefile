# Makefile that uses fltkconfig
################################

# Compiler flags
CFLAGS   = -O2 -I. $(shell fltk-config --cflags)
CXXFLAGS = -O2 -I. $(shell fltk-config --cxxflags)

CXXFLAGS += -DHAVE_PTHREAD_H

# Libraries
LDLIBS   = -lpthread -lm
FLTK_LIB = $(shell fltk-config --ldflags)
IMG_LIB  = $(shell fltk-config --use-images --ldflags)
GL_LIB   = $(shell fltk-config --use-gl --ldflags)
GLUT_LIB = $(shell fltk-config --use-glut --ldflags)

# Set compiler and fluid executable
CXX	= g++
CC	= gcc
FLUID   = fluid -c

# OS-specific changes
OS := $(shell uname)
EXE =

ifeq '$(OS)' "Windows_NT"
EXE     = .exe
CXXFLAGS += -DWIN32
endif

ifeq '$(OS)' "CYGWIN_NT-5.1"
EXE     = .exe
endif

ifeq ($(strip $(OS)),Linux)
CXXFLAGS  += -DLINUX
endif

ifeq ($(strip $(OS)),Darwin)
LDLIBS  += -framework CoreFoundation
endif

#.SILENT: # Make the build run quietly

#########################################################
# Compile rules for basic filetypes
.SUFFIXES: .c .cxx .cpp .cc .h .fl .o

.fl.h .fl.cxx:
	@echo Passing $< to fluid...
	$(FLUID) $<

# Rule to build an object file from a C++ source file
%.o : %.cxx
	@echo Compile $@...
	$(CXX) -c -o $@ $< $(CXXFLAGS)

# Rule to build an object file from a C source file
%.o : %.c
	@echo Compile $@...
	$(CC) -c -o $@ $< $(CFLAGS)

#########################################################
# define rules for the known targets...

PROG	= Server$(EXE)
OBJS	= Server.o ServerUI.o

$(PROG): $(OBJS)
	@echo Linking $@...
	$(CXX) $(OBJS) $(FLTK_LIB) $(LDLIBS) -o $@

Client$(EXE): Client.o ClientUI.o
	@echo Linking $@...
	$(CXX) Client.o ClientUI.o $(FLTK_LIB) $(LDLIBS) -o $@

all: $(PROG) Client$(EXE)

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
