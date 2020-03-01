/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Equipo.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:25
 */

#include "Equipo.h"


Equipo::Equipo(string nombre, Bus bus, Tarjeta tarjeta, Disco disco) {
	// TODO - implement Equipo::Equipo
    this->nombre = nombre;
    this-> bus = bus;
    this->tarjeta  = tarjeta;
    this->disco = disco;
    
}

void Equipo::aceptarEquipo(VisitanteEquipo visitante) {
	// TODO - implement Equipo::aceptarEquipo
	visitante.visitarBus(this->bus);
        visitante.visitarDisco(this->disco);
        visitante.visitarTarjeta(this->tarjeta);
}