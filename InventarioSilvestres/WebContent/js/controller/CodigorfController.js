app
		.controller(
				"codigorfController",
				[
						"$scope",
						"codigorfService",
						function codigorfController($scope, codigorfService) {
							$scope.mostrarDatosCodigorf = {};
							$scope.id = "";
							$scope.codigorfOut = {};
							$scope.codigorfSearch = function(id) {
								codigorfService
										.codigorfSearch(id)
										.then(
												function(message) {
													$scope.codigorfOut = {
														"id" : message.data.id,
														"codigo" : message.data.codigo,
														"planta" : message.data.planta
													};
													if (message.data.id == null) {
														alert("Codigo RedFlor no registrado en Base de Datos!!!");
													} else {
														$scope.mostrarDatosCodigorf = codigorfOut;
													}
												});
							}
							$scope.codigorfList = {};
							$scope.getListCodigorf = function() {
								codigorfService
										.getListCodigorf()
										.then(
												function(message) {
													$scope.codigorfList = message.data;
													if ($scope.codigorfList === {}) {
														alert("No hay ningun codigo de RedFlor registrado!!!");
													}
												})
							}

							$scope.deleteCodigorf = function(id) {
								codigorfService.deleteCodigorf(id).then(
										function(message) {
											alert(message.data);
										});
							}
							$scope.showForm = false;
							$scope.codigorfIn = {};
							$scope.saveCodigorf = function(codigorfIn) {
								codigorf = {
									"id" : codigorfIn.id,
									"codigo" : codigorfIn.codigo,
									"planta" : codigorfIn.planta
								};
								$scope.showForm = false;
								codigorfService.saveCodigorf(codigorfIn).then(
										function(message) {
											alert(message.data);
										})
										$scope.codigorfIn = {};
							}
							$scope.codigorfIn = {};
							$scope.updateCodigorf = function(codigorfIn) {
								codigorf = {
									"id" : codigorfIn.id,
									"codigo" : codigorfIn.codigo,
									"planta" : codigorfIn.planta
								};
								codigorfService.updateCodigorf(codigorfIn)
										.then(function(message) {
											alert(message.data);
										});
							}
						} ]);