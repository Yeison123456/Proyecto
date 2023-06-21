<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://kit.fontawesome.com/1067cb33f8.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="assests/css/UsuarioL.css">
    <title>Lista Mensajes</title>
    <style>
        
        .btnDelete {
            color: brown;
        }
        .btnDelete:hover {
            cursor: pointer;
            color: red;
            transition: 0.3s ease;
        }
        i {
            font-size: 16px;
        }
        button[type="submit"] {
            border: none;
        }


        .formulario table tr th{
        box-shadow: 0 0 5px black;
        background: #11b349;
        text-align: center;
        height: 60px;
        width: 150px;
        }

        .formulario table tr td{
        text-align: center;
        height: 40px;
        width: 150px;
        color: aliceblue;
        }   

        a{
            color: #11b349;
        }
    </style>
</head>
<body class="body">
    
    <header>
        <nav class="navegacion">
            <img src="assests/img/logo.png" alt="">
                <ul class="menu">
                    <li><a href="usuario?accion=home"><i class="fa-solid fa-house"  ></i> Home</a></li>
                    <li><a href=""><i class="fa-solid fa-user"  ></i> Usuario</a>
                        <ul class="subMenu">
                            <li><a href="usuario?accion=usuarioC">Crear</a></li>
                            <li><a href="usuario?accion=usuarioM">Modificar</a></li>
                            <li><a href="usuario?accion=usuarioL">Listar</a></li>

                        </ul>
                    </li>
                    <li><a href=""><i class="fa-solid fa-mobile" ></i> Mensajes</a>
                        <ul class="subMenu">
                            <li><a href="mensajes?accion=MensajeC">Crear mensaje</a></li>
                            <li><a href="mensajes?accion=MensajeL">Listar mensajes</a></li>
                            <li><a href="mensajes?accion=MensajeM">Modificar mensaje</a></li>
                        </ul>
                    </li>
                    <li><a href=""><i class="fa-solid fa-comment"></i> historias</a>
                        <ul class="subMenu">
                            <li><a href="historias?accion=HistoriaC">Crear historia</a></li>
                            <li><a href="historias?accion=HistoriaL">Listar historias</a></li>
                            <li><a href="historias?accion=HistoriaM">Modificar historia</a></li>
                        </ul>
                    </li>
                </ul>

            <a href="usuario?accion=login" class="atras"type="submit" ><i class="fa-solid fa-arrow-right-from-bracket"></i></i> Atras</a>

        </nav>
    </header>

    <main>
        <div class="formulario">
            <center>

                <h1 style="color: aliceblue;">Lista de Mensajes</h1>
                <a type="button" class="btn btn-primary" href="mensajes?accion=abrir">
                <i class="bi bi-plus-circle"></i> 
                Agregar Mensaje
                </a>
              
               <table class="table table-hover table-bordered">
               
                      <tr>
                          <th>Id</th>
                          <th>imagen</th>
                          <th>Video</th>            
                          <th>Mensaje</th>
                          <th>Estado</th>
                          
                      </tr>
                      
              <c:forEach var="mensaje" items="${mensaje}">         
                      
                    <tr>
                    <div class="contenido">
                      <td>${mensaje.getIdMensaje()}</td>
                      <td>${mensaje.getImg()}</td>
                      <td>${mensaje.getVideo()}</td>
                      <td>${mensaje.getMensaje()}</td>
                      <td>${mensaje.getEstado()}</td>
                    </div>
                      <td>
                        <form action="mensajes" method="post" id="formularioEliminar${mensaje.getIdMensaje()}">
                            <input type="hidden" name="idMensaje" id="IdFormulario" value="${mensaje.getIdMensaje()}">
                            <input type="hidden" name="accion" value="eliminar">
                            <i class="fa-solid fa-trash btnDelete" onclick="EnviarEliminacion('${mensaje.getIdMensaje()}')"></i>
                        </form>
                    </td>
                    </tr>
                      
                      
                      
              </c:forEach>    
              
              
              </table>
            </center>
          
          
          </div> 

          
        </main>
        
        <script>
            function EnviarEliminacion(idMensaje) {

            var formEliminado = document.getElementById('formularioEliminar' + idMensaje);

            Swal.fire({
            title: "¿Seguro que deesea eliminar este registro?",
            text: "Los registros eliminados no se podran recuperar.",
            icon: "warning",
            showCancelButton: true,
            confirmButtonColor: "#3085d6",
            cancelButtonColor: "#d33",
            confirmButtonText: "Sí, eliminarlo"
            }).then((result) => {
            if (result.isConfirmed) {
                formEliminado.submit();
            }

            });

}
        </script>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>