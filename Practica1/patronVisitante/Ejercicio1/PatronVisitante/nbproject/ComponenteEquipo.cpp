/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ComponenteEquipo.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:19
 */

#include "ComponenteEquipo.h"

ComponenteEquipo::ComponenteEquipo(string nombre, double precio) {
	// TODO - implement ComponenteEquipo::ComponenteEquipo
    this->nombre = nombre;
    this->precio = precio;
}



  double ComponenteEquipo::getPrecio() {
    return precio;
}

  string ComponenteEquipo::getNombre(){
    return nombre;
}