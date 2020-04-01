/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:07
 */

#include <cstdlib>
#include <iostream>


#include "nbproject/VisitantePrecioDetalle.h"
#include "nbproject/VisitantePrecio.h"
#include "./nbproject/Equipo.h"
//#include "./nbproject/VisitanteEquipo.h"
#include "nbproject/Bus.h"
#include "nbproject/Disco.h"
#include "nbproject/Tarjeta.h"
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    Bus b("bus1", 200);
    Disco d("disco1", 300);
    Tarjeta t ("Tarjeta1" , 200);
    Equipo equipo1("Equipo1", b,d,t);
    
    VisitanteEquipo * v = new VisitantePrecioDetalle();
    VisitanteEquipo * v1 = new VisitantePrecio();
    
    equipo1.aceptarEquipo(v);
    equipo1.aceptarEquipo(v1);
    
    cout<<"Precio Total equipo "<<equipo1.getNombre()<< ": "<< v1->getPrecio()<<endl;
    
    Bus b2("bus2", 100);
    Disco d2("disco2", 300);
    Tarjeta t2 ("Tarjeta2" , 500);
    Equipo equipo2("Equipo2", b2,d2,t2);
    
    
    equipo2.aceptarEquipo(v);
    equipo2.aceptarEquipo(v1);
    
    
    cout<<"Precio Total equipo "<<equipo2.getNombre()<< ": "<< v1->getPrecio()<<endl;

    
}

