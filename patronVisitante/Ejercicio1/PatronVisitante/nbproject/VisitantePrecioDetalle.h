/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitantePrecioDetalle.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:31
 */

#ifndef VISITANTEPRECIODETALLE_H
#define VISITANTEPRECIODETALLE_H

#include "VisitanteEquipo.h"
//class VisitanteEquipo;
class Bus;
class Disco;
class Tarjeta;
using namespace std;

class VisitantePrecioDetalle : public VisitanteEquipo {


public:
        VisitantePrecioDetalle();
        
	void visitarBus(Bus * b) ;

	void visitarTarjeta(Tarjeta * t) ;

	void visitarDisco(Disco * d) ;
        
        double getPrecio();
};

#endif