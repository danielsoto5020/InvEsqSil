app.factory("tipoPlantaService", function($q, $http) {

	return {
		tipoPlantaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipoplanta/consultar-tipoplanta/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListTipoPlanta : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipoplanta/listar-tipoplanta').then(function(data){
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
		
		deleteTipoPlanta :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/tipoplanta/borrar-tipoplanta/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveTipoPlanta: function(tipoPlantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/tipoplanta/crear-tipoplanta', tipoPlantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateTipoPlanta: function(tipoPlantaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/tipoplanta/actualizar-tipoplanta', tipoPlantaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});