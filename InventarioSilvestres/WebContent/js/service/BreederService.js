app.factory("breederService", function($q, $http) {

	return {
		breederSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/consultar-breeder/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListBreeder : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/listar-breeder').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteBreeder :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/borrar-breeder/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveBreeder: function(breederIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/crear-breeder', breederIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateBreeder: function(breederIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/actualizar-breeder', breederIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
