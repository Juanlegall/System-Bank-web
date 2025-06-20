<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Movimientos - Tu Banco</title>
<script src="https://cdn.tailwindcss.com"></script>
<style>
body {
	font-family: 'Inter', sans-serif; /* O la fuente que prefieras */
}

.profile-photo-placeholder {
	background-size: cover;
	background-position: center;
}
</style>
</head>
<body class="bg-gray-100 h-screen overflow-hidden">
	<div class="flex h-full">

		<aside
			class="bg-white w-64 flex-shrink-0 p-4 border-r border-gray-200 flex flex-col items-center">

			<div class="w-full h-48 bg-gray-300 mb-4 profile-photo-placeholder">
			</div>

			<h3 class="text-xl font-bold text-gray-800 text-center mb-1">Nombre
				Apellido</h3>
			<p class="text-md text-gray-600 text-center mb-6">Saldo: $$$XXX</p>

			<div class="relative w-full mb-6">
				<button
					class="bg-gray-200 hover:bg-gray-300 text-gray-700 font-semibold py-2 px-4 rounded-md w-full text-left focus:outline-none focus:shadow-outline flex items-center justify-between"
					id="dropdown-button">
					Cuentas
					<svg class="w-4 h-4 fill-current ml-2" viewBox="0 0 20 20">
						<path
							d="M9.293 12.95l.707.707L15.657 8l-1.414-1.414L10 10.828 5.757 6.586 4.343 8z" /></svg>
				</button>
				<div id="dropdown-list"
					class="absolute bg-white border border-gray-300 rounded-md shadow-lg mt-1 w-full z-10 hidden">
					<a href="#"
						class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100">Cuenta
						1</a> <a href="#"
						class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100">Cuenta
						2</a> <a href="#"
						class="block py-2 px-4 text-sm text-gray-700 hover:bg-gray-100">Ver
						todas</a>
				</div>
			</div>

			<a href="logout.jsp"
				class="mt-auto bg-red-500 hover:bg-red-600 text-white text-center font-semibold py-2 px-4 rounded-md w-full focus:outline-none focus:shadow-outline block">
				Salir </a>
		</aside>

		<main class="flex-1 flex flex-col overflow-y-auto">

			<header
				class="bg-white p-4 border-b border-gray-200 flex justify-between items-center">
				<h1 class="text-xl font-semibold text-gray-800">MOVIMIENTOS</h1>
				<div class="text-gray-700 font-bold">LOGO / NAME DEL BANCO</div>
			</header>

			<nav class="bg-gray-50 border-b border-gray-200 p-4">
				<ul class="flex space-x-4 justify-center">
					<li><a href="TransferenciaClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Transferencia</a></li>
					<li><a href="movientosClient.jsp"
						class="bg-blue-600 text-white font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Movimientos</a></li>
					<li><a href="PrestamosClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Prestamos</a></li>
					<li><a href="personalClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Personal</a></li>
				</ul>
			</nav>

			<div
				class="bg-gray-50 border-b border-gray-200 p-4 flex flex-col space-y-4 md:flex-row md:space-x-4 md:space-y-0 items-center">

				<input type="text" placeholder="Input de búsqueda"
					class="flex-1 p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">

				<select
					class="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">
					<option value="">Operación</option>
					<option value="entrada">Entrada</option>
					<option value="salida">Salida</option>
				</select> <select
					class="p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent">
					<option value="">Periodo</option>
					<option value="hoy">Hoy</option>
					<option value="semana">Última Semana</option>
					<option value="mes">Último Mes</option>
					<option value="anio">Último Año</option>
				</select>

				<button
					class="bg-blue-600 hover:bg-blue-700 text-white font-bold p-2 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50 transition duration-200 ease-in-out w-10 h-10 flex items-center justify-center">
					&#x1F50D;</button>
			</div>

			<div class="p-6 flex-1 overflow-y-auto">
				<div class="bg-white rounded-lg shadow overflow-hidden">
					<table class="min-w-full divide-y divide-gray-200">
						<thead class="bg-red-700 text-white">
							<tr>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Nº
									Cuenta</th>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Código
									Movimiento</th>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Fecha</th>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Detalle</th>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Importe</th>
								<th scope="col"
									class="px-6 py-3 text-left text-xs font-semibold uppercase tracking-wider">Tipo
									Movimiento</th>
							</tr>
						</thead>
						<tbody class="bg-white divide-y divide-gray-200">
							<tr>
								<td
									class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">202156</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">10023</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">04-11-2024</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">-</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">100000</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">Transferencia</td>
							</tr>
							<tr>
								<td
									class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">202156</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">10023</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">04-11-2024</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">-</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">100000</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">Transferencia</td>
							</tr>
							<tr>
								<td
									class="px-6 py-4 whitespace-nowrap text-sm font-medium text-gray-900">202156</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">10023</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">04-11-2024</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">-</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">100000</td>
								<td class="px-6 py-4 whitespace-nowrap text-sm text-gray-800">Transferencia</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div
					class="bg-red-700 p-3 rounded-b-lg shadow-lg flex justify-end items-center mt-0">
					<button
						class="p-2 mx-1 text-white opacity-75 hover:opacity-100 rounded-md focus:outline-none focus:ring-2 focus:ring-white">
						&larr;</button>
					<button
						class="bg-red-500 text-white font-bold p-2 mx-1 rounded-md focus:outline-none focus:ring-2 focus:ring-white">
						1</button>
					<button
						class="p-2 mx-1 text-white opacity-75 hover:opacity-100 rounded-md focus:outline-none focus:ring-2 focus:ring-white">
						2</button>
					<button
						class="p-2 mx-1 text-white opacity-75 hover:opacity-100 rounded-md focus:outline-none focus:ring-2 focus:ring-white">
						3</button>
					<button
						class="p-2 mx-1 text-white opacity-75 hover:opacity-100 rounded-md focus:outline-none focus:ring-2 focus:ring-white">
						&rarr;</button>
				</div>
			</div>

			<footer
				class="bg-gray-200 p-4 text-center text-gray-600 border-t border-gray-200 flex-shrink-0">
				GRUPO_N7 </footer>
		</main>

	</div>

	<script>
        const dropdownButton = document.getElementById('dropdown-button');
        const dropdownList = document.getElementById('dropdown-list');

        if (dropdownButton && dropdownList) {
            dropdownButton.addEventListener('click', () => {
                dropdownList.classList.toggle('hidden');
            });
        }
    </script>
</html>