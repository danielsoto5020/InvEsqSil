app.factory("camaService", function($q, $http) {

	return {
		camaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cama/consultar-cama/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListCama : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cama/listar-cama').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
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
		
		getSelectCama : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cama/select-cama').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteCama :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cama/borrar-cama/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveCama: function(camaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/cama/crear-cama', camaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateCama: function(camaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/cama/actualizar-cama', camaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
