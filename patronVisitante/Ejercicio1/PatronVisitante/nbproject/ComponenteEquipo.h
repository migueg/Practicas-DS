/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ComponenteEquipo.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:19
 */



#include <string>


class VisitanteEquipo;

using namespace std;


class ComponenteEquipo {

private:
	string nombre;
	double precio;

public:
	ComponenteEquipo(string nombre, double precio);

	virtual void aceptar(VisitanteEquipo & visitante) =0;
        
        virtual double getPrecio() ;
        
        virtual string getNombre() ;
};

