app.factory("siembraService", function($q, $http) {

	return {
		siembraSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/siembra/consultar-siembra/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListSiembra : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/siembra/listar-siembra').then(function(data){
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

		deleteSiembra :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/siembra/borrar-siembra/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveSiembra: function(siembraIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/siembra/crear-siembra', siembraIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateSiembra: function(siembraIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/siembra/actualizar-siembra', siembraIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
