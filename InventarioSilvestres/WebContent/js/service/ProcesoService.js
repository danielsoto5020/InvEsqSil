app.factory("procesoService", function($q, $http) {

	return {
		procesoSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/proceso/consultar-proceso/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListProceso : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/proceso/listar-proceso').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteProceso :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/proceso/borrar-proceso/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveProceso: function(procesoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/proceso/crear-proceso', procesoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateProceso: function(procesoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/proceso/actualizar-proceso', procesoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
