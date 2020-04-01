#ifndef TARJETA_H
#define TARJETA_H

class Tarjeta : ComponenteEquipo {


public:
	Tarjeta(string nombre, double precio);

	void aceptar(VisitanteEquipo visitante);
};

#endif
