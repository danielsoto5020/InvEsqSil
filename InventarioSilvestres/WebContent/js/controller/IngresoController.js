app.controller("ingresoController", [ "$scope", "ingresoService",
		function ingresoController($scope, ingresoService) {
			$scope.mostrarDatosIngreso = {};
			$scope.id = "";
			$scope.ingresoOut = {};
			$scope.ingresoSearch = function(id) {
				ingresoService.ingresoSearch(id).then(function(message) {
					$scope.ingresoOut = {
						"id" : message.data.id,
						"cantidad" : message.data.cantidad,
						"puesto" : message.data.puesto,
						"nivel" : message.data.nivel,
						"lado" : message.data.lado,
						"fecha" : message.data.fecha,
						"variedad" : message.data.variedad,
						"nempleado" : message.data.nempleado,
						"cama" : message.data.cama,
						"siembra" : message.data.siembra
					};
					if (message.data.id == null) {
						alert("El ingreso no existe");
					} else {
						$scope.mostrarDatosIngreso = ingresoOut;
					}
				});
			}
			$scope.ingresoList = {};
			$scope.getListIngreso = function() {
				ingresoService.getListIngreso().then(function(message) {
					$scope.ingresoList = message.data;
					if ($scope.ingresoList === {}) {
						alert("No hay ningun ingreso");
					}
				});
			}
			$scope.deleteIngreso = function(id) {
				ingresoService.deleteIngreso(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;

			$scope.ingresoIn = {};
			$scope.saveIngreso = function(ingresoIn) {
				ingreso = {
					"cantidad" : ingresoIn.cantidad,
					"puesto" : ingresoIn.puesto,
					"nivel" : ingresoIn.nivel,
					"lado" : ingresoIn.lado,
					"fecha" : ingresoIn.fecha,
					"empleado" : ingresoIn.empleado,
					"siembra" : ingresoIn.siembra
				};

				$scope.showForm = false;

				ingresoService.saveIngreso(ingresoIn).then(function(message) {
					alert(message.data);
				})
				$scope.ingresoIn = {};
				$scope.date = new Date();

			}
			$scope.ingresoIn = {};
			$scope.updateIngreso = function(ingresoIn) {
				ingreso = {
					"id" : ingresoIn.id,
					"cantidad" : ingresoIn.cantidad,
					"puesto" : ingresoIn.puesto,
					"nivel" : ingresoIn.nivel,
					"lado" : ingresoIn.lado,
					"fecha" : ingresoIn.fecha,
					"empleado" : ingresoIn.empleado,
					"siembra" : ingresoIn.siembra
				};
				ingresoService.updateIngreso(ingresoIn).then(function(message) {
					alert(message.data);
				});

			}
		} ]);
