app.controller("breederController",  ["$scope",  "breederService", function breederController($scope, breederService) {
	$scope.mostrarDatosBreeder= {};
	$scope.id ="";	
	$scope.breederOut = {};
	$scope.breederSearch = function(id){		
		breederService.breederSearch(id).then(function (message) {	
			$scope.breederOut={"id":message.data.id,"nombre":message.data.nombre,"telefono1":message.data.telefono1,
					 "correo":message.data.correo, "web":message.data.web, "contacto":message.data.contacto};
        	if(message.data.id == null){
        		alert("El breeder no existe");
        	}
        	else{
        		$scope.mostrarDatosbreeder=breederOut;
        	}
        });
	}
	$scope.breederList={};
	$scope.getListBreeder=function(){
		breederService.getListBreeder().then(function (message){
			$scope.breederList=message.data;
			if($scope.breederList ==={}){
				alert("No hay ningun breeder registrado");
			}
		})
	}

	$scope.deleteBreeder=function(id){	
		breederService.deleteBreeder(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.breederIn={};
	$scope.saveBreeder=function(breederIn){
		breeder={"id":breederIn.id,"nombre":breederIn.nombre,"telefono1":breederIn.telefono1,
				 "correo":breederIn.correo, "web":breederIn.web, "contacto":breederIn.contacto};
		breederService.saveBreeder(breederIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.breederIn={};
	$scope.updateBreeder= function(breederIn){
		breeder={"id":breederIn.id,"nombre":breederIn.nombre,"telefono1":breederIn.telefono1,
				 "correo":breederIn.correo, "web":breederIn.web, "contacto":breederIn.contacto};
		breederService.updateBreeder(breederIn).then(function(message){
			alert(message.data);
		});
	}
}]);