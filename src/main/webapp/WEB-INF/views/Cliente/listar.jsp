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
	<title>Director</title>
</head>
<style>
	th,td{
		text-align:center;
	}
</style>
<body>
<div align="center" style="margin: 20px 140px">
	<h2>Clientes - Listar</h2><br>

	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/home" style="text-decoration: none;color: white;">Home</a>
	</button>
	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/cliente/registrar" style="text-decoration: none;color: white;">Registrar</a>
	</button><br><br>
	
	<table class="table table-bordered table-hover">
		<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>Nombre Completo</th>
			<th>F.Nacimiento</th>
			<th>Correo</th>
			<th>Contaseña</th>
			<th>Teléfono</th>
			<th>Acción</th>
		</tr>
		</thead>

		<c:forEach var="cliente" items="${bClientes}">
			<tr>
				<td>${cliente.clienteId}</td>
				<td>${cliente.nomCompleto}</td>
				<td>${cliente.fnacimiento}</td>
				<td>${cliente.correo}</td>
				<td>${cliente.contraseña}</td>
				<td>${cliente.telefono}</td>
				<td align="center">
					<button type="button" class="btn btn-info">
						<a href="/quispesucso/cliente/detalle/${cliente.clienteId}" style="text-decoration: none; color: black;">Detalle</a>
					</button>
					<button type="button" class="btn btn-warning">
						<a href="/quispesucso/cliente/editar/${cliente.clienteId}" style="text-decoration: none; color: black;">Editar</a>
					</button>
					<button type="button" class="btn btn-danger">
						<a href="/quispesucso/cliente/borrar/${cliente.clienteId}" style="text-decoration: none; color: white;">Borrar</a>
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>