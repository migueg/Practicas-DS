
<?php
    require_once './vendor/autoload.php';
    require_once './scripts/functions.php';

    $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
    $twig = new Twig_Environment($loader,['debug' => true]);

    $usuario = iniSesion();

  
    $url = 'http://localhost:8080/Seminario/demo/rolgame/monstruos';
    $curl = curl_init($url);
    curl_setopt($curl, CURLOPT_ENCODING ,"");
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
    $json = curl_exec($curl);
    //echo $json;
    curl_close($curl);
    $array = json_decode($json, true);
    $num = count($array);
    $monstruos = array();

    for($i = 0 ; $i < $num ; $i++){
        $r['nivel'] = $array[$i]['nivel'];
        $r['url'] = $array[$i]['url'];
        $r['nombre'] = $array[$i]['nombre'];
        $r['tipo'] = $array[$i]['tipo'];
        $r['puntosVida'] = $array[$i]['puntosVida'];
        $r['puntosAtaque'] = $array[$i]['puntosAtaque'];
        $r['recompensa'] = $array[$i]['recompensa'];
        $r['movimientos'] = $array[$i]['movimientos'];


        array_push($monstruos , $r);
       
    }

    echo $twig->render('monstruos.html', ['user' =>$usuario , 'monsters'=>$monstruos]);
?>

