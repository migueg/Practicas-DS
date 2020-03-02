visitante: main.o Equipo.o ComponenteEquipo.o VisitanteEquipo.o Bus.o Disco.o Tarjeta.o VisitantePrecio.o VisitantePrecioDetalle.o
	g++ -o visitante main.o Equipo.o ComponenteEquipo.o VisitanteEquipo.o Bus.o Disco.o Tarjeta.o VisitantePrecio.o VisitantePrecioDetalle.o

main.o : main.cpp Equipo.h ComponenteEquipo.h VisitanteEquipo.h
	g++ -c main.cpp

Equipo.o: Equipo.cpp Disco.h Bus.h Tarjeta.h
	g++ -c Equipo.cpp

ComponenteEquipo.o: ComponenteEquipo.cpp VisitanteEquipo.h
	g++ -c ComponenteEquipo.cpp

VisitanteEquipo.o: VisitanteEquipo.cpp Bus.h Tarjeta.h Disco.h
	g++ -c VisitanteEquipo.cpp

Bus.o: Bus.cpp ComponenteEquipo.cpp VisitanteEquipo.cpp
	g++ -c Bus.cpp

Tarjeta.o: Tarjeta.cpp ComponenteEquipo.cpp VisitanteEquipo.cpp
	g++ -c Tarjeta.cpp

Disco.o: Disco.cpp ComponenteEquipo.cpp VisitanteEquipo.cpp
	g++ -c Disco.cpp

VisitantePrecio.o: VisitantePrecio.cpp VisitanteEquipo.h
	g++ -c VisitantePrecio.cpp

VisitantePrecioDetalle.o: VisitantePrecioDetalle.cpp VisitanteEquipo.h
	g++ -c VisitantePrecioDetalle.cpp

