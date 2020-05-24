<?php
        require_once './vendor/autoload.php';
        require_once './scripts/functions.php';

        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);

        $usuario = iniSesion();
        if($_SERVER['REQUEST_METHOD'] ==  'POST'){
            $url = "http://localhost:8080/Seminario/demo/rolgame/oro";
            $data = array('username' => $_POST['nombre'] , 'cantidad' => $_POST['cantidad']);
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
        $url = 'http://localhost:8080/Seminario/demo/rolgame/ranking';
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        //echo $json;
        curl_close($curl);
        $array = json_decode($json, true);
        $num = count($array);
        $ranking = array();
        
        for($i = 0 ; $i < $num ; $i++){
            $r['puesto'] = $i + 1;
            $r['nombre'] = $array[$i]['username'];
            $r['record'] = $array[$i]['record'];
            $r['oro'] = $array[$i]['oro'];

            array_push($ranking , $r);
           
        }

        echo $twig->render('ranking.html', ['user' =>$usuario , 'ranking' => $ranking]);
?>
  
    