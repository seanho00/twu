# Makefile using FLTK, GLUT, GLEW
#################################

# FLTK
FLTK_LIB = $(shell fltk-config --ldflags)
IMG_LIB  = $(shell fltk-config --use-images --ldflags)
GL_LIB   = $(shell fltk-config --use-gl --ldflags)
GLUT_LIB = $(shell fltk-config --use-glut --ldflags)
GLUT_LIB = -lglut32 $(GL_LIB)

# GLEW
GLEW_FLAGS = -DGLEW_STATIC
#GLEW_LIB   = -lglew32		# compile with program instead (glew.o)
#GLEW_LIB   = -lGLEW
GLEW_LIB   = 

# Compiler flags
CFLAGS   = -O2 -I. $(shell fltk-config --cflags) $(GLEW_FLAGS)
CXXFLAGS = -O2 -I. $(shell fltk-config --cxxflags)

# Libraries
#LDLIBS   = -lglut32 -lglu32 -lopengl32 -lm -mno-cygwin
LDLIBS  = $(GLEW_LIB) $(GLUT_LIB) -lm

# Set compiler and fluid executable
CXX	= g++
CC	= gcc
FLUID   = fluid -c

# OS-specific changes
UNAME := $(shell uname)
EXE =
ifeq '$(UNAME)' "Windows_NT"
EXE     = .exe
endif
ifeq '$(UNAME)' "CYGWIN_NT-5.1"
CC	= gcc -mno-cygwin	# MingW compiler w/o Cygwin extensions
EXE     = .exe
endif
ifeq ($(strip $(UNAME)),Linux)
CXXFLAGS  += -DLINUX
GLUT_LIB = -lglut $(GL_LIB)
endif
ifeq ($(strip $(UNAME)),Darwin)
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

PROG	= particle$(EXE)
OBJS	= particle.o glew.o

$(PROG): $(OBJS)
	@echo Linking $@...
	$(CC) $(LDFLAGS) $(OBJS) $(LDLIBS) -o $@

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
