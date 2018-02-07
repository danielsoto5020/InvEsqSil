app.controller("inventarioController",  ["$scope",  "inventarioService", function inventarioController($scope, inventarioService) {
	$scope.mostrarDatosInventario= {};
	$scope.id ="";
	$scope.inventarioOut = {};
	$scope.inventarioSearch = function(inv_id){
		inventarioService.inventarioSearch(inv_id).then(function (message) {
			$scope.inventarioOut={"inv_id":message.data.inv_id,"inv_origen":message.data.inv_origen,
					"inv_cantidad":message.data.inv_cantidad,"inv_fecha":message.data.inv_fecha,
					"inv_observacion":message.data.inv_observacion, "pla_id":message.data.pla_id};
        	if(message.data.inv_id == null){
        		alert("El registro no existe");
        	}
        	else{
        		$scope.mostrarDatosInventario=inventarioOut;
        	}
        });
	}
	$scope.inventarioList={};
	$scope.getList=function(){
		inventarioService.getList().then(function (message){
			$scope.inventarioList=message.data;
			if($scope.inventarioList ==={}){
				alert("No hay ningun registro");
			}
		});
	}
	$scope.pedidoList={};
	$scope.getPedidoList=function(pedido,inv_origen,pla_id){
		inventarioService.getPedidoList(pedido,inv_origen,pla_id).then(function (message){
			$scope.pedidoList=message.data;
			if($scope.pedidoList ==={}){
				alert("No hay ningun registro");
			}
		});
	}
	$scope.perdidaList={};
	$scope.getPerdidaList=function(){
		inventarioService.getPerdidaList().then(function (message){
			$scope.perdidaList=message.data;
			if($scope.perdidaList ==={}){
				alert("No hay ningun registro");
			}
		});
	}

	$scope.deleteInventario=function(inv_id){
		inventarioService.deleteInventario(inv_id).then(function(message){
			alert(message.data);
		});
	}

	$scope.inventarioStock={};
	$scope.getStock=function(){
		inventarioService.getStock().then(function(message){
			$scope.inventarioStock=message.data;
			$scope.showResult = true;
			if($scope.inventarioStock ==={}){
				alert("No hay registros")
			}
		});
	}

	$scope.inventarioIn={};
	$scope.save=function(inventarioIn){
		inventario={"inv_id":inventarioIn.inv_id,"inv_origen":inventarioIn.inv_origen,
				"inv_cantidad":inventarioIn.inv_cantidad, "inv_fecha":inventarioIn.inv_fecha,
				"inv_observacion":inventarioIn.inv_observacion, "pla_id":inventarioIn.pla_id};
		inventarioService.save(inventarioIn).then(function(message){
			alert(message.data);
		})
	}
	$scope.inventarioIn={};
	$scope.update= function(inventarioIn){
		inventario={"inv_id":inventarioIn.inv_id,"inv_origen":inventarioIn.inv_origen,
				"inv_cantidad":inventarioIn.inv_cantidad, "inv_fecha":inventarioIn.inv_fecha,
				"inv_observacion":inventarioIn.inv_observacion, "pla_id":inventarioIn.pla_id};
		inventarioService.update(inventarioIn).then(function(message){
			alert(message.data);
		});
	}
}]);
