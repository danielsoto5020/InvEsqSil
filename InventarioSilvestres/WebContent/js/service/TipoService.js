app.factory("tipoService", function($q, $http) {

	return {
		tipoSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipo/consultar-tipo/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListTipo : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipo/listar-tipo').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteTipo :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipo/borrar-tipo/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveTipo: function(tipoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/tipo/crear-tipo', tipoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateTipo: function(tipoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/tipo/actualizar-tipo', tipoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});