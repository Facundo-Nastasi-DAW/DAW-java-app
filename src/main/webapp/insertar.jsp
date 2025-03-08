<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Insertar Libro</title>
    <!-- Enlace a Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEJ03v3wwrnQWsf1mYk1Nn87wCm5vkdW6ZlEPl5VRzAxtXOsHXQ5KwDbF1kHg" crossorigin="anonymous">
    <style>
        body {
            background-color: #e5f7f3; /* Fondo verde azulado claro */
        }
        .container {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        h1 {
            color: #4fb7b1; /* Título en verde azulado */
            text-align: center;
        }
        .btn-custom {
            background-color: #4fb7b1; /* Verde azulado */
            color: white;
            text-decoration: none;
            padding: 8px 15px;
            border-radius: 5px;
            display: inline-block;
            width: 100%; /* Botón a tamaño completo en móviles */
            text-align: center;
            margin-top: 15px;
        }
        .btn-custom:hover {
            background-color: #3e9d98; /* Verde azulado más oscuro */
        }
        label {
            font-weight: bold;
            color: #4fb7b1; /* Etiquetas en verde azulado */
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
            border-radius: 5px;
            border: 1px solid #ccc;
        }
        /* Estilo adicional para los inputs y selects */
        input[type="number"] {
            -moz-appearance: textfield;
        }
        /* Ajuste para pantallas pequeñas */
        @media (max-width: 768px) {
            .btn-custom {
                padding: 10px; /* Asegurarse de que los botones se ajusten bien */
            }
        }
    </style>
</head>
<body>
    <div class="container" style="display: flex; flex-direction: column; align-items: center; gap: 2rem;">
        <h1>Insertar Nuevo Libro</h1>
        <a href="/PracticaUT3" class="btn-custom" style="width: 19rem;">Volver</a>
        <form action="Crear" method="post">
            <div class="mb-3">
                <label for="titol" class="form-label">Título</label>
                <input type="text" id="titol" name="titol" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="isbn" class="form-label">ISBN</label>
                <input type="text" id="isbn" name="isbn" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="any_publicacio" class="form-label">Año de Publicación</label>
                <input type="number" id="any_publicacio" name="any_publicacio" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="editorial" class="form-label">Editorial</label>
                <select id="editorial" name="editorial" class="form-control" required>
                    <option value="1">Penguin Random House</option>
                    <option value="2">HarperCollins</option>
                    <option value="3">Simon & Schuster</option>
                    <option value="4">Macmillan Publishers</option>
                    <option value="5">Hachette Livre</option>
                </select>
            </div>
            <button type="submit" class="btn-custom">Insertar Libro</button>
        </form>
    </div>

    <!-- Enlace a Bootstrap JS (opcional, para funcionalidad interactiva) -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz4fnFO9gyb2P7pTz3P7lPRzChJ6q4trB0JrJshvhu22A29Cqg+1kG4l2D" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js" integrity="sha384-cn7l7gDp0eyp6k4l0Vf3p9tce6VZXWv9s40ZT3he+JlV7lqXzM8JebF0JcQ2Mw5g" crossorigin="anonymous"></script>
</body>
</html>
