<?php
    require_once './vendor/autoload.php';
    require_once './scripts/functions.php';

    $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
    $twig = new Twig_Environment($loader,['debug' => true]);
    $datos=[];
    $usuario = iniSesion();
    $mensaje = "";

        $url = 'http://localhost:8080/Seminario/demo/rolgame/perfil/'.$usuario['usuario'];
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        //echo $json;
        curl_close($curl);
        $datos = json_decode($json, true);

        if($_SERVER['REQUEST_METHOD'] == 'POST'){
            $url = 'http://localhost:8080/Seminario/demo/rolgame/changepass';
            $ch = curl_init($url);

            $data = array(
                'username' => $usuario['usuario'],
                'oldpass' => $_POST['antigua'],
                'newpass' => $_POST['nueva']
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
            $respuesta = json_decode($result);
            $mensaje = $respuesta->resultado;
        }


    
    echo $twig->render('perfil.html', [ 'user'=>$usuario,'datos' =>$datos, 'msg' => $mensaje]);
?>
