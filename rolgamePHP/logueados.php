
    <?php
        require_once './vendor/autoload.php';
        require_once './scripts/functions.php';

        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);

        $usuario = iniSesion();
        echo $twig->render('logueados.html', ['user' =>$usuario]);
    ?>
  
    