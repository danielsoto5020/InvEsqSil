app.controller("bloqueController", [ "$scope", "bloqueService",
		function bloqueController($scope, bloqueService) {
			$scope.mostrarDatosBloque = {};
			$scope.id = "";
			$scope.bloqueOut = {};
			$scope.bloqueSearch = function(id) {
				bloqueService.bloqueSearch(id).then(function(message) {
					$scope.bloqueOut = {
						"id" : message.data.id,
						"nombre" : message.data.nombre,
						"ncama" : message.data.ncama,
						"finca" : message.data.finca
					};
					if (message.data.id == null) {
						alert("El bloque no existe");
					} else {
						$scope.mostrarDatosBloque = bloqueOut;
					}
				});
			}
			$scope.bloqueList = {};
			$scope.getListBloque = function() {
				bloqueService.getListBloque().then(function(message) {
					$scope.bloqueList = message.data;
					if ($scope.bloqueList === {}) {
						alert("No hay ningun bloque registrado");
					}
				})
			}

			$scope.deleteBloque = function(id) {
				bloqueService.deleteBloque(id).then(function(message) {
					alert(message.data);
				});
			}
			$scope.showForm = false;
			$scope.bloqueIn = {};
			$scope.saveBloque = function(bloqueIn) {
				bloque = {
					"id" : bloqueIn.id,
					"nombre" : bloqueIn.nombre,
					"ncama" : bloqueIn.ncama,
					"finca" : bloqueIn.finca
				};
				$scope.showForm = false;
				bloqueService.saveBloque(bloqueIn).then(function(message) {
					alert(message.data);
				})
				$scope.bloqueIn = {}
			}
			$scope.bloqueIn = {};
			$scope.updateBloque = function(bloqueIn) {
				bloque = {
					"id" : bloqueIn.id,
					"nombre" : bloqueIn.nombre,
					"ncama" : bloqueIn.ncama,
					"finca" : bloqueIn.finca
				};
				bloqueService.updateBloque(bloqueIn).then(function(message) {
					alert(message.data);
				});
			}
		} ]);