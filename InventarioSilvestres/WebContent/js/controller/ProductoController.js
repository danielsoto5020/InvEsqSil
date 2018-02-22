app.controller("productoController", [
		"$scope",
		"productoService",
		function productoController($scope, productoService) {
			$scope.mostrarDatosProducto = {};
			$scope.id = "";
			$scope.productoOut = {};
			$scope.productoSearch = function(id) {
				productoService.productoSearch(id).then(function(message) {
					$scope.productoOut = {
						"id" : message.data.id,
						"nombre" : message.data.nombre
					};
					if (message.data.id == null) {
						alert("El Producto no esta registrado");
					} else {
						$scope.mostrarDatosProducto = productoOut;
					}
				});
			}
			$scope.productoList = {};
			$scope.getListProducto = function() {
				productoService.getListProducto().then(function(message) {
					$scope.productoList = message.data;
					if ($scope.productoList === {}) {
						alert("No hay ningun Producto registrado");
					}
				})
			}

			$scope.deleteProducto = function(id) {
				productoService.deleteProducto(id).then(function(message) {
					alert(message.data);
				});
			}
			$scope.showForm = false;
			$scope.productoIn = {};
			$scope.saveProducto = function(personaIn) {
				producto = {
					"id" : productoIn.id,
					"nombre" : productoIn.nombre
				};
				$scope.showForm = false;
				productoService.saveProducto(productoIn).then(
						function(message) {
							alert(message.data);
						})
				$scope.productoIn = {};
			}
			$scope.productoIn = {};
			$scope.updateProducto = function(productoIn) {
				producto = {
					"id" : productoIn.id,
					"nombre" : productoIn.nombre
				};
				productoService.updateProducto(productoIn).then(
						function(message) {
							alert(message.data);
						});
			}
		} ]);