app.factory("salidaService", function($q, $http) {

	return {
		salidaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/salida/consultar-salida/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListSalida : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/salida/listar-salida').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteSalida :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/salida/borrar-salida/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveSalida: function(salidaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/salida/crear-salida', salidaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateSalida: function(salidaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/salida/actualizar-salida', salidaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
