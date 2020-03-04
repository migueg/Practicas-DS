# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CarreraMontana < Carrera
  
  def initialize
    super(20)
  end
  
  def printtipo
    return "montana"
  end
  
  def clone
    return self
  end
  
end
