# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Cliente

  def self.main
    fc = FactoriaCarretera.new
    fm = FactoriaMontana.new 
    
    cm = fm.crearcarrera
    cc = fc.crearcarrera
    
    puts "Introduce el numero de biciletas: "
    STDOUT.flush  # esto es opcional es para limpiar los datos anteriores
    numbicis = gets.chomp 
    

    puts "/n"
    
    numbicis.times do |num|
       bm = fm.crearbicicleta
       cm.aniadirbicicleta(bm)
       bc = fc.crearbicicleta
       cc.aniadirbicicleta(bc)
    
    
    end
    
    cm.run
    cc.run
    
    puts "Simulacion finalizada"
  end
end

Cliente.main