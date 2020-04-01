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

#include "ComponenteEquipo.h"
#include "VisitanteEquipo.h"
#include "Tarjeta.h"


Tarjeta::Tarjeta(string nombre, double precio):ComponenteEquipo(nombre,precio){
	// TODO - implement Tarjeta::Tarjeta
	
}

 void Tarjeta::aceptar(VisitanteEquipo & visitante)  {
	// TODO - implement Tarjeta::aceptar
	visitante.visitarTarjeta(this);
}

 double Tarjeta::getPrecio() {
    return ComponenteEquipo::getPrecio();
}

 string Tarjeta::getNombre()  {
    return ComponenteEquipo::getNombre();
}