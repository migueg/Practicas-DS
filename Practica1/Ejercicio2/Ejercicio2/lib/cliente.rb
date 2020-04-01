# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require './FactoriaCarretera'
require './FactoriaMontana'
require './CarreraCarretera'
require './CarreraMontana'
require './BicicletaMontana'
require './BicicletaCarretera'

class Cliente

  def main
    
    fc = FactoriaCarretera.new
    fm = FactoriaMontana.new 
    
    cm = fm.crearcarrera
    cc = fc.crearcarrera
    
    puts "Introduce el numero de biciletas: "
    STDOUT.flush  # esto es opcional es para limpiar los datos anteriores
    numbicis = gets.chomp 
    
    puts "\n"
    contador = 0
    
    #numbicis.times do |num|
    while contador < numbicis.to_i
      bm = fm.crearbicicleta
      cm.aniadirbicicleta(bm)
      bc = fc.crearbicicleta
      cc.aniadirbicicleta(bc)
      contador += 1
    end
    
    cm.run
    cc.run
    
    puts "\nSimulacion finalizada"
    
  end
  
end

C = Cliente.new
C.main