<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 
<!-- Libreria JSTL Core -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
		  integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
	<title>Sucursal</title>
</head>
<style>
	th,td{
		text-align:center;
	}
</style>
<body>
<div align="center" style="margin: 20px 140px">
	<h2>Sucursales - Listar</h2><br>

	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/home" style="text-decoration: none;color: white;">Home</a>
	</button>
	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/sucursal/registrar" style="text-decoration: none;color: white;">Registrar</a>
	</button><br><br>
	
	<table class="table table-bordered table-hover">
		<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Dirección</th>
			<th>Teléfono</th>
			<th>Acción</th>
		</tr>
		</thead>

		<c:forEach var="sucursal" items="${bSucursales}">
			<tr>
				<td>${sucursal.sucursalId}</td>
				<td>${sucursal.nombre}</td>
				<td>${sucursal.direccion}</td>
				<td>${sucursal.telefono}</td>
				<td align="center">
					<button type="button" class="btn btn-info">
						<a href="/quispesucso/sucursal/detalle/${sucursal.sucursalId}" style="text-decoration: none; color: black;">Detalle</a>
					</button>
					<button type="button" class="btn btn-warning">
						<a href="/quispesucso/sucursal/editar/${sucursal.sucursalId}" style="text-decoration: none; color: black;">Editar</a>
					</button>
					<button type="button" class="btn btn-danger">
						<a href="/quispesucso/sucursal/borrar/${sucursal.sucursalId}" style="text-decoration: none; color: white;">Borrar</a>
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
</body>
</html>