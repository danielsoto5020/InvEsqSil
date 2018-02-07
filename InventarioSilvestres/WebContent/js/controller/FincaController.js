app.controller("fincaController",  ["$scope",  "fincaService", function fincaController($scope, fincaService) {
	$scope.mostrarDatosFinca= {};
	$scope.id ="";
	$scope.fincaOut = {};
	$scope.fincaSearch = function(id){
		fincaService.fincaSearch(id).then(function (message) {
			$scope.fincaOut={"id":message.data.id,"nombre":message.data.nombre,"ubicacion":message.data.ubicacion,
					"telefono1":message.data.telefono1};
        	if(message.data.id == null){
        		alert("La finca no existe");
        	}
        	else{
        		$scope.mostrarDatosFinca=fincaOut;
        	}
        });
	}
	$scope.fincaList={};
	$scope.getListFinca=function(){
		fincaService.getListFinca().then(function (message){
			$scope.fincaList=message.data;
			if($scope.fincaList ==={}){
				alert("No hay ninguna finca registrada");
			}
		})
	}

	$scope.deleteFinca=function(id){
		fincaService.deleteFinca(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.fincaIn={};
	$scope.saveFinca=function(fincaIn){
		finca={"id":fincaIn.id, "nombre":fincaIn.nombre,"ubicacion":fincaIn.ubicacion,"telefono1":fincaIn.telefono1};
		fincaService.saveFinca(fincaIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.fincaIn={};
	$scope.updateFinca= function(fincaIn){
		finca={"id":fincaIn.id,"nombre":fincaIn.nombre,"ubicacion":fincaIn.ubicacion,"telefono1":fincaIn.telefono1};
		fincaService.updateFinca(fincaIn).then(function(message){
			alert(message.data);
		});
	}
}]);
