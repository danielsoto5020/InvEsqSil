app.factory("empleadoService", function($q, $http) {

	return {
		empleadoSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/empleado/consultar-empleado/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListEmpleado : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/empleado/listar-empleado').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteEmpleado :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/empleado/borrar-empleado/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveEmpleado: function(empleadoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/empleado/crear-empleado', empleadoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateEmpleado: function(empleadoIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/empleado/actualizar-empleado', empleadoIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});

