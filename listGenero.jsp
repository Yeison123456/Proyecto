<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
    <head>
        <title>Lista Generos</title>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta
        name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- sweetalert -->
        <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

        <!-- Bootstrap CSS v5.0.2 -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
        <style>
            .btnEdit {
                color: rgb(255, 208, 0);
            }
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
        </style>
    </head>
    <body>
        <div class="container">
            <h1 class="text-center">GENEROS</h1>
            <a href="genero?accion=VolverP">volver</a>
            <table class="table table-light">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre Genero</th>
                        <th>Estado del Genero</th>
                        <th colspan="4">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="genero" items="${generos}">
                        <tr>
                            <td scope="row">${genero.getIdGenero()}</td>
                            <td>${genero.getNombreGenero()}</td>
                            <td>${genero.getEstadoGenero()}</td>
                            <td>
                                <c:if test="${genero.getEstadoGenero() == 'Activo'}">
                                    <form action="genero" method="post" id="formularioInactivar${genero.getIdGenero()}">
                                        <input type="hidden" name="idGenero" value="${genero.getIdGenero()}">
                                        <input type="hidden" name="accionForm" value="inactivar">
                                        <button type="button" class="btn btn-danger" onclick="inactivar('${genero.getIdGenero()}')">Inactivar</button>
                                    </form>
                                </c:if>
                                <c:if test="${genero.getEstadoGenero() == 'Inactivo'}">
                                    <form action="genero" method="post" id="formularioActivar${genero.getIdGenero()}">
                                        <input type="hidden" name="idGenero" value="${genero.getIdGenero()}">
                                        <input type="hidden" name="accionForm" value="activar">
                                        <button type="button" class="btn btn-success" onclick="activar('${genero.getIdGenero()}')">Activar</button>
                                    </form>
                                </c:if>
                            </td>
                            <td>

                                <!-- Button trigger modal -->
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-id-${genero.getIdGenero()}">
                                    <i class="bi bi-pencil-square btnEdit"></i>
                                </button>

                                <!-- Modal -->
                                <div class="modal fade" id="modal-id-${genero.getIdGenero()}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                            </div>
                                            <div class="modal-body">
                                                <form action="genero" method="post">
                                                    <input type="hidden" name="idGenero" value="${genero.getIdGenero()}">
                                                    <label for="nombreGenero">Nombre Genero:
                                                    </label>
                                                    <input type="text" name="nombreGenero" id="nombreGenero" value="${genero.getNombreGenero()}"><br>
                                                    <label for="">Estado Actual: ${genero.getEstadoGenero()}
                                                    </label><br>
                                                    <label for="">Cambiar  a
                                                    </label>
                                                    <select name="estadoGenero" id="" class="">
                                                        <option value="Activo">Seleccionar</option>
                                                        <option value="Activo">Activo</option>
                                                        <option value="Inactivo">Inactivo</option>
                                                    </select>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="submit" class="btn btn-success" name="accionForm" value="Actualizar">Actualizar Informacion</button>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>


                            <td>
                                <form action="genero" method="post" id="formularioEliminar${genero.getIdGenero()}">
                                    <input type="hidden" name="idGeneroEliminar" id="IdFormulario" value="${genero.getIdGenero()}">
                                    <input type="hidden" name="accionForm" value="eliminar">
                                    <i class="bi bi-trash-fill btnDelete" onclick="EnviarEliminacion('${genero.getIdGenero()}')"></i>
                                </form>
                            </td>
                        </tr>


                    </c:forEach>

                </tbody>
            </table>
        </div>
        <script>
            function activar(id) {
                var formActivar = document.getElementById('formularioActivar' + id);
                Swal.fire({
                    title: "¿Seguro que deesea Activar este registro?",
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "Sí, activar"
                }).then((result) => {
                    if (result.isConfirmed) {

                        formActivar.submit();

                    }

                });
            }
            function inactivar(id) {
                var formInactivar = document.getElementById('formularioInactivar' + id);
                Swal.fire({
                    title: "¿Seguro que deesea Inactivar este registro?",
                    icon: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#3085d6",
                    cancelButtonColor: "#d33",
                    confirmButtonText: "Sí, inacticar"
                }).then((result) => {
                    if (result.isConfirmed) {
                        formInactivar.submit();

                    }

                });
            }
            function EnviarEliminacion(id) {

                var formEliminado = document.getElementById('formularioEliminar' + id);

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
                        // Swal.fire("Eliminado!", "Registro Eliminado exitosamente.", "success");
                        // Swal.fire({
                        //     position: 'top',
                        //     icon: 'success',
                        //     title: 'Your work has been saved',
                        //     showConfirmButton: false,
                        //     timer: 1500
                        // });
                        formEliminado.submit();
                        // setTimeout(enviar,2000);
                        //     function enviar() {

                        //     }
                    }

                });

            }
        </script>
        <!-- Bootstrap JavaScript Libraries -->
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
