<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Entidades.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Préstamos - Tu Banco</title>
	<script src="https://cdn.tailwindcss.com"></script>
	<style>
		body {
			font-family: 'Inter', sans-serif;
		}
		.profile-photo-placeholder {
			background-size: cover;
			background-position: center;
		}
	</style>
	<script>
		function confirmarLogout(e) {
			e.preventDefault();
			if (confirm("¿Estás seguro de que quieres cerrar sesión?")) {
				window.location.href = "<%=request.getContextPath()%>/ServletLogout";
			}
		}
	</script>
	<%
	Usuario usuario = (Usuario) session.getAttribute("usuarioLogueado");
	Cuenta cuenta = (Cuenta) session.getAttribute("cuenta");
	ArrayList<Cuenta> listaCuenta = (ArrayList<Cuenta>) session.getAttribute("cuentasUsuario");
	%>
</head>
<body class="bg-gray-100 h-screen overflow-hidden">
	<div class="flex h-full">
		<aside class="bg-white w-64 flex-shrink-0 p-4 border-r border-gray-200 flex flex-col items-center">
			<%
			String sexo = usuario.getPersona().getSexo();
			String rutaFoto = request.getContextPath() + "/img/perfilAdmi.webp";
			if (sexo != null) {
				if (sexo.equalsIgnoreCase("F") || sexo.equalsIgnoreCase("Femenino")) {
					rutaFoto = request.getContextPath() + "/img/perfilMujer.avif";
				} else if (sexo.equalsIgnoreCase("M") || sexo.equalsIgnoreCase("Masculino")) {
					rutaFoto = request.getContextPath() + "/img/perfilHombre.avif";
				}
			}
			%>
			<img src="<%=rutaFoto%>" alt="Foto de perfil" class="w-32 h-32 rounded-full object-cover mb-4 border-4 border-gray-300 shadow-md">
			<h3 class="text-xl font-bold text-gray-800 text-center mb-1">
				<%=usuario.getPersona().getNombre()%> <%=usuario.getPersona().getApellido()%>
			</h3>
			<%
			if (cuenta != null) {
			%>
			<p class="text-md text-gray-600 text-center mb-6">
				Saldo: $<span id="saldoActual"><%=cuenta.getSaldo() != null ? cuenta.getSaldo() : "---"%></span>
			</p>
			<%
			}
			%>
			<a href="#" onclick="confirmarLogout(event)" class="mt-auto bg-red-500 hover:bg-red-600 text-white text-center font-semibold py-2 px-4 rounded-md w-full">
				Salir
			</a>
		</aside>

		<main class="flex-1 flex flex-col overflow-y-auto">
			<header class="bg-white p-4 border-b border-gray-200 flex justify-between items-center">
				<h1 class="text-xl font-semibold text-gray-800">PRÉSTAMOS</h1>
				<div class="flex items-center">
					<img src="<%=request.getContextPath()%>/img/FotoLogo.webp" alt="Logo del banco" class="h-12 object-contain">
					<span class="text-gray-700 font-bold text-lg ml-2">Universidad Tecnológica Nacional</span>
				</div>
			</header>

			<nav class="bg-gray-50 border-b border-gray-200 p-4">
				<%
				String paginaActual = "prestamos";
				%>
				<ul class="flex items-center justify-between w-full px-4 py-2 bg-white shadow">
					<li><a href="<%=request.getContextPath()%>/ClientMode/homeClient.jsp"
						class="bg-green-600 hover:bg-green-700 text-white font-semibold py-2 px-4 rounded-md">
						Home</a></li>

					<li class="flex space-x-6 mx-auto">
						<a href="/BancoParcial/ClientMode/TransferenciaClient.jsp"
							class="<%=paginaActual.equals("transferencia") ? "bg-blue-600 text-white" : "hover:bg-blue-600 hover:text-white text-gray-700"%> font-semibold py-2 px-4 rounded-md">
							Transferencia</a>
						<a href="/BancoParcial/ServletListarMovimientos?Actualizar=1"
							class="<%=paginaActual.equals("movimientos") ? "bg-blue-600 text-white" : "hover:bg-blue-600 hover:text-white text-gray-700"%> font-semibold py-2 px-4 rounded-md">
							Movimientos</a>
						<a href="/BancoParcial/ClientMode/PrestamosClient.jsp"
							class="<%=paginaActual.equals("prestamos") ? "bg-blue-600 text-white" : "hover:bg-blue-600 hover:text-white text-gray-700"%> font-semibold py-2 px-4 rounded-md">
							Préstamos</a>
						<a href="<%=request.getContextPath()%>/ServletPersonalCliente"
							class="<%=paginaActual.equals("personal") ? "bg-blue-600 text-white" : "hover:bg-blue-600 hover:text-white text-gray-700"%> font-semibold py-2 px-4 rounded-md">
							Personal</a>
					</li>
					<li></li>
				</ul>
			</nav>

			<nav class="bg-gray-100 border-b border-gray-200 p-4">
	<ul class="flex justify-center space-x-6">
		<li>
			<a href="/BancoParcial/ClientMode/PrestamosClient.jsp"
				class="bg-blue-500 text-white font-semibold py-2 px-4 rounded-md transition duration-200 ease-in-out">
				Pedir Préstamos
			</a>
		</li>
		<li>
			<a href="/BancoParcial/ClientMode/pagarPrestamoClient.jsp"
				class="hover:bg-gray-200 text-gray-700 font-semibold py-2 px-4 rounded-md transition duration-200 ease-in-out">
				Pagar Préstamos
			</a>
		</li>
	</ul>
</nav>

			<div class="p-6 flex-1 flex flex-col items-center justify-center">
				<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-lg">
					<% if (request.getAttribute("mensaje") != null) { %>
					<div class="bg-green-100 border border-green-400 text-green-700 px-4 py-3 rounded mb-4 text-center font-semibold">
						<%=request.getAttribute("mensaje")%>
					</div>
					<% } %>

					<form action="<%=request.getContextPath()%>/ServletPedirPrestamoCliente" method="post" class="space-y-6">

						<label for="cuenta" class="block text-gray-700 text-lg font-semibold mb-2">Seleccionar Cuenta</label>
						<select id="cuenta" name="cuenta" onchange="actualizarSaldo()" required
							class="p-3 border border-gray-300 rounded-md w-full bg-white">
							<% if (cuenta != null) { %>
								<option value="<%=cuenta.getNroCuenta()%>" selected data-saldo="<%=cuenta.getSaldo()%>">
									CBU: <%=cuenta.getCbu()%>
								</option>
							<% } %>
							<%
							for (Cuenta c : listaCuenta) {
								if (cuenta == null || cuenta.getNroCuenta() != c.getNroCuenta()) {
							%>
								<option value="<%=c.getNroCuenta()%>" data-saldo="<%=c.getSaldo()%>">
									CBU: <%=c.getCbu()%>
								</option>
							<% }} %>
						</select>

						<div class="flex flex-col md:flex-row md:space-x-8 space-y-6 md:space-y-0">
							<div class="flex-1">
								<label for="monto_solicitar" class="block text-gray-700 text-lg font-semibold mb-2">Monto a solicitar</label>
								<input type="number" step="any" id="monto_solicitar" name="monto_solicitar"
									class="p-3 border border-gray-300 rounded-md w-full text-lg" required>
							</div>
							<div class="flex-1">
								<label for="cantidad_cuotas" class="block text-gray-700 text-lg font-semibold mb-2">Cantidad de cuotas</label>
								<select id="cantidad_cuotas" name="cantidad_cuotas"
									class="p-3 border border-gray-300 rounded-md w-full bg-white text-lg" required>
									<option value="">Seleccione cuotas</option>
									<option value="6">6 cuotas</option>
									<option value="12">12 cuotas</option>
									<option value="18">18 cuotas</option>
									<option value="24">24 cuotas</option>
									<option value="36">36 cuotas</option>
								</select>
							</div>
						</div>

						<div class="flex justify-center space-x-6 pt-4">
							<button type="submit"
								class="bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 px-6 rounded-md text-xl transition hover:scale-105">
								Solicitar</button>
							<button type="reset"
								class="bg-gray-500 hover:bg-gray-600 text-white font-bold py-3 px-6 rounded-md text-xl transition hover:scale-105">
								Cancelar</button>
						</div>
					</form>
				</div>
			</div>

			<footer class="bg-gray-200 p-4 text-center text-gray-600 border-t border-gray-200">
				GRUPO_N7
			</footer>
		</main>
	</div>

	<script>
		const selectCuenta = document.getElementById('cuenta');
		const saldoSpan = document.getElementById('saldoActual');

		function actualizarSaldo() {
			const selectedOption = selectCuenta.options[selectCuenta.selectedIndex];
			const saldo = selectedOption.getAttribute('data-saldo');
			if (saldoSpan) {
				saldoSpan.textContent = saldo ? parseFloat(saldo).toFixed(2) : '---';
			}
		}

		document.querySelector('form').addEventListener('submit', function(event) {
			const montoInput = document.getElementById('monto_solicitar');
			const monto = parseFloat(montoInput.value);
			if (isNaN(monto) || monto <= 0) {
				event.preventDefault();
				alert("El monto a solicitar debe ser un número positivo mayor que cero.");
				montoInput.focus();
			}
		});

		window.addEventListener('DOMContentLoaded', actualizarSaldo);
	</script>
</body>
</html>
