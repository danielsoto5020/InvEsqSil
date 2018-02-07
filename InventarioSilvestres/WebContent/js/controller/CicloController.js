app.controller("cicloController",  ["$scope",  "cicloService", function cicloController($scope, cicloService) {
	$scope.mostrarDatosCiclo= {};
	$scope.id ="";	
	$scope.cicloOut = {};
	$scope.cicloSearch = function(id){		
		cicloService.cicloSearch(id).then(function (message) {	
			$scope.cicloOut={"id":message.data.id,"cantidad":message.data.cantidad,"fecha":message.data.fecha,
					"cama":message.data.cama,"persona":message.data.persona, "planta":message.data.planta,
					"proceso":message.data.proceso, "ciclo":message.data.ciclo};
        	if(message.data.id == null){
        		alert("No exite el registro del ciclo");
        	}
        	else{
        		$scope.mostrarDatosCiclo=cicloOut;
        	}
        });
	}
	$scope.cicloList={};
	$scope.getListCiclo=function(){
		cicloService.getListCiclo().then(function (message){
			$scope.cicloList=message.data;
			if($scope.cicloList ==={}){
				alert("No hay ningun ciclo registrado");
			}
		})
	}

	$scope.deleteCiclo=function(id){	
		cicloService.deleteCiclo(id).then(function(message){
			alert(message.data);
		});
	}
	
	$scope.date = new Date();
	
	$scope.cicloIn={};
	$scope.saveCiclo=function(cicloIn){
		ciclo={"id":cicloIn.id,"cantidad":cicloIn.cantidad,"fecha":cicloIn.fecha,"cama":cicloIn.cama,
			"persona":cicloIn.persona, "planta":cicloIn.planta,"proceso":cicloIn.proceso, "ciclo":cicloIn.ciclo};
		cicloService.saveCiclo(cicloIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.cicloIn={};
	$scope.updateCiclo= function(cicloIn){
		ciclo={"id":cicloIn.id,"cantidad":cicloIn.cantidad,"fecha":cicloIn.fecha,"cama":cicloIn.cama,
			"persona":cicloIn.persona, "planta":cicloIn.planta,"proceso":cicloIn.proceso, "ciclo":cicloIn.ciclo};
		cicloService.updateCiclo(cicloIn).then(function(message){
			alert(message.data);
		});
	}
}]);