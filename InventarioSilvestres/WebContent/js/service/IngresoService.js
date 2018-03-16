app.factory("ingresoService", function($q, $http) {

	return {
		ingresoSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/consultar-ingreso/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListIngreso : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/listar-ingreso').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		getPedidoList : function(pedido,inv_origen,pla_id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/pedido-ingreso/'+planta+'&'+origen+'&'+cantidad).then(function(data){
				var receiveddata = angular.fromJson(data);
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		deleteIngreso :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/borrar-ingreso/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveIngreso: function(ingresoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/crear-ingreso', ingresoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateIngreso: function(ingresoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/ingreso/actualizar-ingreso', ingresoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
