<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="assests/css/IndexW.css">
    <title>Index</title>

</head>

<body>
     <header>
        <div class="menu">
            <img src="assests/img/logo.png" alt="">
            <nav>
                <a href="#contenido1" class="info">¿Qué es Whatsapp?</a>
                <a href="#contenido2" class="info">Funciones</a>
                <a href="usuario?accion=index" class="atras">Volver</a>
                <a href="usuario?accion=login" class="inicio">Iniciar sesión</a>
            </nav>
        </div>
     </header>

     <main class="contenido">
        <div id="contenido1">
            <div class="img1">
                <img src="assests/img/img.png" alt="">
            </div>
            <h1>¿Que es Whatsapp?</h1>
            <p>
                WhatsApp es una aplicación de mensajería instantánea para dispositivos móviles y escritorio.
                 Fue creada en 2009 por los desarrolladores Brian Acton y Jan Koum, y adquirida por Facebook 
                 en 2014. Con más de 2 mil millones de usuarios activos mensuales en todo el mundo. Además 
                 de su uso personal, también se utiliza ampliamente en entornos empresariales y educativos 
                 para la comunicación y colaboración en equipo.
                 <%=new String("Hola Yeison").toUpperCase() %>
            
            </p>
        </div>
        <div id="contenido2">
            <img class="img1" src="assests/img/img1.png" alt="">
            <h1>Funciones</h1>
            <p>
                La aplicación permite a los usuarios enviar mensajes de texto, voz y multimedia, así como realizar llamadas de voz y videollamadas a 
                través de una conexión a Internet. También ofrece funciones de grupo, donde varios usuarios pueden comunicarse entre sí en un mismo chat.
            </p>
            <img class="img2" src="assests/img/img2.png" alt="">
        </div>

     </main>

     <footer>

         
         <div class="container">
            <img src="assests/img/logo1.png" alt="">
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