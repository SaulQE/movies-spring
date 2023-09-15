<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Librería Spring Form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Editar</title>
</head>
<body>
	<div Class="container ">
		<h3 style="margin-top: 20px" align="center">Cliente - Editar</h3>
		
		<!-- Formulario Spring -->
		<form:form name="" method="post" modelAttribute="cliente" class="mx-auto">
		
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 370px; margin: 20px auto; border-radius: 10px">
			<label>Cliente ID:</label>
			<form:input type="text" class="form-control" path="clienteId" readonly="true"/> <br>
			
			<label>Nombre Completo:</label>
			<form:input type="text" class="form-control" path="nomCompleto"/> <br>
			
			<label>F.Nacimiento:</label> 
			<form:input type="date" class="form-control" path="fnacimiento"/> <br>
			
			<label>Correo:</label> 
			<form:input type="text" class="form-control" path="correo"/> <br>
			
			<label>Contraseña:</label> 
			<form:input type="password" class="form-control" path="contraseña"/> <br>
			
			<label>Telefono:</label> 
			<form:input type="number" class="form-control" path="telefono"/> <br>
			
			<br>
			
			<div align="center">
				<button type="submit" class="btn btn-primary">Guardar</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/quispesucso/clientes'">Cancelar</button>
			</div>
		</div>
		</form:form>
	</div>
</body>
</html>