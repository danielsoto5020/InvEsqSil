app.factory("productoService", function($q, $http) {

	return {
		productoSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/producto/consultar-producto/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListProducto : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/producto/listar-producto').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteProducto :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/producto/borrar-producto/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveProducto: function(productoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/producto/crear-producto', productoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateProducto: function(productoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/producto/actualizar-producto', productoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});