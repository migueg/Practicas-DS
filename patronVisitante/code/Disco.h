#ifndef DISCO_H
#define DISCO_H

class Disco : ComponenteEquipo {


public:
	Disco(string nombre, double equipo);

	void aceptar(VisitanteEquipo visitante);
};

#endif
