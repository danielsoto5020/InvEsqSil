app.factory("cosechaService", function($q, $http) {

	return {
		cosechaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cosecha/consultar-cosecha/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListCosecha : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cosecha/listar-cosecha').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteCosecha :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/cosecha/borrar-cosecha/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveCosecha: function(cosechaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/cosecha/crear-cosecha', cosechaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateCosecha: function(cosechaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/cosecha/actualizar-cosecha', cosechaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});