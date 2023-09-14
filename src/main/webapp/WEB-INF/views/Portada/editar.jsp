<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

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
		<h3 style="margin-top: 20px" align="center">Portada - Editar</h3>
		
		<!-- Formulario Spring -->
		<form name="" method="post" action="/quispesucso/portada/editar/${portada.portadaId}" enctype="multipart/form-data" class="mx-auto">
		
		<div class="shadow-lg p-4 mb-4 bg-white border border-2" style="width: 370px; margin: 20px auto; border-radius: 10px">
			<label>Portada ID:</label>
			<input type="text" name="portadaId" value="${portada.portadaId}" readonly="readonly" class="form-control"/> <br>
			
			<label>Imagen Actual:</label>
			<img src="data:${portada.getTypeImage()};base64,${portada.getBase64Image()}" width="120px" height="160px" border="1"/> <br> <br>
			
			<label>Archivo:</label>
			<input type="file" name="picture" accept="image/*"
				onchange="document.getElementById('picture_id').src=window.URL.createObjectURL(this.files[0])" class="form-control"/> <br>
			
			<label>Imagen Nueva:</label>
			<img id="picture_id" width="120px" height="160px" border="1"/> <br> <br>
			
			<div align="center">
				<button type="submit" class="btn btn-primary">Guardar</button>
				<button type="button" class="btn btn-secondary" onclick="location.href='/quispesucso/portadas'">Cancelar</button>
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