/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitanteEquipo.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:28
 */





#include "Equipo.h"
#include "Tarjeta.h"
using namespace std;

class VisitanteEquipo {


public:
	virtual void visitarTarjeta(Tarjeta t);

	virtual void visitarDisco(Disco d);

	virtual void visitarBus(Bus b);
};

