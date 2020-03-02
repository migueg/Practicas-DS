/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Disco.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:23
 */

#include "Disco.h"

Disco::Disco(string nombre, double precio) {
	// TODO - implement Disco::Disco
	ComponenteEquipo ::ComponenteEquipo(nombre,precio);
}

virtual void Disco::aceptar(VisitanteEquipo visitante) override{
	// TODO - implement Disco::aceptar
    visitante.visitarDisco(this);
}

virtual double Disco::getPrecio() override {
    return ComponenteEquipo::getPrecio();
}

virtual string Disco::getNombre() override{
    return ComponenteEquipo::getNombre();
}