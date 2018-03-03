app.controller("camaController", [ "$scope", "camaService",
		function camaController($scope, camaService) {
			$scope.mostrarDatosCama = {};
			$scope.id = "";
			$scope.camaOut = {};
			$scope.camaSearch = function(id) {
				camaService.camaSearch(id).then(function(message) {
					$scope.camaOut = {
						"id" : message.data.id,
						"numero" : message.data.numero,
						"ancho" : message.data.ancho,
						"largo" : message.data.largo,
						"lineas" : message.data.lineas,
						"nlinea" : message.data.nlinea,
						"estado" : message.data.estado,
						"esterilizacion" : message.data.esterilizacion,
						"bloque" : message.data.bloque
					};
					if (message.data.id == null) {
						alert("La cama no existe");
					} else {
						$scope.mostrarDatosCama = camaOut;
					}
				});
			}
			$scope.camaSelect = {};
			$scope.getSelectCama = function() {
				camaService.getSelectCama().then(function(message) {
					$scope.camaSelect = message.data;
					if ($scope.camaSelect === {}) {
						alert("Sin espacio en camas");
					}
				})
			}

			$scope.camaList = {};
			$scope.getListCama = function() {
				camaService.getListCama().then(function(message) {
					$scope.camaList = message.data;
					if ($scope.camaList === {}) {
						alert("No hay ninguna cama registrada");
					}
				})
			}

			$scope.date = new Date();

			$scope.deleteCama = function(id) {
				camaService.deleteCama(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.showForm = false;
			$scope.camaIn = {};
			$scope.saveCama = function(camaIn) {
				cama = {
					"numero" : camaIn.numero,
					"ancho" : camaIn.ancho,
					"largo" : camaIn.largo,
					"lineas" : camaIn.lineas,
					"nlinea" : camaIn.nlinea,
					"estado" : camaIn.estado,
					"esterilizacion" : camaIn.esterilizacion,
					"bloque" : camaIn.bloque
				};
				$scope.showForm = false;
				camaService.saveCama(camaIn).then(function(message) {
					alert(message.data);
				})
				$scope.camaIn = {};
			}
			$scope.camaIn = {};
			$scope.updateCama = function(camaIn) {
				cama = {
					"id" : camaIn.id,
					"numero" : camaIn.numero,
					"ancho" : camaIn.ancho,
					"largo" : camaIn.largo,
					"lineas" : camaIn.lineas,
					"nlinea" : camaIn.nlinea,
					"estado" : camaIn.estado,
					"esterilizacion" : camaIn.esterilizacion,
					"bloque" : camaIn.bloque
				};
				camaService.updateCama(camaIn).then(function(message) {
					alert(message.data);
				});
			}
		} ]);