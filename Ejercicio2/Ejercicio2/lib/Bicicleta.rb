# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


class Bicicleta
  
  attr_accessor :identificador
  
  #def setidentificador(identificador)
  #  @identificador = identificador
  #end
  
  #def getidentificador
  #  return @identificador
  #end
  
  def to_s
    "Bicicleta n#{@identificador}"
  end
  
end