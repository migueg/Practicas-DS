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

using namespace std;

class VisitantePrecioDetalle : VisitanteEquipo {


public:
	virtual void visitarBus(Bus b) override;

	virtual void visitarTarjeta(Tarjeta t) override;

	virtual void visitarDisco(Disco d) override;
};

#endif