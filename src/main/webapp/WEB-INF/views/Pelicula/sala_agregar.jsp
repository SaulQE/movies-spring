<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Registrar</title>
	
	<style>
		th,td{
			text-align:center;
		}
	</style>
	
	<script type="text/javascript">
		function agregarJS(salaId,peliculaId) {
			location.href="/quispesucso/pelicula_sala/agregar/"+salaId+"/"+peliculaId;
		}
	</script>
</head>
<body>
	<div class="container">
		<h3 style="margin-top: 20px" align="center">Pelicula - Sala</h3>
		
		<form:form name="" method="post" modelAttribute="pelicula" class="mx-auto">
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 370px; margin: 20px auto; border-radius: 10px">
			
			<!-- productoId oculto -->
			<input type="hidden" id="inputPeliculaId" value="${pelicula.peliculaId}"/>
						
			<label>Título:</label>
			<form:input type="text" class="form-control" path="titulo" readonly="true"/> <br>
			
			<label>Sala:</label>
			<select name="" id="selectSalaId" class="form-control">
				<option value="">-- Seleccione --</option>
				<c:forEach var="sala" items="${bSalas1}">
					<option value="${sala.salaId}">${sala.nombre}</option>
				</c:forEach>
			</select> <br>
			
			<div align="center">
				<button type="button" class="btn btn-success"
				onclick="agregarJS(document.getElementById('selectSalaId').value,document.getElementById('inputPeliculaId').value)">
				Agregar
			</button> 
			</div>
			
			<h5 style="margin:40px 0 0 0 " align="center">Tabla: Pelicula - Sala</h5><br>
			<table class="table table-bordered table-hover">
				<thead class="table-dark">
					<tr>
						<td><b>ID</b></td>
						<td><b>Sala</b></td>
						<td><b>CantButacas</b></td>
					</tr>
				</thead>
				<c:forEach var="sala" items="${bSalas2}">
					<tr>
						<td>${sala.salaId}</td>
						<td>${sala.nombre}</td>
						<td>${sala.cantButacas}</td>
					</tr>
				</c:forEach>
			</table> <br>
			
			<div align="center">
			<button type="submit" class="btn btn-primary">Guardar</button>
			<button type="button" class="btn btn-secondary" onclick="location.href='/quispesucso/peliculas'">Cancelar</button>
			</div>
		</div>
		</form:form>
				
	</div>
</body>
</html>