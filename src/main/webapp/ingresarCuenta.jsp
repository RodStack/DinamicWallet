<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.List" %>
<%@ page import = "com.curso4.dinamicwallet.modelo.Cuenta" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Crear Cuenta Nueva</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">

</head>
<body>
	<div class="container mt-5">
            <h1 class="display-4">Bienvenido</h1>
            <p class="lead">Aquí puedes comenzar a gestionar tus Cuentas</p>
            <div class="card">
                <div class="card-body">
                	<h1 class="display-5">Crear nueva cuenta</h1>
                    <form action="cuentas" method="post">
                    	<div class="form-group">
                            <label>Numero de Cuenta:</label>
                            <input type="text" class="form-control" name="numeroCuenta" id="numeroCuenta">
                        </div>
                        <div class="form-group">
                            <label>Titular:</label>
                            <input type="text" class="form-control" name="titularCuenta" id="titularCuenta">
                        </div>
                        <div class="form-group">
                            <label>Saldo:</label>
                            <input type="text" class="form-control" name="saldoCuenta" id="saldoCuenta">
                        </div>
                        <input type="submit" class="btn btn-primary" value="Enviar">
                    </form>
                </div>
            </div>
            <div class="container mt-3">
		        <table class="table table-striped table-hover">
		            <thead class="thead-dark">
		                <tr>
		                    <th>N° de Cuenta</th>
		                    <th>Titular</th>
		                    <th>Saldo</th>
		                    <th>Modificar</th>
		                    <th>Borrar</th>
		                </tr>
		            </thead>
		            <tbody>
		                <%
		                List<Cuenta> cuentas = (List<Cuenta>) request.getAttribute("cuentas");
		                if (cuentas != null) {
		                    for (Cuenta cuenta : cuentas) {
		                %>
		                <tr>
		                    <td class="editable" contenteditable="false"><%= cuenta.getNumeroCuenta() %></td>
		                    <td class="editable" contenteditable="false"><%= cuenta.getTitular() %></td>
		                    <td class="editable" contenteditable="false"><%= cuenta.getSaldo() %></td>
		                    <td><a href="#" class="btn btn-primary edit-btn"><i class="fas fa-pencil-alt"></i></a>
                				<button style="display: none;" class="btn btn-success confirm-btn"><i class="fas fa-check"></i></button></td>
							<td>
								<form method="post" action="delete">
							    	<input type="hidden" name="numeroCuenta" value="<%= cuenta.getNumeroCuenta() %>">
							    	<button type="submit" class="btn btn-danger" onclick="return confirm('Estas seguro que quieres borrar la cuenta?');"><i class="fas fa-trash"></i></button>
								</form>
							</td>
		                </tr>
		                <%
		                    }
		                } else {
		                     response.sendRedirect("cuentas");
		                     return;
		                }
		                %>
		            </tbody>
		        </table>
    	</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
	 <script>
	  document.querySelectorAll('.edit-btn').forEach(function(button) {
	    button.addEventListener('click', function(event) {
	      const row = button.closest('tr');
	      const cells = row.querySelectorAll('td');
	      const numeroCuenta = cells[0].innerText;
	      const titular = cells[1].innerText;
	      const saldo = cells[2].innerText;
	
	      // Crear el formulario oculto
	      const form = document.createElement('form');
	      form.action = 'update';
	      form.method = 'post';
	      form.style.display = 'none';
	
	      // Crear los campos de entrada dentro del formulario
	      const numeroCuentaInput = document.createElement('input');
	      numeroCuentaInput.type = 'text';
	      numeroCuentaInput.name = 'numeroCuenta';
	      numeroCuentaInput.value = numeroCuenta;
	      numeroCuentaInput.readOnly = true;
	      form.appendChild(numeroCuentaInput);
	
	      const titularCuentaInput = document.createElement('input');
	      titularCuentaInput.type = 'text';
	      titularCuentaInput.name = 'titularCuenta';
	      titularCuentaInput.value = titular;
	      form.appendChild(titularCuentaInput);
	
	      const saldoCuentaInput = document.createElement('input');
	      saldoCuentaInput.type = 'text';
	      saldoCuentaInput.name = 'saldoCuenta';
	      saldoCuentaInput.value = saldo;
	      form.appendChild(saldoCuentaInput);
	
	      // Agregar el formulario al cuerpo del documento
	      document.body.appendChild(form);
	
	      // Transformar los textos en campos editables dentro de la fila
	      cells[0].innerHTML = '<input type="text" name="numeroCuenta" value="' + numeroCuenta + '" readonly>';
	      cells[1].innerHTML = '<input type="text" name="titularCuenta" value="' + titular + '">';
	      cells[2].innerHTML = '<input type="text" name="saldoCuenta" value="' + saldo + '">';
	
	      // Agregar un input de tipo "submit" al formulario
	      const submitInput = document.createElement('input');
	      submitInput.type = 'submit';
	      submitInput.value = 'Guardar';
	      submitInput.classList.add('btn', 'btn-success');
	      form.appendChild(submitInput);
	
	      // Reemplazar el botón "Editar" por botones de check y "X"
	      const buttonContainer = document.createElement('div');
	      buttonContainer.classList.add('btn-group');
	
	      const checkButton = document.createElement('button');
	      checkButton.type = 'button';
	      checkButton.innerHTML = '<i class="fas fa-check"></i>';
	      checkButton.classList.add('btn', 'btn-success');
	      buttonContainer.appendChild(checkButton);
	
	      const cancelButton = document.createElement('button');
	      cancelButton.type = 'button';
	      cancelButton.innerHTML = '<i class="fas fa-times"></i>';
	      cancelButton.classList.add('btn', 'btn-danger');
	      cancelButton.addEventListener('click', function() {
	        // Restablecer los valores originales en la fila
	        cells[0].innerHTML = numeroCuenta;
	        cells[1].innerHTML = titular;
	        cells[2].innerHTML = saldo;
	        buttonContainer.parentNode.replaceChild(button, buttonContainer);
	      });
	      buttonContainer.appendChild(cancelButton);
	
	      checkButton.addEventListener('click', function() {
	        // Rellenar los valores del formulario con los valores editados
	        numeroCuentaInput.value = cells[0].querySelector('input').value;
	        titularCuentaInput.value = cells[1].querySelector('input').value;
	        saldoCuentaInput.value = cells[2].querySelector('input').value;
	
	        // Mostrar el botón "Confirmar"
	        const confirmButton = document.createElement('button');
	        confirmButton.type = 'button';
	        confirmButton.textContent = 'Confirmar';
	        confirmButton.classList.add('btn', 'btn-success');
	        confirmButton.addEventListener('click', function() {
	          submitInput.click(); // Activar el input de envío del formulario
	        });
	        buttonContainer.replaceChild(confirmButton, checkButton);
	        buttonContainer.removeChild(cancelButton);
	      });
	
	      button.parentNode.replaceChild(buttonContainer, button);
	    });
	  });
	</script>
</body>
</html>