app.factory("cicloService", function($q, $http) {

	return {
		cicloSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ciclo/consultar-ciclo/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListCiclo : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ciclo/listar-ciclo').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteCiclo :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/ciclo/borrar-ciclo/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveCiclo: function(cicloIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/ciclo/crear-ciclo', cicloIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateCiclo: function(cicloIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/ciclo/actualizar-ciclo', cicloIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
