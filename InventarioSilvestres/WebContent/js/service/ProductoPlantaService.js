app.factory("productoPlantaService", function($q, $http) {

	return {
		productoPlantaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/productoplanta/consultar-productoplanta/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListProductoPlanta : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/productoplanta/listar-productoplanta').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteProductoPlanta :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/productoplanta/borrar-productoplanta/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveProductoPlanta: function(productoPlantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/productoplanta/crear-productoplanta', productoPlantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateProductoPlanta: function(productoPlantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/productoplanta/actualizar-productoplanta', productoPlantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});