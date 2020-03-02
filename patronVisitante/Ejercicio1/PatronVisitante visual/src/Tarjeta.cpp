/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Tarjeta.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:26
 */

#include "Tarjeta.h"


Tarjeta::Tarjeta(string nombre, double precio) {
	// TODO - implement Tarjeta::Tarjeta
	ComponenteEquipo ::ComponenteEquipo(nombre,precio);
}

virtual void Tarjeta::aceptar(VisitanteEquipo visitante) override {
	// TODO - implement Tarjeta::aceptar
	visitante.visitarTarjeta(this);
}

virtual double Tarjeta::getPrecio() override{
    return ComponenteEquipo::getPrecio();
}

virtual string Tarjeta::getNombre() override {
    return ComponenteEquipo::getNombre();
}