app.factory("inventarioService", function($q, $http) {

	return {
		inventarioSearch : function(inv_id) {
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/consultar/'+inv_id)
			            .then(function(data) {
			var data1 = angular.fromJson(data);
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getList : function(){
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/listar').then(function(data){
				var receiveddata = angular.fromJson(data);
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		getPerdidaList : function(){
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/perdida').then(function(data){
				var receiveddata = angular.fromJson(data);
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		getPedidoList : function(pedido,inv_origen,pla_id){
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/pedido/'+pedido+'&'+inv_origen+'&'+pla_id).then(function(data){
				var receiveddata = angular.fromJson(data);
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},
		getStock : function(){
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/stock').then(function(data){
				var data2 = angular.fromJson(data);
				return data2;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteInventario :function(inv_id){
			return $http.get('http://localhost:8080/InventarioSilvestres/rest/inventario/borrar/'+inv_id)
			.then(function(data){
				var received = angular.fromJson(data);
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		save: function(inventarioIn){
			return $http.post('http://localhost:8080/InventarioSilvestres/rest/inventario/crear', inventarioIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		update: function(inventarioIn){
			return $http.post('http://localhost:8080/InventarioSilvestres/rest/inventario/actualizar', inventarioIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
