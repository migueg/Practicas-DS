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
#include "Bus.h"
#include "Disco.h"
#include "Equipo.h"
#include "Tarjeta.h"
#include "VisitanteEquipo.h"

#include <vector>
using namespace std;

Equipo::Equipo(string nombre, Bus  bus, Disco disco, Tarjeta tarjeta) {
	// TODO - implement Equipo::Equipo
    this->nombre = nombre;
    this->bus = &bus;
    this->disco = &disco;
    this->tarjeta = &tarjeta;
    
}

void Equipo::aceptarEquipo(VisitanteEquipo * visitante) {
	// TODO - implement Equipo::aceptarEquipo
   
    
    visitante->visitarBus(bus);
    visitante->visitarDisco(disco);
    visitante->visitarTarjeta(tarjeta);
     
    
    
       
}

string Equipo::getNombre(){
    return nombre;
}