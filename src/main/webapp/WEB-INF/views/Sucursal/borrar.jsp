<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Librería Spring Form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Borrar</title>
</head>
<body>
	<div Class="container ">
		<h3 style="margin-top: 20px" align="center">Director - Borrar</h3>
		
		<!-- Formulario Spring -->
		<form:form name="" method="post" modelAttribute="sucursal" class="mx-auto">
		
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 320px; margin: 20px auto; border-radius: 10px">
			<label>Sucursal ID:</label>
			<form:input type="number" class="form-control" path="sucursalId" readonly="true"/> <br>
			<label>Nombre:</label> 
			<form:input type="text" class="form-control" path="nombre" readonly="true"/> <br>
			
			<p class="text-center">¿Está seguro de borrar la sucursal?</p><br>
			<div align="center">
				<button class="btn btn-danger" type="submit">Borrar</button>
				<button class="btn btn-secondary" type="button" onclick="location.href='/quispesucso/sucursales'">Cancelar</button>
			</div>
		</div>
		</form:form>
	</div>
	
</body>
</html>