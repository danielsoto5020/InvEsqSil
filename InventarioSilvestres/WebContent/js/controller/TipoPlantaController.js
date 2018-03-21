app
		.controller(
				"tipoPlantaController",
				[
						"$scope",
						"tipoPlantaService",
						function tipoPlantaController($scope, tipoPlantaService) {
							$scope.mostrarDatosTipoPlanta = {};
							$scope.id = "";
							$scope.tipoPlantaOut = {};
							$scope.tipoPlantaSearch = function(id) {
								tipoPlantaService
										.tipoPlantaSearch(id)
										.then(
												function(message) {
													$scope.tipoPlantaOut = {
														"id" : message.data.id,
														"ntipo" : message.data.ntipo,
														"nplanta" : message.data.nplanta
													};
													if (message.data.id == null) {
														alert("El registro relacion Esqueje-Tipo de flor no existe");
													} else {
														$scope.mostrarDatosTipoPlanta = tipoPlantaOut;
													}
												});
							}
							$scope.tipoPlantaList = {};
							$scope.getListTipoPlanta = function() {
								tipoPlantaService
										.getListTipoPlanta()
										.then(
												function(message) {
													$scope.tipoPlantaList = message.data;
													if ($scope.tipoPlantaList === {}) {
														alert("No hay ninguna relacion Esqueje-Tipo de flor");
													}
												})
							}

							$scope.deleteTipoPlanta = function(id) {
								tipoPlantaService.deleteTipoPlanta(id).then(
										function(message) {
											alert(message.data);
										});
							}

							$scope.date = new Date();

							$scope.tipoPlantaIn = {};
							$scope.saveTipoPlanta = function(tipoPlantaIn) {
								tipoPlanta = {
									"id" : tipoPlantaIn.id,
									"planta" : tipoPlantaIn.planta,
									"tipo" : tipoPlantaIn.tipo
								};
								tipoPlantaService.saveTipoPlanta(tipoPlantaIn)
										.then(function(message) {
											alert(message.data);
										})
							}
							$scope.tipoPlantaIn = {};
							$scope.updateTipoPlanta = function(tipoPlantaIn) {
								tipoPlanta = {
									"id" : tipoPlantaIn.id,
									"planta" : tipoPlantaIn.planta,
									"tipo" : tipoPlantaIn.tipo
								};
								tipoPlantaService
										.updateTipoPlanta(tipoPlantaIn).then(
												function(message) {
													alert(message.data);
												});
							}
						} ]);