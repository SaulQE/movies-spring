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
	<title>Libros</title>
</head>
<style>
	th,td{
		text-align:center;
	}
</style>
<body>
<div align="center" style="margin: 20px 140px">
	<h2>Peliculas - Listar</h2><br>

	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/home" style="text-decoration: none;color: white;">Home</a>
	</button>
	<button type="button" class="btn btn-dark">
		<a href="/quispesucso/pelicula/registrar" style="text-decoration: none;color: white;">Registrar</a>
	</button><br><br>
	
	<table class="table table-bordered table-hover">
		<thead class="table-dark">
		<tr>
			<th>ID</th>
			<th>Título</th>
			<th>Protagonista</th>
			<th>Idioma</th>
			<th>Estreno</th>
			<th>Género</th>
			<th>DurMinutos</th>
			<th>Puntuación</th>
			<th>Nom.Director</th>
			<th>Portada</th>
			<th>Acción</th>
		</tr>
		</thead>

		<c:forEach var="pelicula" items="${bPeliculas}">
			<tr>
				<td>${pelicula.peliculaId}</td>
				<td>${pelicula.titulo}</td>
				<td>${pelicula.protagonista}</td>
				<td>${pelicula.idioma}</td>
				<td>${pelicula.estreno}</td>
				<td>${pelicula.genero}</td>
				<td>${pelicula.dur_minutos}</td>
				<td>${pelicula.puntuacion}</td>
				<td>${pelicula.director.nombre}</td>
				<td>
					<img src="data:${pelicula.portada.getTypeImage()};base64,${pelicula.portada.getBase64Image()}" 
						 width="70px" height="100px" border="1"/>
					</td>
				<td align="center">
					<button type="button" class="btn btn-info">
						<a href="/quispesucso/pelicula/detalle/${pelicula.peliculaId}" style="text-decoration: none; color: black;">Detalle</a>
					</button>
					<button type="button" class="btn btn-warning">
						<a href="/quispesucso/pelicula/editar/${pelicula.peliculaId}" style="text-decoration: none; color: black;">Editar</a>
					</button>
					<button type="button" class="btn btn-danger">
						<a href="/quispesucso/pelicula/borrar/${pelicula.peliculaId}" style="text-decoration: none; color: white;">Borrar</a>
					</button>
					<button type="button" class="btn btn-info">
						<a href="/quispesucso/pelicula/sala_agregar/${pelicula.peliculaId}" style="text-decoration: none; color: black;">+Sala</a>
					</button>
					
				</td>
			</tr>
		</c:forEach>
		<tr>
        	<td colspan="6" class="text-end"><b>Suma de los minutos:</b></td>
        	<td class="text-center">${sumMinutos}</td>
    	</tr>
	</table>
</div>
</body>
</html>