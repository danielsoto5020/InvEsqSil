app.factory("fincaService", function($q, $http) {

	return {
		fincaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/finca/consultar-finca/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListFinca : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/finca/listar-finca').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteFinca :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/finca/borrar-finca/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveFinca: function(fincaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/finca/crear-finca', fincaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateFinca: function(fincaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/finca/actualizar-finca', fincaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});

