/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Tarjeta.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:26
 */

#ifndef TARJETA_H
#define TARJETA_H


class ComponenteEquipo;
using namespace std;

class Tarjeta : public ComponenteEquipo {


public:
	Tarjeta(string nombre, double precio);

        void aceptar(VisitanteEquipo & visitante) ;
        
        double getPrecio() ;
        
        string getNombre() ;

        
};

#endif