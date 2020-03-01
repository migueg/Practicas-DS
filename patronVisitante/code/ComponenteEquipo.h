#ifndef COMPONENTEEQUIPO_H
#define COMPONENTEEQUIPO_H

class ComponenteEquipo {

private:
	string nombre;
	double precio;

public:
	ComponenteEquipo(string nombre, double precio);

	void aceptar(VisitanteEquipo visitante);
};

#endif
