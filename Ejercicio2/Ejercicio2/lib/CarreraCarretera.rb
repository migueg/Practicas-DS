# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CarreraCarretera < Carrera
  def initialize
    t = TipoBicicleta.new
    
    super(t.gettipos[1],10)
  end
  def clone
    return self
  end
end
