app.controller("ingresoController", [ "$scope", "ingresoService",
		function ingresoController($scope, ingresoService) {
			$scope.mostrarDatosIngreso = {};
			$scope.id = "";
			$scope.ingresoOut = {};
			$scope.ingresoSearch = function(id) {
				ingresoService.ingresoSearch(id).then(function(message) {
					$scope.ingresoOut = {
						"id" : message.data.id,
						"cantidad" : message.data.cantidad,
						"puesto" : message.data.puesto,
						"nivel" : message.data.nivel,
						"lado" : message.data.lado,
						"fecha" : message.data.fecha,
						"variedad" : message.data.variedad,
						"nempleado" : message.data.nempleado,
						"origen" : message.data.origen
					};
					if (message.data.id == null) {
						alert("El ingreso no existe");
					} else {
						$scope.mostrarDatosIngreso = ingresoOut;
					}
				});
			}
			$scope.ingresoList = {};
			$scope.getListIngreso = function() {
				ingresoService.getListIngreso().then(function(message) {
					$scope.ingresoList = message.data;
					if ($scope.ingresoList === {}) {
						alert("No hay ningun ingreso");
					}
				});
			}
			$scope.pedidoList={};
			$scope.getPedidoList=function(planta,origen,cantidad){
				ingresoService.getPedidoList(planta,origen,cantidad).then(function (message){
					$scope.pedidoList=message.data;
					if($scope.pedidoList ==={}){
						alert("No hay ningun registro");
					}
				});
			}
			$scope.origenList = {};
			$scope.getListOrigen = function() {
				ingresoService.getListOrigen().then(
						function(message){
						$scope.origenList = message.data;
						})
			}
			$scope.siembraList = {};
			$scope.getListSiembra = function() {
				ingresoService.getListSiembra().then(
						function(message){
						$scope.siembraList = message.data;
						})
			}
			$scope.empleadoList = {};
			$scope.getListEmpleado = function() {
				ingresoService.getListEmpleado().then(
						function(message){
						$scope.empleadoList = message.data;
						})
			}
			$scope.deleteIngreso = function(id) {
				ingresoService.deleteIngreso(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;

			$scope.ingresoIn = {};
			$scope.saveIngreso = function(ingresoIn) {
				ingreso = {
					"cantidad" : ingresoIn.cantidad,
					"puesto" : ingresoIn.puesto,
					"nivel" : ingresoIn.nivel,
					"lado" : ingresoIn.lado,
					"fecha" : ingresoIn.fecha,
					"empleado" : ingresoIn.empleado,
					"origen" : ingresoIn.origen,
					"siembra" : ingresoIn.siembra
				};

				$scope.showForm = false;

				ingresoService.saveIngreso(ingresoIn).then(function(message) {
					alert(message.data);
				})
				$scope.ingresoIn = {};
				$scope.date = new Date();

			}
			$scope.ingresoIn = {};
			$scope.updateIngreso = function(ingresoIn) {
				ingreso = {
					"id" : ingresoIn.id,
					"cantidad" : ingresoIn.cantidad,
					"puesto" : ingresoIn.puesto,
					"nivel" : ingresoIn.nivel,
					"lado" : ingresoIn.lado,
					"fecha" : ingresoIn.fecha,
					"empleado" : ingresoIn.empleado,
					"origen" : ingresoIn.origen,
					"siembra" : ingresoIn.siembra
				};
				ingresoService.updateIngreso(ingresoIn).then(function(message) {
					alert(message.data);
				});

			}
		} ]);
