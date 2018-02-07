app.factory("colorService", function($q, $http) {

	return {
		colorSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/color/consultar-color/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListColor : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/color/listar-color').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteColor :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/color/borrar-color/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveColor: function(colorIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/color/crear-color', colorIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateColor: function(colorIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/color/actualizar-color', colorIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});