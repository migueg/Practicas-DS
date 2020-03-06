/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Equipo.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:25
 */

#ifndef EQUIPO_H
#define EQUIPO_H
#include <string>



class Bus;
class Disco;
class Tarjeta;
class VisitanteEquipo;
//#include "VisitanteEquipo.h"
using namespace std;


class Equipo {

private:
	string nombre;
        Bus *bus;
        Disco *disco;
        Tarjeta *tarjeta;

public:
	Equipo(string nombre, Bus bus, Disco disco, Tarjeta tarjeta);

	void aceptarEquipo(VisitanteEquipo * visitante);
        
        string getNombre();
};

#endif