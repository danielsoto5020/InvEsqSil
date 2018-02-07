app.controller("tipoController",  ["$scope",  "tipoService", function tipoController($scope, tipoService) {
	$scope.mostrarDatosTipo= {};
	$scope.id ="";	
	$scope.tipoOut = {};
	$scope.tipoSearch = function(id){		
		tipoService.tipoSearch(id).then(function (message) {	
			$scope.tipoOut={"id":message.data.id,"nombre":message.data.nombre};
        	if(message.data.id == null){
        		alert("El registro de tipo de flor no existe");
        	}
        	else{
        		$scope.mostrarDatosTipo=tipoOut;
        	}
        });
	}
	$scope.tipoList={};
	$scope.getListTipo=function(){
		tipoService.getListTipo().then(function (message){
			$scope.tipoList=message.data;
			if($scope.tipoList ==={}){
				alert("No hay ningun registro de tipo de flor");
			}
		})
	}

	$scope.deleteTipo=function(id){	
		tipoService.deleteTipo(id).then(function(message){
			alert(message.data);
		});
	}
	
	$scope.date = new Date();
	
	$scope.tipoIn={};
	$scope.saveTipo=function(tipoIn){
		tipo={"id":tipoIn.id,"nombre":tipoIn.nombre};
		tipoService.saveTipo(tipoIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.tipoIn={};
	$scope.updateTipo= function(tipoIn){
		tipo={"id":tipoIn.id,"nombre":tipoIn.nombre};
		tipoService.updateTipo(tipoIn).then(function(message){
			alert(message.data);
		});
	}
}]);