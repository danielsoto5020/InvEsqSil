app.factory("bloqueService", function($q, $http) {

	return {
		bloqueSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/bloque/consultar-bloque/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListBloque : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/bloque/listar-bloque').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteBloque :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/bloque/borrar-bloque/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveBloque: function(bloqueIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/bloque/crear-bloque', bloqueIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateBloque: function(bloqueIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/bloque/actualizar-bloque', bloqueIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});