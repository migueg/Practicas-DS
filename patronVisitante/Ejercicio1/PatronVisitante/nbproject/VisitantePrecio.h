/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitantePrecio.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:29
 */

#ifndef VISITANTEPRECIO_H
#define VISITANTEPRECIO_H

class VisitanteEquipo;
using namespace std;

class VisitantePrecio : public VisitanteEquipo {

private:
    double precio;
    
public:
        VisitantePrecio();
        
	void visitarBus(Bus * b) ;

	void visitarTarjeta(Tarjeta * t) ;

	void visitarDisco(Disco * d) ;
        
        double getPrecio();
        
        
};

#endif