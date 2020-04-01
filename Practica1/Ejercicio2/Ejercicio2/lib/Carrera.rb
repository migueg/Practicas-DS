# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.


class Carrera
  
  def initialize(porcentaje)
    
      @bicicletas = Array.new
      @porcentajeAbandono = porcentaje
    
  end
  
  #def self.new()
  #  raise "Error:Clase Abstracta"
  #end
  
  def aniadirbicicleta (bicicleta)
    
    id = @bicicletas.length
    #bicicleta.setidentificador(id)
    bicicleta.identificador = id
    
    #@bicicletas.push(bicicleta)
    @bicicletas << bicicleta
    
  end
  
  def abandonarcarrera
    
    abandonan = ( ( @porcentajeAbandono * (@bicicletas.length) ) / 100 )
    
    abandonan.times do |num|
      siguiente = rand(@bicicletas.count)
      @bicicletas.delete_at(siguiente)
    end
    
    return abandonan
    
  end
  
  def clone
    raise "Abstracto"
  end
  
  def run
    mensaje = "Iniciando carrera de " + printtipo + " con bicicletas:"
    
    #@bicicletas.size.times do |num|
    #  mensaje += " #{@bicicletas[num].getidentificador}"
    #end
    
    #for bicicleta in @bicicletas
    #  mensaje += " #{bicicleta.identificador}"
    #end
    
    @bicicletas.each { |bicicleta|
      mensaje += " #{bicicleta.identificador}"
    }
    
    puts mensaje
    
    sleep(5)
    
    numAbandonos = abandonarcarrera()
    
    puts "Carrera de " + printtipo + " - han abandonando #{numAbandonos} bicicletas"
    
    sleep(5)
    
    mensaje = "Carrera de " + printtipo + " terminada con biciletas: "
    
    #@bicicletas.size.times do |num|
    #  mensaje += " #{@bicicletas[num].getidentificador}"
    #end
    
    @bicicletas.each { |bicicleta|
      mensaje += " #{bicicleta.identificador}"
    }
    
    puts mensaje
    
  end
  
end