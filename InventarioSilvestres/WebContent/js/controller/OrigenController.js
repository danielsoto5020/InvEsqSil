app.controller("origenController",  ["$scope",  "origenService", function origenController($scope, origenService) {
	$scope.mostrarDatosOrigen= {};
	$scope.id ="";	
	$scope.origenOut = {};
	$scope.origenSearch = function(id){		
		origenService.origenSearch(id).then(function (message) {	
			$scope.origenOut={"id":message.data.id, "nombre":message.data.nombre};
        	if(message.data.id == null){
        		alert("Origen no esta registrado");
        	}
        	else{
        		$scope.mostrarDatosOrigen=origenOut;
        	}
        });
	}
	$scope.origenList={};
	$scope.getListOrigen=function(){
		origenService.getListOrigen().then(function (message){
			$scope.origenList=message.data;
			if($scope.origenList ==={}){
				alert("No se encontro ningun origen");
			}
		})
	}

	$scope.deleteOrigen=function(id){	
		origenService.deleteOrigen(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.showForm = false;
	$scope.origenIn={};
	$scope.saveOrigen=function(origenIn){
		origen={"id":origenIn.id, "nombre":origenIn.nombre};
		$scope.showForm = false;
		origenService.saveOrigen(origenIn).then(function(message){
			alert(message.data);
		})

		$scope.origenIn={};
	}
	$scope.origenIn={};
	$scope.updateOrigen= function(origenIn){
		origen={"id":origenIn.id, "nombre":origenIn.nombre};
		origenService.updateOrigen(origenIn).then(function(message){
			alert(message.data);
		});
	}
}]);