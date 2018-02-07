app.controller("colorController",  ["$scope",  "colorService", function colorController($scope, colorService) {
	$scope.mostrarDatosColor= {};
	$scope.id ="";
	$scope.colorOut = {};
	$scope.colorSearch = function(id){
		colorService.colorSearch(id).then(function (message) {
			$scope.colorOut={"id":message.data.id,"nombre":message.data.nombre,"name":message.data.name};
        	if(message.data.id == null){
        		alert("Color no registrado en Base de Datos!!!");
        	}
        	else{
        		$scope.mostrarDatosColor=colorOut;
        	}
        });
	}
	$scope.colorList={};
	$scope.getListColor=function(){
		colorService.getListColor().then(function (message){
			$scope.colorList=message.data;
			if($scope.colorList ==={}){
				alert("No hay ningun color registrado!!!");
			}
		})
	}

	$scope.deleteColor=function(id){
		colorService.deleteColor(id).then(function(message){
			alert(message.data);
		});
	}
	$scope.colorIn={};
	$scope.saveColor=function(colorIn){
		color={"id":colorIn.id,"nombre":colorIn.nombre,"name":colorIn.name};
		colorService.saveColor(colorIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.colorIn={};
	$scope.updateColor= function(colorIn){
		color={"id":colorIn.id,"nombre":colorIn.nombre,"name":colorIn.name};
		colorService.updateColor(colorIn).then(function(message){
			alert(message.data);
		});
	}
}]);