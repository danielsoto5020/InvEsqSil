app.controller("empleadoController",  ["$scope",  "empleadoService", function empleadoController($scope, empleadoService) {
	$scope.mostrarDatosEmpleado= {};
	$scope.id ="";
	$scope.empleadoOut = {};
	$scope.empleadoSearch = function(id){
		empleadoService.empleadoSearch(id).then(function (message) {
			$scope.empleadoOut={"id":message.data.id, "tipodoc":message.data.tipodoc, "documento":message.data.documento,
					"nombre":message.data.nombre, "apellido":message.data.apellido};
        	if(message.data.id == null){
        		alert("El empleado no existe");
        	}
        	else{
        		$scope.mostrarDatosEmpleado=empleadoOut;
        	}
        });
	}
	$scope.empleadoList={};
	$scope.getListEmpleado=function(){
		empleadoService.getListEmpleado().then(function (message){
			$scope.empleadoList=message.data;
			if($scope.empleadoList ==={}){
				alert("No hay ningun empleado registrado");
			}
		})
	}

	$scope.deleteEmpleado=function(id){
		empleadoService.deleteEmpleado(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.empleadoIn={};
	$scope.saveEmpleado=function(empleadoIn){
		empleado={"id":empleadoIn.id, "tipodoc":empleadoIn.tipodoc, "documento":empleadoIn.documento,
				"nombre":empleadoIn.nombre, "apellido":empleadoIn.apellido};
		empleadoService.saveEmpleado(empleadoIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.empleadoIn={};
	$scope.updateEmpleado= function(empleadoIn){
		empleado={"id":empleadoIn.id, "tipodoc":empleadoIn.tipodoc, "documento":empleadoIn.documento,
				"nombre":empleadoIn.nombre, "apellido":empleadoIn.apellido};
		empleadoService.updateEmpleado(empleadoIn).then(function(message){
			alert(message.data);
		});
	}
}]);
