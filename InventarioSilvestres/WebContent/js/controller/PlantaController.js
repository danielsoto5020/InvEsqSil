app.controller("plantaController", [ "$scope", "plantaService",
		function plantaController($scope, plantaService) {
			$scope.mostrarDatosPlanta = {};
			$scope.id = "";
			$scope.plantaOut = {};
			$scope.plantaSearch = function(id) {
				plantaService.plantaSearch(id).then(function(message) {
					$scope.plantaOut = {
						"id" : message.data.id,
						"nombre" : message.data.nombre,
						"renombre" : message.data.renombre,
						"esquejecf" : message.data.esquejecf,
						"productividad" : message.data.productividad,
						"flush" : message.data.flush,
						"flushs" : message.data.flushs,
						"color1" : message.data.color1,
						"colores" : message.data.colores,
						"color2" : message.data.color2,
						"colorus" : message.data.colorus,
						"breeder" : message.data.breeder,
						"nbreeder" : message.data.nbreeder
					};
					if (message.data.id == null) {
						alert("La variedad no existe");
					} else {
						$scope.mostrarDatosPlanta = plantaOut;
					}
				});
			}
			$scope.plantaList = {};
			$scope.getListPlanta = function() {
				plantaService.getListPlanta().then(function(message) {
					$scope.plantaList = message.data;
					if ($scope.plantaList === {}) {
						alert("No hay ninguna variedad registrada");
					}
				})
			}

			$scope.deletePlanta = function(id) {
				plantaService.deletePlanta(id).then(function(message) {
					alert(message.data);
				});
			}
			
			$scope.showForm = false;
			
			$scope.plantaIn = {};
			$scope.savePlanta = function(plantaIn) {
				planta = {
					"nombre" : plantaIn.nombre,
					"renombre" : plantaIn.renombre,
					"esquejecf" : plantaIn.esquejecf,
					"productividad" : plantaIn.productividad,
					"flush" : plantaIn.flush,
					"flushs" : plantaIn.flushs,
					"color1" : plantaIn.color1,
					"color2" : plantaIn.color2,
					"breeder" : plantaIn.breeder
				};

				$scope.showForm = false;

				plantaService.savePlanta(plantaIn).then(function(message) {
					alert(message.data);
				})
			}
			
			$scope.plantaIn = {};
			$scope.updatePlanta = function(plantaIn) {
				planta = {
					"id" : plantaIn.id,
					"nombre" : plantaIn.nombre,
					"renombre" : plantaIn.renombre,
					"esquejecf" : plantaIn.esquejecf,
					"productividad" : plantaIn.productividad,
					"flush" : plantaIn.flush,
					"flushs" : plantaIn.flushs,
					"color1" : plantaIn.color1,
					"color2" : plantaIn.color2,
					"breeder" : plantaIn.breeder
				};
				plantaService.updatePlanta(plantaIn).then(function(message) {
					alert(message.data);
				});
			}
		} ]);