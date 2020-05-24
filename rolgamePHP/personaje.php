
<?php
    require_once './vendor/autoload.php';
    require_once './scripts/functions.php';

    $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
    $twig = new Twig_Environment($loader,['debug' => true]);
    $datos=[];
    if(isset($_GET['id'])){
        $url = 'http://localhost:8080/Seminario/demo/rolgame/personaje/'.$_GET['id'];
        $curl = curl_init($url);
        curl_setopt($curl, CURLOPT_ENCODING ,"");
        curl_setopt($curl, CURLOPT_RETURNTRANSFER, true);
        $json = curl_exec($curl);
        //echo $json;
        curl_close($curl);
        $datos = json_decode($json, true);

        
    }

    
    echo $twig->render('personaje.html', [ 'datos' =>$datos]);
?>
