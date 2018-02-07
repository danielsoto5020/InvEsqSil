app.controller("procesoController",  ["$scope",  "procesoService", function procesoController($scope, procesoService) {
	$scope.mostrarDatosProceso= {};
	$scope.id ="";
	$scope.procesoOut = {};
	$scope.procesoSearch = function(id){
		procesoService.procesoSearch(id).then(function (message) {
			$scope.procesoOut={"id":message.data.id,"nombre":message.data.nombre,"persona":message.data.persona};
        	if(message.data.id == null){
        		alert("El proceso no existe");
        	}
        	else{
        		$scope.mostrarDatosProceso=procesoOut;
        	}
        });
	}
	$scope.procesoList={};
	$scope.getListProceso=function(){
		procesoService.getListProceso().then(function (message){
			$scope.procesoList=message.data;
			if($scope.procesoList ==={}){
				alert("No hay ningun proceso registrado");
			}
		})
	}
	$scope.deleteProceso=function(id){
		procesoService.deleteProceso(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.procesoIn={};
	$scope.saveProceso=function(procesoIn){
		proceso={"id":procesoIn.id,"nombre":procesoIn.nombre,"persona":procesoIn.persona};
		procesoService.saveProceso(procesoIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.procesoIn={};
	$scope.updateProceso= function(procesoIn){
		proceso={"id":procesoIn.id,"nombre":procesoIn.nombre,"persona":procesoIn.persona};
		procesoService.updateProceso(procesoIn).then(function(message){
			alert(message.data);
		});
	}
	
}]);
