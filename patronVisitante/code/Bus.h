#ifndef BUS_H
#define BUS_H

class Bus : ComponenteEquipo {


public:
	Bus(string nombre, double precio);

	void aceptar(VisitanteEquipo visitante);
};

#endif
