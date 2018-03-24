app.factory("codigorfService", function($q, $http) {

	return {
		codigorfSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/codigorf/consultar-codigorf/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListCodigorf : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/codigorf/listar-codigorf').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		getListVariedad : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/planta/listar-planta').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteCodigorf :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/codigorf/borrar-codigorf/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveCodigorf: function(codigorfIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/codigorf/crear-codigorf', codigorfIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateCodigorf: function(codigorfIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/codigorf/actualizar-codigorf', codigorfIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});