<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Login - Whatsapp</title>
    <link rel="stylesheet" href="assests/css/loginI.css">
  </head>
  <body class="logon1">
    <div class="login">
      <h2>Iniciar sesión</h2>
      <form action="servlets" method="post">
        <input type="text" placeholder="Nombre" id="username" name="username"><br>
        <input type="password" placeholder="Contraseña" id="password" name="password"><br><br><br>
        <a href="usuario?accion=indexI" class="atras"type="submit" >Atras</a>
        <a href="usuario?accion=homeI" class="entrar" type="submit">Entrar</a><br><br><br>
      </form>
    </div>

    <div class="imagenes ">
      <img class="img1" src="assests/img/2.png" alt="">
      <img class="img2" src="assests/img/conversacion.png" alt="">
      <img class="img3" src="assests/img/3.png" alt="">
      <img class="img4" src="assests/img/4.png" alt="">
      <img class="img5" src="assests/img/5.png" alt="">
      <img class="img6" src="assests/img/6.png" alt="">
      <img class="img7" src="assests/img/7.png" alt="">
    </div>

  </body>
</html>