app.factory("origenService", function($q, $http) {

	return {
		origenSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/origen/consultar-origen/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListOrigen : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/origen/listar-origen').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteOrigen: function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/origen/borrar-origen/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveOrigen: function(origenIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/origen/crear-origen', origenIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateOrigen: function(origenIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/origen/actualizar-origen', origenIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});