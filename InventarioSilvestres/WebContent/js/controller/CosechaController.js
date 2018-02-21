app.controller("cosechaController", [ "$scope", "cosechaService",
		function cosechaController($scope, cosechaService) {
			$scope.mostrarDatosCosecha = {};
			$scope.id = "";
			$scope.cosechaOut = {};
			$scope.cosechaSearch = function(id) {
				cosechaService.cosechaSearch(id).then(function(message) {
					$scope.cosechaOut = {
						"id" : message.data.id,
						"cantidad" : message.data.cantidad,
						"fecha" : message.data.fecha,
						"observacion" : message.data.observacion,
						"variedad" : message.data.variedad,
						"cama" : message.data.cama,
						"empleado" : message.data.empleado,
						"siembra" : message.data.siembra
					};
					if (message.data.id == null) {
						alert("El registro de cosecha no existe");
					} else {
						$scope.mostrarDatosCosecha = cosechaOut;
					}
				});
			}
			$scope.cosechaList = {};
			$scope.getListCosecha = function() {
				cosechaService.getListCosecha().then(function(message) {
					$scope.siembraList = message.data;
					if ($scope.cosechaList === {}) {
						alert("No hay ningun registro de cosecha");
					}
				})
			}

			$scope.deleteCosecha = function(id) {
				temperaturaCosecha.deleteCosecha(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;

			$scope.cosechaIn = {};
			$scope.saveCosecha = function(cosechaIn) {
				temperatura = {
					"cantidad" : cosechaIn.cantidad,
					"fecha" : cosechaIn.fecha,
					"observacion" : cosechaIn.observacion,
					"variedad" : cosechaIn.variedad,
					"cama" : cosechaIn.cama,
					"empleado" : cosechaIn.empleado,
					"siembra" : cosechaIn.siembra
				};

				$scope.showForm = false;

				cosechaService.saveCosecha(cosechaIn).then(function(message) {
					alert(message.data);
				})
				$scope.cosechaIn = {};

			}
			$scope.cosechaIn = {};
			$scope.updateCosecha = function(cosechaIn) {
				cosecha = {
					"id" : cosechaIn.id,
					"cantidad" : cosechaIn.cantidad,
					"fecha" : cosechaIn.fecha,
					"observacion" : cosechaIn.observacion,
					"variedad" : cosechaIn.variedad,
					"cama" : cosechaIn.cama,
					"empleado" : cosechaIn.empleado,
					"siembra" : cosechaIn.siembra
				};
				cosechaService.updateCosecha(cosechaIn).then(function(message) {
					alert(message.data);
				});

			}
		} ]);