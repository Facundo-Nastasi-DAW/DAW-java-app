<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getAttribute("llibres") == null) {  
%>
    <jsp:forward page="Consulta" />
<%
    }
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Llibreria Dove</title>
    <!-- Enlace a Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJ03v3wwrnQWsf1mYk1Nn87wCm5vkdW6ZlEPl5VRzAxtXOsHXQ5KwDbF1kHg" crossorigin="anonymous">
    <style>
        body {
            background-color: #e5f7f3; /* Fondo verde azulado claro */
        }
        .table {
            border-collapse: collapse;
            width: 100%;
            margin: 20px auto;
        }
        .table th, .table td {
            border: 1px solid #ccc;
            padding: 8px 12px;
            text-align: center;
        }
        .table th {
            background-color: #4fb7b1; /* Fondo verde azulado */
            color: white;
        }
        .table td {
            background-color: #ffffff; /* Blanco para el contenido */
        }
        h1 {
            color: #4fb7b1; /* Título en verde azulado */
        }
        .container {
            padding-top: 30px;
        }
        .btn-custom {
            background-color: #4fb7b1; /* Verde azulado */
            color: white;
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 5px;
            margin: 5px; /* Espaciado entre los botones */
            display: inline-block; /* Asegura que no se solapen */
        }
        .btn-custom:hover {
            background-color: #3e9d98; /* Verde azulado más oscuro */
        }
        .btn-edit {
            background-color: #cd7f32; /* Bronce */
        }
        .btn-edit:hover {
            background-color: #b56a2b; /* Bronce más oscuro */
        }
        .btn-delete {
            background-color: #e74c3c; /* Rojo */
        }
        .btn-delete:hover {
            background-color: #c0392b; /* Rojo más oscuro */
        }
        /* Ajuste para pantallas pequeñas */
        @media (max-width: 768px) {
            .table th, .table td {
                padding: 4px 8px; /* Reducir el padding para pantallas pequeñas */
            }
            .table {
                font-size: 12px; /* Reducir el tamaño de fuente en pantallas pequeñas */
            }
            .btn-custom {
                padding: 5px 10px; /* Reducir tamaño del botón */
                width: 100%; /* Los botones ocupan todo el ancho en pantallas pequeñas */
            }
            .btn-edit, .btn-delete {
                margin-bottom: 10px; /* Agregar espacio entre los botones */
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div style="display: flex; flex-direction: column; align-items: center; widrh: 100%;">
            <h1>Llibreria Dove</h1>
            <div>
                <a href="/PracticaUT3/insertar.jsp" class="btn-custom">Insertar Nuevo Libro</a>
            </div>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Títol</th>
                        <th>Autor</th>
                        <th>ISBN</th>
                        <th>Any Publicació</th>
                        <th>Editorial</th>
                        <th>Accions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        java.util.List<java.util.Map<String, String>> llibres =
                            (java.util.List<java.util.Map<String, String>>) request.getAttribute("llibres");

                        if (llibres != null && !llibres.isEmpty()) {
                            for (java.util.Map<String, String> llibre : llibres) {
                    %>
                    <tr>
                        <td><%= llibre.get("id") %></td>
                        <td><%= llibre.get("titol") %></td>
                        <td><%= llibre.get("autor") %></td>
                        <td><%= llibre.get("isbn") %></td>
                        <td><%= llibre.get("anyPublicacio") %></td>
                        <td><%= llibre.get("editorial") %></td>
                        <td>
                            <a href=<%= "/PracticaUT3/Actualizar?id=" + llibre.get("id")%> class="btn-edit btn-custom" style="width: 3rem">Editar</a>
                            <a href=<%= "/PracticaUT3/Eliminar?id=" + llibre.get("id")%> class="btn-delete btn-custom" style="width: 3rem">Eliminar</a>
                        </td>
                    </tr>
                    <%
                            }
                        } else {
                    %>
                    <tr>
                        <td colspan="7" class="text-center">No hay libros disponibles</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
    </div>

    <!-- Enlace a Bootstrap JS (opcional, para funcionalidad interactiva) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gyb2P7pTz3P7lPRzChJ6q4trB0JrJshvhu22A29Cqg+1kG4l2D" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyp6k4l0Vf3p9tce6VZXWv9s40ZT3he+JlV7lqXzM8JebF0JcQ2Mw5g" crossorigin="anonymous"></script>
</body>
</html>
