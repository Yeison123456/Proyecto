<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://kit.fontawesome.com/1067cb33f8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="assests/css/UsuarioMi.css">
    <title>Crear Usuario</title>
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

    <main>
        <div class="formulario">
            <form action="usuario" method="post">
                <div class="contenido">
                <input type="number" placeholder="idUsuario" id="idUsiario" name="idUsuario">
                <input type="text" placeholder="Nombre" id="username" name="username">
                <input type="text" placeholder="Apellido" id="apellido" name="apellido">
                <input type="text" placeholder="Telefono" id="telefono" name="telefono">
                <input type="text" placeholder="Edad" id="edad" name="edad"><br>
                <input type="text" placeholder="Nombre de usuario" id="nombreUsuario" name="nombreUsuario">
                <input type="password" placeholder="Contraseña" id="password" name="password">
                </div>      
                <label for="estRol" class="label">Estado del usuario: </label><br>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="estado" value="Activo"checked>
                        Activo
                    </label>
                </div>
                <div class="form-check">
                    <label class="form-check-label">
                        <input type="radio" class="form-check-input" name="estado" value="Inactivo">
                        Inactivo
                    </label>
                </div>
                
                <button class="actualizar" type="submit" name="accion" value="actualizarUi" >Modificar</button>

            </form>
        </div>
        <h1><b style="color: #bc4e9c;">Modificar</b> usuario</h1>
    </main>


</body>
</html>