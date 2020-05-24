
    <?php
        require_once './vendor/autoload.php';
        require_once './scripts/functions.php';

        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);

        $usuario = iniSesion();
        $mensaje = "";
        if($_SERVER['REQUEST_METHOD'] == 'POST'){
            $url = 'http://localhost:8080/Seminario/demo/rolgame/buy';
            $ch = curl_init($url);
            $data = array(
                'username' => $usuario['usuario'],
                'nombre' => $_POST['nombre'],
                'tipo' => $_POST['tipo']
            );

            $json =  json_encode($data);
            curl_setopt($ch, CURLOPT_POSTFIELDS, $json);
            curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type:application/json'));
            curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
            $result = curl_exec($ch);
            $respuesta = json_decode($result);
            $mensaje = $respuesta->resultado;
            curl_close($ch);
        
        }
        $url = 'http://localhost:8080/Seminario/demo/rolgame/shop/'.$usuario['usuario'];
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        curl_close($curl);
        $array = json_decode($json, true);
        $num = count($array);
        
        $dinero = $array[0]['dineroTotal'];

        $objetos = array();
        for($i = 0; $i < $num ; $i++){
           $o['nombre'] = $array[$i]['nombre'];
           $o['tipo'] = $array[$i]['tipo'];
           $o['url'] = $array[$i]['url'];
           $o['bonusAtaque'] = $array[$i]['bonusAtaque'];
           $o['bonusVida'] = $array[$i]['bonusVida'];
           $o['coste'] = $array[$i]['coste'];
          

           array_push($objetos,$o);

        }

        echo $twig->render('tienda.html', ['user' =>$usuario ,'objetos' => $objetos, 'dinero'=>$dinero , 'msg' =>$mensaje]);
    ?>
  
    