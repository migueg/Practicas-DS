#ifndef EQUIPO_H
#define EQUIPO_H

class Equipo {

private:
	string nombre;

public:
	Equipo(string nombre, Bus bus, Tarjeta tarjeta, Disco disco);

	void aceptarEquipo(VisitanteEquipo visitante);
};

#endif
