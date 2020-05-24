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

    if($_SERVER['REQUEST_METHOD'] == 'POST'){
        $url = 'http://localhost:8080/Seminario/demo/rolgame/addMonstruo';
        $ch = curl_init($url);

        $datos['nombre'] = $_POST['nombre'];
        $datos['nivel'] = $_POST['nivel'];

        $data = array(
            'nivel' => $_POST['nivel'],
            'url' => $_POST['url'],
            'nombre' => $_POST['nombre'],
            'tipo' => $_POST['tipo'],
            'puntosVida' => $_POST['vida'],
            'puntosAtaque' => $_POST['ataque'],
            'recompensa' => $_POST['recompensa'],
            'movimientos' => 0

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
        $nombre = $_POST['nombre'];
        $nivel = $_POST['nivel'];
        $direccion = 'Location: añadirmovimiento.php?nombre='.$nombre.'&nivel='.$nivel;
        if($mensaje == 'OK'){
            header($direccion);
        }else{
            exit("FF");
        }
    }

    
 

    echo $twig->render('añadirMonstruos.html', ['user' =>$usuario , 'paso'=>$paso, 'datos'=>$datos ]);
?>
