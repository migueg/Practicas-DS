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

#include "Bus.h"
#include "Disco.h"
#include "Tarjeta.h"

using namespace std;


class Equipo {

private:
	string nombre;
        Bus bus;
        Tarjeta tarjeta;
        Disco disco;

public:
	Equipo(string nombre, Bus bus, Tarjeta tarjeta, Disco disco);

	void aceptarEquipo(VisitanteEquipo visitante);
};

#endif