/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitantePrecio.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:29
 */


#include "VisitanteEquipo.h"
#include "VisitantePrecio.h"
#include "Bus.h"
#include "Tarjeta.h"
#include "Disco.h"


 void VisitantePrecio::visitarBus(Bus * b)  {
	// TODO - implement VisitantePrecio::visitarBus
    double preciobus = b->getPrecio();
    this->precio += preciobus;
    
}

 void VisitantePrecio::visitarTarjeta(Tarjeta * t) {
	// TODO - implement VisitantePrecio::visitarTarjeta
    double p = t->getPrecio();
    this->precio += p;
}

 void VisitantePrecio::visitarDisco(Disco * d)  {
   
    double preciodisco = d->getPrecio();
    this->precio += preciodisco;
}
 
 double VisitantePrecio::getPrecio(){
     return precio;
 }
 
 VisitantePrecio::VisitantePrecio(){
     precio = 0;
 }