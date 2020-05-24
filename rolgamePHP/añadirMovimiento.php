<?php
    require_once './vendor/autoload.php';
    require_once './scripts/functions.php';

    $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
    $twig = new Twig_Environment($loader,['debug' => true]);

    $usuario = iniSesion();
    $paso = 1;
    $datos= [];
    $sigo = false;
    $msg = "";

 
    if(isset($_GET['nombre'])){
    $datos['nombre'] =$_GET['nombre'];
    $datos['nivel'] = $_GET['nivel'];
    }
    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $url = 'http://localhost:8080/Seminario/demo/rolgame/addMove';
        $ch = curl_init($url);

      

        $data = array(
            'nombre' => $_POST['nombre'],
            'potencia' => $_POST['potencia'],
            'tipoConBonus' => $_POST['tipoConBonus'],
            'bonus' => $_POST['bonus'],
            'nivel' => $_POST['nivel'],
            'monstruo' => $_POST['monstruo'],

        );

       

        $payload = json_encode($data);
       

        //establece $payload como json enviado
        curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);
        
        //set the content type to application/json
        curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
        
        //te duvuelve la respuesta en lugar de publicarla
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
        
        //execute the POST request
        $result = curl_exec($ch);

        $codigoRespuesta = curl_getinfo($ch, CURLINFO_HTTP_CODE);
        
        
        $mensaje = $result;

        if($mensaje == 'OK'){
            $sigo = true;
        }else{
            echo $mensaje;
            exit('Error1');
        }

        if($sigo){
            $url = 'http://localhost:8080/Seminario/demo/rolgame/addMove';
            $ch = curl_init($url);
    
          
    
            $data = array(
                'nombre' => $_POST['nombre2'],
                'potencia' => $_POST['potencia2'],
                'tipoConBonus' => $_POST['tipoConBonus2'],
                'bonus' => $_POST['bonus2'],
                'nivel' => $_POST['nivel'],
                'monstruo' => $_POST['monstruo'],
    
            );
    
           
    
            $payload = json_encode($data);
           
    
            //establece $payload como json enviado
            curl_setopt($ch, CURLOPT_POSTFIELDS, $payload);
            
            //set the content type to application/json
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
            
            //te duvuelve la respuesta en lugar de publicarla
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            
            //execute the POST request
            $result = curl_exec($ch);
    
            
            
            $mensaje = $result;

            if($mensaje == 'OK'){
                $msg = "Añadido con éxito";
            }else{
                echo $mensaje;
                exit('Error2');
            }
        }
    }

 

    echo $twig->render('añadirMovimiento.html', ['user' =>$usuario , 'paso'=>$paso, 'datos'=>$datos , 'msg' => $msg]);
?>
