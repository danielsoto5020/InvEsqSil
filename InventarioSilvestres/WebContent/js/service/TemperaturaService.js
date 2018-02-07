app.factory("temperaturaService", function($q, $http) {

	return {
		temperaturaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/temperatura/consultar-temperatura/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListTemperatura : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/temperatura/listar-temperatura').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteTemperatura :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/temperatura/borrar-temperatura/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveTemperatura: function(temperaturaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/temperatura/crear-temperatura', temperaturaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateTemperatura: function(temperaturaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/temperatura/actualizar-temperatura', temperaturaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
