# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


class Carrera
  def initialize(tipo, porcentajeAbandono)
    
      @bicicletas = []
      @tipo = tipo
      @pocentajeAbandono = porcentajeAbandono
    
  end
  
  def self.new()
    raise "Error:Clase Abstracta"
  end
  
  def aniadirbicicleta (bicicleta)
    id = @bicicletas.size
    bicicleta.setidentificador(id)
    
    bicicletas.push(bicicleta)
  end
  
  def abandonarcarrera
    abandonan = (@porcentajeAbandono * @bicicletas.size/100)
    
    abandonan.times do |num|
      siguiente = (rand(@biciletas.size))
      @bicicletas.delete_at(siguiente)
    end
    
    return abandonan
  end
  
  def clone
    raise "Abstracto"
  end
  
  def run
    mensaje = "Iniciando carrera de #{@tipo} con bicicletas"
    
    @bicicletas.size.times do |num|
      mensaje += " #{@bicicletas[num].getidentificador}"
    end
    
    puts mensaje
    
    sleep(5)
    numAbandonos = abandonarcarrera()
    
    puts "Carrera #{@tipo} - han abandonando #{numAbandonos} bicicletas"
    
    sleep(5)
    
    mensaje = "Carrera de #{@tipo} terminada con biciletas: "
    
     @bicicletas.size.times do |num|
      mensaje += " #{@bicicletas[num].getidentificador}"
    end
    
    puts mensaje
  end
end