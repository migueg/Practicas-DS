/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Bus.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:16
 */

#include "Bus.h"


Bus::Bus(string nombre, double precio){
	// TODO - implement Bus::Bus
    ComponenteEquipo ::ComponenteEquipo(nombre,precio);
}

virtual void Bus::aceptar(VisitanteEquipo visitante) override {
	// TODO - implement Bus::aceptar
    visitante.visitarBus(this);
}

virtual double Bus::getPrecio() override {
    return ComponenteEquipo::getPrecio();
}

virtual string Bus::getNombre() override {
    return ComponenteEquipo::getNombre();
}