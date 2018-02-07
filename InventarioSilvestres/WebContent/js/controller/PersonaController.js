app.controller("personaController",  ["$scope",  "personaService", function personaController($scope, personaService) {
	$scope.mostrarDatosPersona= {};
	$scope.id ="";	
	$scope.personaOut = {};
	$scope.personaSearch = function(id){		
		personaService.personaSearch(id).then(function (message) {	
			$scope.personaOut={"id":message.data.id,"documento":message.data.documento,"nombre":message.data.nombre,
					"telefono":message.data.telefono,"correo":message.data.correo,"cargo":message.data.cargo,
					"codigo":message.data.codigo, "usuario":message.data.usuario,"contrasenia":message.data.contrasenia};
        	if(message.data.id == null){
        		alert("La persona no esta registrada");
        	}
        	else{
        		$scope.mostrarDatosPersona=personaOut;
        	}
        });
	}
	$scope.personaList={};
	$scope.getListPersona=function(){
		personaService.getListPersona().then(function (message){
			$scope.personaList=message.data;
			if($scope.personaList ==={}){
				alert("No hay ninguna persona registrada");
			}
		})
	}

	$scope.deletePersona=function(id){	
		personaService.deletePersona(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.personaIn={};
	$scope.savePersona=function(personaIn){
		persona={"id":personaIn.id,"documento":personaIn.documento,"nombre":personaIn.nombre,
				"telefono":personaIn.telefono,"correo":personaIn.correo,"cargo":personaIn.cargo,
				"codigo":personaIn.codigo, "usuario":personaIn.usuario,"contrasenia":personaIn.contrasenia};
		personaService.savePersona(personaIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.personaIn={};
	$scope.updatePersona= function(personaIn){
		persona={"id":personaIn.id,"documento":personaIn.documento,"nombre":personaIn.nombre,
				"telefono":personaIn.telefono,"correo":personaIn.correo,"cargo":personaIn.cargo,
				"codigo":personaIn.codigo, "usuario":personaIn.usuario,"contrasenia":personaIn.contrasenia};
		personaService.updatePersona(personaIn).then(function(message){
			alert(message.data);
		});
	}
}]);