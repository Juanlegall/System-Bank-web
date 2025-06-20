<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Transferencias - Tu Banco</title>
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
			<p class="text-md text-gray-600 text-center mb-6">Saldo: $$$</p>

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
					class="absolute bg-white border border-gray-300 rounded-md shadow-lg mt-1 w-full z-10 hidden ">
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
				<h1 class="text-xl font-semibold text-gray-800">TRANSFERENCIAS</h1>
				<div class="text-gray-700 font-bold">LOGO / NAME DEL BANCO</div>
			</header>

			<nav class="bg-gray-50 border-b border-gray-200 p-4">
				<ul class="flex space-x-4 justify-center">
					<li><a href="TransferenciaClient.jsp"
						class="bg-blue-600 text-white font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Transferencia</a></li>
					<li><a href="movientosClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Movimientos</a></li>
					<li><a href="PrestamosClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Prestamos</a></li>
					<li><a href="personalClient.jsp"
						class="hover:bg-blue-600 hover:text-white text-gray-700 font-semibold py-2 px-4 rounded-md focus:outline-none focus:shadow-outline transition duration-200 ease-in-out">Personal</a></li>
				</ul>
			</nav>

			<div class="p-6 flex-1 flex flex-col items-center justify-center">
				<div class="bg-white p-8 rounded-lg shadow-md w-full max-w-md">
					<form action="TransferirServlet" method="post" class="space-y-6">
						<div class="mb-4">
							<label for="monto"
								class="block text-gray-700 text-lg font-semibold mb-2">Monto
								a transferir</label> <input type="number" id="monto" name="monto"
								placeholder=""
								class="p-3 border border-gray-300 rounded-md w-full focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-lg"
								required>
						</div>
						<div class="mb-4">
							<label for="alias_cbu"
								class="block text-gray-700 text-lg font-semibold mb-2">Alias
								/ CBU</label> <input type="text" id="alias_cbu" name="alias_cbu"
								placeholder=""
								class="p-3 border border-gray-300 rounded-md w-full focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-lg"
								required>
						</div>
						<div class="mb-6">
							<label for="referencia"
								class="block text-gray-700 text-lg font-semibold mb-2">Referencia</label>
							<input type="text" id="referencia" name="referencia"
								placeholder=""
								class="p-3 border border-gray-300 rounded-md w-full focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent text-lg">
						</div>

						<button type="submit"
							class="w-full bg-blue-600 hover:bg-blue-700 text-white font-bold py-3 px-4 rounded-md focus:outline-none focus:shadow-outline-blue focus:ring-2 focus:ring-blue-500 focus:ring-opacity-50 transition duration-300 ease-in-out transform hover:scale-105 text-xl">
							Transferir!</button>
					</form>
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
</body>
</html>