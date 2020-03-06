/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   VisitanteEquipo.h
 * Author: Usuario
 *
 * Created on 1 de marzo de 2020, 18:28
 */





using namespace std;


class Tarjeta;
class Disco;
class Bus;

class VisitanteEquipo {

private:
    double precio;
public:
	virtual void visitarTarjeta(Tarjeta * t)= 0;

	virtual void visitarDisco(Disco * d) = 0;
 
	virtual void visitarBus(Bus * b) = 0;
        
        void setPrecio(double precio);
        
        virtual double getPrecio() = 0;
};

