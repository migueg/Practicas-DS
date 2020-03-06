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
#include "VisitanteEquipo.h"
#include "Bus.h"


Bus::Bus(string nombre, double precio):ComponenteEquipo(nombre,precio){
	// TODO - implement Bus::Bus
    //ComponenteEquipo::ComponenteEquipo(nombre,precio);
}

void Bus::aceptar(VisitanteEquipo & visitante)  {
	// TODO - implement Bus::aceptar
    visitante.visitarBus(this);
}

 double Bus::getPrecio()  {
    return ComponenteEquipo::getPrecio();
}

 string Bus::getNombre()  {
    return ComponenteEquipo::getNombre();
}