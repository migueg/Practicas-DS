<?php
function iniSesion(){
    $usuario = [];

    session_start();
    if(isset($_SESSION['usuario'])){
        $usuario['usuario'] = $_SESSION['usuario'];
        $usuario['rol'] = $_SESSION['rol'];
    }

    return $usuario;
}

?>