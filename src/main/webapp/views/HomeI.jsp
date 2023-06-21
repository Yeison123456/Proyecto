<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="assests/css/HomeI.css">
    <script src="https://kit.fontawesome.com/1067cb33f8.js" crossorigin="anonymous"></script>
    <title>Home - Instagram</title>
</head>
<body>

    <header>   

            <nav class="navegacion">
                <ul class="menu">
                    <li><a href="usuario?accion=homeI"><i class="fa-solid fa-house"  ></i> Home</a></li>
                    <li><a href=""><i class="fa-solid fa-user"  ></i> Usuario</a>
                        <ul class="subMenu">
                            <li><a href="usuario?accion=usuarioCi">Crear</a></li>
                            <li><a href="usuario?accion=usuarioMi">Modificar</a></li>
                            <li><a href="usuario?accion=usuarioLi">Listar</a></li>
                            
                        </ul>
                    </li>
                    <li><a href=""><i class="fa-solid fa-mobile" ></i> Mensajes</a>
                        <ul class="subMenu">
                            <li><a href="mensajes?accion=MensajeCi">Crear mensaje</a></li>
                            <li><a href="mensajes?accion=MensajeLi">Listar mensajes</a></li>
                            <li><a href="mensajes?accion=MensajeMi">Modificar mensaje</a></li>
                        </ul>
                    </li>
                    <li><a href=""><i class="fa-solid fa-comment"></i> historias</a>
                        <ul class="subMenu">
                            <li><a href="historias?accion=HistoriaCi">Crear historia</a></li>
                            <li><a href="historias?accion=HistoriaLi">Listar historias</a></li>
                            <li><a href="historias?accion=HistoriaMi">Modificar historia</a></li>
                        </ul>
                    </li>
                </ul>

                <a href="usuario?accion=loginI" class="atras"type="submit" ><i class="fa-solid fa-arrow-right-from-bracket"></i></i> Atras</a>

            </nav>

    </header>
    
    <main class="contenido">
        <div class="contenidoImg">
        <div class="titulo">
            <h1 class="subTitulo">Bienvenido a <p style="color: #bc4e9c;">Instagram</p></h1>
        </div>
        </div>
        <div class="chatea">
            <h1>Envia mensajes de forma <p style="color: #bc4e9c;">privada</p></h1>
            <p class="p">Los mensajes y las llamadas son privados entre
                tú y el destinatario. Nadie más puede leer o 
                escuchar su contenido, ni siquiera WhatsApp.
                Ya sean confesiones, discusiones difíciles o 
                bromas privadas tontas, tus conversaciones tienen
                que estar protegidas.</p>
                <img class="img1" src="assests/img/9.png" alt="">
                <img class="img2" src="assests/img/8.png" alt="">
        </div>
        <div class="publicar">
            <img class="img1" src="assests/img/10.png" alt="">
            <img class="img2" src="assests/img/11.png" alt="">   
            <h1>Publica tus historias de forma <b style="color: #bc4e9c;"> rapida </b> y  <b style="color: #bc4e9c;">segura</b></h1>
            <p class="p">Con las historias puedes compartir actualizaciones
                de texto, fotos, videos, y GIF que desapareceran despues
                de 24 horas. Solo las personas que tienes agregadas podran 
                ver tus historias y puedes elegir compartir tus actualizaciones
                de estado con todos tus contactos o solo con los que selecciones. </p>
        </div>

    </main>

    <footer >

        <div class="container">
            <p class="correo">Contacto: correo@ejemplo.com | Teléfono: (123) 456-7890</p>
            <nav>
              <ul>
                <li><a href="#">Términos y condiciones</a></li>
                <li><a href="#">Política de privacidad</a></li>
                <li><a href="#">Mapa del sitio</a></li>
              </ul>
            </nav>
          </div>
          <div class="copyright">
            <p class="copy">&copy; 2023 Mi Empresa. Todos los derechos reservados.</p>
          </div>

    </footer>

</body>
</html>