<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!-- Libreria Spring Form -->
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Registrar</title>
</head>
<body>
	<div class="container">
		<h3 style="margin-top: 20px" align="center">Pelicula - Detalle</h3>
		
		<!-- Formulario Spring -->
		<form name="" method="post" class="mx-auto">
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 320px; margin: 20px auto; border-radius: 10px">
			<b>Pelicula ID:</b> ${pelicula.peliculaId} <br>
			<b>Título:</b> ${pelicula.titulo} <br>
			<b>Protagonista:</b> ${pelicula.protagonista} <br>
			<b>Idioma:</b> ${pelicula.idioma} <br>
			<b>Director:</b> ${pelicula.director} <br>
			<b>Género:</b> ${pelicula.genero} <br>
			<b>Precio:</b> ${pelicula.precio} <br>
			<b>Estreno:</b> ${pelicula.estreno} <br>
			<b>DurMinutos:</b> ${pelicula.dur_minutos} <br><br>
		
			<div align="center">
				<button class="btn btn-dark" type="submit" name="btnHome">Home</button>
				<button class="btn btn-secondary" type="submit" name="btnVolver">Volver</button>
			</div>
		</div>
		</form>
	</div>
	
<!-- Scripts -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous">
</script>
</body>
</html>