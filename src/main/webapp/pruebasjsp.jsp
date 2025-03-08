<%-- 
    Document   : pruebasjsp
    Created on : 7 Mar 2025, 04:08:36
    Author     : fnast
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if (request.getAttribute("llibres") == null) {  
%>
    <jsp:forward page="Consulta" />
<%
    }
%>

<html>
<head>
    <title>Listado de Libros</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 8px 12px;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
    </style>
</head>
<body>
    <h1 style="text-align:center;">Listado de Llibres</h1>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Títol</th>
                <th>Autor</th>
                <th>ISBN</th>
                <th>Any Publicació</th>
                <th>Editorial</th>
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
            </tr>
            <%
                    }
                } else {
            %>
            <tr>
                <td colspan="6">No hay libros disponibles</td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>
