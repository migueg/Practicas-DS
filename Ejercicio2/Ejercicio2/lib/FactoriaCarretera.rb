# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class FactoriaCarretera < FactoriaCarreraYBicicleta
  
    def initialize
    @carrera = CarreraCarretera.new
    @bicicleta = BicicletaCarretera.new
  end
  def crearcarrera
    return @carrera.clone
  end
  
  def crearbicicleta
    return @bicicleta.clone
  end
end
