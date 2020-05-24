
    <?php
        require_once './vendor/autoload.php';
    
        $loader = new Twig_Loader_Filesystem('./directorioTemplates') ;
        $twig = new Twig_Environment($loader,['debug' => true]);

        echo $twig->render('index.html', []);
    ?>
  
    