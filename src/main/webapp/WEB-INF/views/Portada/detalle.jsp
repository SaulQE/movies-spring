<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Detalle</title>
</head>
<body>
	<div class="container">
		<h3 style="margin-top: 20px" align="center">Portada - Detalle</h3>
		
		<!-- Formulario -->
		<form name="" method="post" action="/quispesucso/portada/detalle/${portada.portadaId}" enctype="multipart/form-data" class="mx-auto">
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 320px; margin: 20px auto; border-radius: 10px">
			<b>Portada ID:</b> ${portada.portadaId} <br>
			<b>Nombre:</b> ${portada.nombre} <br>
			<b>Portada:</b><br>
			<img src="data:${portada.getTypeImage()};base64,${portada.getBase64Image()}" width="120px" height="160px" border="1"/> <br> <br>
			<div align="center">
				<button class="btn btn-dark" type="submit" name="btnHome">Home</button>
				<button class="btn btn-secondary" type="submit" name="btnVolver">Volver</button>
			</div>
		</div>
		</form>
	</div>
	
</body>
</html>