app.factory("personaService", function($q, $http) {

	return {
		personaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/persona/consultar-persona/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListPersona : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/persona/listar-persona').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deletePersona :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/persona/borrar-persona/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		savePersona: function(personaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/persona/crear-persona', personaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updatePersona: function(personaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/persona/actualizar-persona', personaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});