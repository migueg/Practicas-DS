/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Bus.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:16
 */

#ifndef BUS_H
#define BUS_H


#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"


using namespace std;

class Bus : public ComponenteEquipo {


public:
	Bus(string nombre, double precio);

	virtual void aceptar(VisitanteEquipo visitante) override;
        
        virtual double getPrecio() override;
        
        virtual string getNombre() override;
};

#endif