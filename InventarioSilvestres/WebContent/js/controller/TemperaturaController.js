app.controller( "temperaturaController", [ "$scope", "temperaturaService",
		function temperaturaController($scope, temperaturaService) {
							$scope.mostrarDatosTemperatura = {};
							$scope.id = "";
							$scope.temperaturaOut = {};
							$scope.temperaturaSearch = function(id) {
								temperaturaService
										.temperaturaSearch(id)
										.then(
												function(message) {
													$scope.temperaturaOut = {
														"id" : message.data.id,
														"valor" : message.data.valor,
														"fecha" : message.data.fecha,
														"sector" : message.data.sector,
														"lugar" : message.data.lugar,
														"bloque" : message.data.bloque,
														"persona" : message.data.persona,
														"npersona" : message.data.npersona
													};
													if (message.data.id == null) {
														alert("El registro de temperatura no existe");
													} else {
														$scope.mostrarDatosTemperatura = temperaturaOut;
													}
												});
							}
							$scope.temperaturaList = {};
							$scope.getListTemperatura = function() {
								temperaturaService
										.getListTemperatura()
										.then(
												function(message) {
													$scope.temperaturaList = message.data;
													if ($scope.temperaturaList === {}) {
														alert("No hay ningun registro detemperatura");
													}
												})
							}

							$scope.deleteTemperatura = function(id) {
								temperaturaService.deleteTemperatura(id).then(
										function(message) {
											alert(message.data);
										});
							}

							$scope.date = new Date();

							$scope.showForm = false;

							$scope.temperaturaIn = {};
							$scope.saveTemperatura = function(temperaturaIn) {
								temperatura = {
									"valor" : temperaturaIn.valor,
									"fecha" : temperaturaIn.fecha,
									"sector" : temperaturaIn.sector,
									"lugar" : temperaturaIn.lugar,
									"bloque" : temperaturaIn.bloque,
									"persona" : temperaturaIn.persona
								};

								$scope.showForm = false;

								temperaturaService.saveTemperatura(
										temperaturaIn).then(function(message) {
									alert(message.data);
								})
								$scope.temperaturaIn = {};

							}
							$scope.temperaturaIn = {};
							$scope.updateTemperatura = function(temperaturaIn) {
								temperatura = {
									"id" : temperaturaIn.id,
									"valor" : temperaturaIn.valor,
									"fecha" : temperaturaIn.fecha,
									"sector" : temperaturaIn.sector,
									"lugar" : temperaturaIn.lugar,
									"bloque" : temperaturaIn.bloque,
									"persona" : temperaturaIn.persona
								};
								temperaturaService.updateTemperatura(
										temperaturaIn).then(function(message) {
									alert(message.data);
								});
								
							}
						} ]);