
    <?php

use function PHPSTORM_META\map;

require_once './vendor/autoload.php';
    
        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);
        $mensaje = "";

        if($_SERVER['REQUEST_METHOD'] == 'POST'){
            $url = 'http://localhost:8080/Seminario/demo/rolgame/login';
            $ch = curl_init($url);

            $data = array(
                'username' => $_POST['user'],
                'password' => $_POST['pass']
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
            
            $mensaje = $result;
            if($mensaje == "OK"){
                session_start();

                if($_POST['user'] == "administrador"){
                    $_SESSION['usuario'] = $_POST['user'];
                    $_SESSION['rol'] = "admin";
                }else{
                    $_SESSION['usuario'] = $_POST['user'];
                    $_SESSION['rol'] = "registrado";
                }
                header("Location: logueados.php");
            }
            //close cURL resource
            curl_close($ch);
        }
        echo $twig->render('login.html', ["msg" => $mensaje]);
    ?>
  
    