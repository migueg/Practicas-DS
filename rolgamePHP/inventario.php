<?php
        require_once './vendor/autoload.php';
        require_once './scripts/functions.php';

        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);

        $usuario = iniSesion();

        if($_SERVER['REQUEST_METHOD'] == 'POST'){
            if(isset($_GET['tipo'])){
                $url = "http://localhost:8080/Seminario/demo/rolgame/equipar";
                $data = array('username' => $usuario['usuario'] , 'tipo' => $_GET['tipo'] , 'nombre' =>$_GET['arma']);
                $data_json = json_encode($data);
                $ch = curl_init();
                curl_setopt($ch, CURLOPT_URL, $url);
                curl_setopt($ch, CURLOPT_HTTPHEADER, array('Content-Type: application/json','Content-Length: ' . strlen($data_json)));
                curl_setopt($ch, CURLOPT_CUSTOMREQUEST, 'PUT');
                curl_setopt($ch, CURLOPT_POSTFIELDS,$data_json);
                curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
                $response  = curl_exec($ch);
                curl_close($ch);
            }
        }

        $url = 'http://localhost:8080/Seminario/demo/rolgame/inventario/'.$usuario['usuario'];
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        //echo $json;
        curl_close($curl);
        $array = json_decode($json, true);
        $num = count($array);

       
        $datosPersonaje['personaje']= $array[0]['personaje'];
        $datosPersonaje['vida'] = $array[0]['vida'];
        $datosPersonaje['daño'] = $array[0]['daño'];
        
        $arma['nombreArma'] =  $array[0]['nombreArma'];
        $arma['tipo'] =  $array[0]['tipo'];
        $arma['vidaArma'] =  $array[0]['vidaArma'];
        $arma['dañoArma'] =  $array[0]['dañoArma'];
        $armadura['nombreArmadura'] = $array[1]['nombreArmadura'];
        $armadura['tipo'] = $array[1]['tipo'];       
        $armadura['plusVida'] = $array[1]['plusVida'];
        $armadura['vidaArmadura'] = $array[1]['vidaArmadura'];

        $armas = array();
        $armaduras = array();
        for($i = 2 ; $i < $num ; $i++){
            if($array[$i]['tipo'] == 'arma'){
                $a['nombreArma'] =  $array[$i]['nombreArma'];
                $a['tipo'] =  $array[$i]['tipo'];
                $a['vidaArma'] =  $array[$i]['vidaArma'];
                $a['dañoArma'] =  $array[$i]['dañoArma'];

                

                array_push($armas,$a);
            }
            if($array[$i]['tipo'] == 'armadura'){
                $d['nombreArmadura'] = $array[$i]['nombreArmadura'];
                $d['tipo'] = $array[$i]['tipo'];       
                $d['plusVida'] = $array[$i]['plusVida'];
                $d['vidaArmadura'] = $array[$i]['vidaArmadura'];
                
                array_push($armaduras,$d);
            }
        }

    

        echo $twig->render('inventario.html', ['user' =>$usuario , 'personaje' => $datosPersonaje , 'arma' => $arma , 'armadura' =>$armadura , 'armas'=>$armas , 'armaduras'=>$armaduras] );
    ?>
  
    