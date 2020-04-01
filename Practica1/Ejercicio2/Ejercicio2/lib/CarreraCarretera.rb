# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require './Carrera'

class CarreraCarretera < Carrera
  
  def initialize
    super(10)
  end
  
  def printtipo
    return "carretera"
  end
  
  def clone
    return self
  end
  
end
