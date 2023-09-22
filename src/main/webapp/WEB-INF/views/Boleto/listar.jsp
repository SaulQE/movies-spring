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
	<h2>Boleto - Listar</h2><br>

	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/home" style="text-decoration: none;color: white;">Home</a>
	</button>
	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/boleto/registrar" style="text-decoration: none;color: white;">Registrar</a>
	</button><br><br>
	
	<table class="table table-bordered table-hover">
		<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>NroButaca</th>
			<th>Precio</th>
			<th>F.Compra</th>
			<th>TipoBoleto</th>
			<th>Cliente</th>
			<th>Sala</th>
			<th>Acción</th>
		</tr>
		</thead>

		<c:forEach var="boleto" items="${bBoletos}">
			<tr>
				<td>${boleto.boletoId}</td>
				<td>${boleto.nroButaca}</td>
				<td>${boleto.precio}</td>
				<td>${boleto.fcompra}</td>
				<td>${boleto.tipoBoleto}</td>
				<td>${boleto.cliente.nomCompleto}</td>
				<td>${boleto.sala.nombre}</td>
				<td align="center">
					<button type="button" class="btn btn-info">
						<a href="/quispesucso/boleto/detalle/${boleto.boletoId}" style="text-decoration: none; color: black;">Detalle</a>
					</button>
					<button type="button" class="btn btn-warning">
						<a href="/quispesucso/boleto/editar/${boleto.boletoId}" style="text-decoration: none; color: black;">Editar</a>
					</button>
					<button type="button" class="btn btn-danger">
						<a href="/quispesucso/boleto/borrar/${boleto.boletoId}" style="text-decoration: none; color: white;">Borrar</a>
					</button>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>