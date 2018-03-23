app.factory("plantaService", function($q, $http) {

	return {
		plantaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/planta/consultar-planta/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListPlanta : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/planta/listar-planta').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
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
		getListBreeder : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/breeder/listar-breeder').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deletePlanta :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/planta/borrar-planta/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		savePlanta: function(plantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/planta/crear-planta', plantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updatePlanta: function(plantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/planta/actualizar-planta', plantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});
