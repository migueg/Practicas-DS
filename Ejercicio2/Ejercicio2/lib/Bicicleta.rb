# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


class Bicicleta
 
   def initialize(tipo)
     if self.class == Bicileta
       
       @tipo = tipo
       @identificador = 0
    else
      raise "Clase abstracta"
    end
   end
   
   def setidentificador (id)
     @identificador = id
   end
   
   def getidentificador
     return @identificador
   end
   
   def clone
     raise "Abstracto"
   end
end