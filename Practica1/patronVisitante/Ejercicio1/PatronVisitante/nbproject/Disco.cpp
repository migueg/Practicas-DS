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

#include "VisitanteEquipo.h"
#include "ComponenteEquipo.h"
#include "Disco.h"
Disco::Disco(string nombre, double precio):ComponenteEquipo(nombre,precio) {
	// TODO - implement Disco::Disco
}

 void Disco::aceptar(VisitanteEquipo & visitante) {
	// TODO - implement Disco::aceptar
    visitante.visitarDisco(this);
}

 double Disco::getPrecio()  {
    return ComponenteEquipo::getPrecio();
}

 string Disco::getNombre() {
    return ComponenteEquipo::getNombre();
}