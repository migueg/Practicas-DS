#
# Generated Makefile - do not edit!
#
# Edit the Makefile in the project folder instead (../Makefile). Each target
# has a -pre and a -post target defined where you can add customized code.
#
# This makefile implements configuration specific macros and targets.


# Environment
MKDIR=mkdir
CP=cp
GREP=grep
NM=nm
CCADMIN=CCadmin
RANLIB=ranlib
CC=gcc
CCC=g++
CXX=g++
FC=gfortran
AS=as

# Macros
CND_PLATFORM=MinGW-Windows
CND_DLIB_EXT=dll
CND_CONF=Release
CND_DISTDIR=dist
CND_BUILDDIR=build

# Include project Makefile
include Makefile

# Object Directory
OBJECTDIR=${CND_BUILDDIR}/${CND_CONF}/${CND_PLATFORM}

# Object Files
OBJECTFILES= \
	${OBJECTDIR}/main.o \
	${OBJECTDIR}/nbproject/Bus.o \
	${OBJECTDIR}/nbproject/ComponenteEquipo.o \
	${OBJECTDIR}/nbproject/Disco.o \
	${OBJECTDIR}/nbproject/Equipo.o \
	${OBJECTDIR}/nbproject/Tarjeta.o \
	${OBJECTDIR}/nbproject/VisitanteEquipo.o \
	${OBJECTDIR}/nbproject/VisitantePrecio.o \
	${OBJECTDIR}/nbproject/VisitantePrecioDetalle.o


# C Compiler Flags
CFLAGS=

# CC Compiler Flags
CCFLAGS=
CXXFLAGS=

# Fortran Compiler Flags
FFLAGS=

# Assembler Flags
ASFLAGS=

# Link Libraries and Options
LDLIBSOPTIONS=

# Build Targets
.build-conf: ${BUILD_SUBPROJECTS}
	"${MAKE}"  -f nbproject/Makefile-${CND_CONF}.mk ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/patronvisitante.exe

${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/patronvisitante.exe: ${OBJECTFILES}
	${MKDIR} -p ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}
	${LINK.cc} -o ${CND_DISTDIR}/${CND_CONF}/${CND_PLATFORM}/patronvisitante ${OBJECTFILES} ${LDLIBSOPTIONS}

${OBJECTDIR}/main.o: main.cpp
	${MKDIR} -p ${OBJECTDIR}
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/main.o main.cpp

${OBJECTDIR}/nbproject/Bus.o: nbproject/Bus.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/Bus.o nbproject/Bus.cpp

${OBJECTDIR}/nbproject/ComponenteEquipo.o: nbproject/ComponenteEquipo.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/ComponenteEquipo.o nbproject/ComponenteEquipo.cpp

${OBJECTDIR}/nbproject/Disco.o: nbproject/Disco.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/Disco.o nbproject/Disco.cpp

${OBJECTDIR}/nbproject/Equipo.o: nbproject/Equipo.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/Equipo.o nbproject/Equipo.cpp

${OBJECTDIR}/nbproject/Tarjeta.o: nbproject/Tarjeta.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/Tarjeta.o nbproject/Tarjeta.cpp

${OBJECTDIR}/nbproject/VisitanteEquipo.o: nbproject/VisitanteEquipo.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/VisitanteEquipo.o nbproject/VisitanteEquipo.cpp

${OBJECTDIR}/nbproject/VisitantePrecio.o: nbproject/VisitantePrecio.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/VisitantePrecio.o nbproject/VisitantePrecio.cpp

${OBJECTDIR}/nbproject/VisitantePrecioDetalle.o: nbproject/VisitantePrecioDetalle.cpp
	${MKDIR} -p ${OBJECTDIR}/nbproject
	${RM} "$@.d"
	$(COMPILE.cc) -O2 -MMD -MP -MF "$@.d" -o ${OBJECTDIR}/nbproject/VisitantePrecioDetalle.o nbproject/VisitantePrecioDetalle.cpp

# Subprojects
.build-subprojects:

# Clean Targets
.clean-conf: ${CLEAN_SUBPROJECTS}
	${RM} -r ${CND_BUILDDIR}/${CND_CONF}

# Subprojects
.clean-subprojects:

# Enable dependency checking
.dep.inc: .depcheck-impl

include .dep.inc
