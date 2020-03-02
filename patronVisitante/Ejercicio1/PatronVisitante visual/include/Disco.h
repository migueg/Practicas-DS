/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Disco.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:23
 */

#ifndef DISCO_H
#define DISCO_H


#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"

using namespace std;

class Disco : public ComponenteEquipo {


public:
	Disco(string nombre, double equipo);

	void virtual aceptar(VisitanteEquipo visitante) override;
        
        void virtual getPrecio () override;
        
        virtual string getNombre() override;

};

#endif