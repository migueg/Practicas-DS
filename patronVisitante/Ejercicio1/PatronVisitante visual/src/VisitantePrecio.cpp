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



#include "VisitantePrecio.h"


virtual void VisitantePrecio::visitarBus(Bus b) override {
	// TODO - implement VisitantePrecio::visitarBus
    double preciobus = b.getPrecio();
    this->precio += preciobus;
    
}

virtual void VisitantePrecio::visitarTarjeta(Tarjeta t) override{
	// TODO - implement VisitantePrecio::visitarTarjeta
    double p = t.getPrecio();
    this->precio += p;
}

virtual void VisitantePrecio::visitarDisco(Disco d) override {
   
    double preciodisco = d.getPrecio();
    this->precio += preciodisco;
}