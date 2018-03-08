app.controller("salidaController", [ "$scope", "salidaService",
		function salidaController($scope, salidaService) {
			$scope.mostrarDatosSalida = {};
			$scope.id = "";
			$scope.salidaOut = {};
			$scope.salidaSearch = function(id) {
				salidaService.salidaSearch(id).then(function(message) {
					$scope.salidaOut = {
						"id" : message.data.id,
						"cantidad" : message.data.cantidad,
						"fecha" : message.data.fecha,
						"observacion" : message.data.observacion,
						"variedad" : message.data.variedad,
						"bloque" : message.data.bloque,
						"cama" : message.data.cama,
						"empleado" : message.data.empleado
					};
					if (message.data.id == null) {
						alert("El registro de salida no existe");
					} else {
						$scope.mostrarDatosSalida = salidaOut;
					}
				});
			}
			$scope.salidaList = {};
			$scope.getListSalida = function() {
				salidaService.getListSalida().then(function(message) {
					$scope.salidaList = message.data;
					if ($scope.salidaList === {}) {
						alert("No hay ningun registro de salida");
					}
				})
			}

			$scope.deleteSalida = function(id) {
				salidaService.deleteSalida(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;
			$scope.salidaIn = {};
			$scope.saveSalida = function(salidaIn) {
				salida = {
					"cantidad" : salidaIn.cantidad,
					"fecha" : salidaIn.fecha,
					"observacion" : salidaIn.observacion,
					"esterilizacion" : salidaIn.esterilizacion,
					"variedad" : salidaIn.variedad,
					"nombrebloque" : salidaIn.nombrebloque,
					"cama" : salidaIn.cama,
					"empleado" : salidaIn.empleado
				};

				$scope.showForm = false;

				salidaService.saveSalida(salidaIn).then(function(message) {
					alert(message.data);
				})
				$scope.salidaIn = {};

			}
			$scope.salidaIn = {};
			$scope.updateSalida = function(salidaIn) {
				salida = {
					"id" : salidaIn.id,
					"cantidad" : salidaIn.cantidad,
					"fecha" : salidaIn.fecha,
					"observacion" : salidaIn.observacion,
					"variedad" : salidaIn.variedad,
					"nombrebloque" : salidaIn.nombrebloque,
					"ncama" : salidaIn.ncama,
					"empleado" : salidaIn.empleado
				};
				salidaService.updateSalida(salidaIn).then(function(message) {
					alert(message.data);
				});

			}
		} ]);