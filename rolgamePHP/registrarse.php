
    <?php
        require_once './vendor/autoload.php';
    
        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);
        $msg = "";
        $err = "";

        $url = 'http://localhost:8080/Seminario/demo/rolgame/personajes';
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        //echo $json;
        curl_close($curl);
        $array = json_decode($json, true);
        $num = count($array);
        $personajes = array();
                
        for($i = 0 ; $i < $num ; $i++){
            $p['personaje'] = $array[$i]['resultado'];
            array_push($personajes , $p);
           
        }

        if($_SERVER['REQUEST_METHOD'] == 'POST'){
            $url = 'http://localhost:8080/Seminario/demo/rolgame/registro';
            $ch = curl_init($url);

            $data = array(
                'username' => $_POST['user'],
                'password' => $_POST['pass'],
                'personaje' => $_POST['personajes']
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
      
            
            if($result == "OK"){
                $msg = "Registrado correctamente";
            }else{
                $err = $result;
            }
        }
        echo $twig->render('registrarse.html', ['mensaje'=>$msg,'personajes'=>$personajes , 'err'=>$err]);
    ?>
  
    