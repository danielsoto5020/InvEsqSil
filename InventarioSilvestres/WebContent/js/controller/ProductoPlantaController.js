app
		.controller(
				"productoPlantaController",
				[
						"$scope",
						"productoPlantaService",
						function productoPlantaController($scope,
								productoPlantaService) {
							$scope.mostrarDatosProductoPlanta = {};
							$scope.id = "";
							$scope.productoPlantaOut = {};
							$scope.productoPlantaSearch = function(id) {
								productoPlantaService
										.productoPlantaSearch(id)
										.then(
												function(message) {
													$scope.productoPlantaOut = {
														"id" : message.data.id,
														"nproducto" : message.data.nproducto,
														"nplanta" : message.data.nplanta
													};
													if (message.data.id == null) {
														alert("La relacion Esqueje-Producto no esta registrado");
													} else {
														$scope.mostrarDatosProductoPlanta = productoPlantaOut;
													}
												});
							}
							$scope.productoPlantaList = {};
							$scope.getListProductoPlanta = function() {
								productoPlantaService
										.getListProductoPlanta()
										.then(
												function(message) {
													$scope.productoPlantaList = message.data;
													if ($scope.productoPlantaList === {}) {
														alert("No hay ninguna relacion Producto-Esqueje registrado");
													}
												})
							}

							$scope.deleteProductoPlanta = function(id) {
								productoPlantaService.deleteProductoPlanta(id)
										.then(function(message) {
											alert(message.data);
										});
							}
							$scope.productoPlantaIn = {};
							$scope.saveProductoPlanta = function(
									personaPlantaIn) {
								productoPlanta = {
									"id" : productoPlantaIn.id,
									"producto" : productoPlantaIn.producto,
									"planta" : productoPlantaIn.planta
								};
								productoPlantaService.saveProductoPlanta(
										productoPlantaIn).then(
										function(message) {
											alert(message.data);
										})
							}
							$scope.productoPlantaIn = {};
							$scope.updateProductoPlanta = function(
									productoPlantaIn) {
								productoPlanta = {
									"id" : productoIn.id,
									"producto" : productoPlantaIn.producto,
									"planta" : productoPlantaIn.planta
								};
								productoPlantaService.updateProductoPlanta(
										productoPlantaIn).then(
										function(message) {
											alert(message.data);
										});
							}
						} ]);