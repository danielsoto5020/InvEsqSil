app.controller("siembraController", [ "$scope", "siembraService",
		function siembraController($scope, siembraService) {
			$scope.mostrarDatosSiembra = {};
			$scope.id = "";
			$scope.siembraOut = {};
			$scope.siembraSearch = function(id) {
				siembraService.siembraSearch(id).then(function(message) {
					$scope.siembraOut = {
						"id" : message.data.id,
						"cantidad" : message.data.cantidad,
						"fecha" : message.data.fecha,
						"observacion" : message.data.observacion,
						"variedad" : message.data.variedad,
						"cama" : message.data.cama,
						"empleado" : message.data.empleado
					};
					if (message.data.id == null) {
						alert("El registro de siembra no existe");
					} else {
						$scope.mostrarDatosSiembra = siembraOut;
					}
				});
			}
			$scope.siembraList = {};
			$scope.getListSiembra = function() {
				siembraService.getListSimebra().then(function(message) {
					$scope.siembraList = message.data;
					if ($scope.siembraList === {}) {
						alert("No hay ningun registro de siembra");
					}
				})
			}

			$scope.deleteSiembra = function(id) {
				temperaturaService.deleteSiembra(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;

			$scope.siembraIn = {};
			$scope.saveSiembra = function(siembraIn) {
				temperatura = {
					"cantidad" : siembraIn.cantidad,
					"fecha" : siembraIn.fecha,
					"observacion" : siembraIn.observacion,
					"variedad" : siembraIn.variedad,
					"cama" : siembraIn.cama,
					"empleado" : siembraIn.empleado
				};

				$scope.showForm = false;

				siembraService.saveSimebra(siembraIn).then(function(message) {
					alert(message.data);
				})
				$scope.siembraIn = {};

			}
			$scope.siembraIn = {};
			$scope.updateSiembra = function(siembraIn) {
				siembra = {
					"id" : siembraIn.id,
					"cantidad" : siembraIn.cantidad,
					"fecha" : siembraIn.fecha,
					"observacion" : siembraIn.observacion,
					"variedad" : siembraIn.variedad,
					"cama" : siembraIn.cama,
					"empleado" : siembraIn.empleado
				};
				siembraService.updateSiembra(siembraIn).then(function(message) {
					alert(message.data);
				});

			}
		} ]);