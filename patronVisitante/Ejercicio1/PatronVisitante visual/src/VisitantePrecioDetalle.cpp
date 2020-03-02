/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitantePrecioDetalle.cpp
 * Author: Usuario
 * 
 * Created on 1 de marzo de 2020, 18:31
 */
#include "VisitantePrecioDetalle.h"


virtual void VisitantePrecioDetalle::visitarBus(Bus b) override {
	// TODO - implement VisitantePrecioDetalle::visitarBus
	string n = b.getNombre();
        double p = b.getPrecio();
        
        cout<<"Nombre Componente: " << n <<endl;
        cout<< "Precio Componente: " <<< p << " euros" <<endl;
}

virtual void VisitantePrecioDetalle::visitarTarjeta(Tarjeta t) override {
	// TODO - implement VisitantePrecioDetalle::visitarTarjeta
	string n = t.getNombre();
        double p = t.getPrecio();
        
        cout<<"Nombre Componente: " << n <<endl;
        cout<< "Precio Componente: " <<< p << " euros" <<endl;
}

virtual void VisitantePrecioDetalle::visitarDisco(Disco d) override {
	// TODO - implement VisitantePrecioDetalle::visitarDisco
	string n = d.getNombre();
        double p = d.getPrecio();
        
        cout<<"Nombre Componente: " << n <<endl;
        cout<< "Precio Componente: " <<< p << " euros" <<endl;
}
