app.factory("auditoriaService", function($q, $http) {

	return {
		auditoriaSearch : function(id) {
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/auditoria/consultar-auditoria/'+id)
			            .then(function(data) {				          
			var data1 = angular.fromJson(data);			
						return data1;
			}).catch(function (data) {
				       console.log(data);
			});
		},
		getListAuditoria : function(){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/auditoria/listar-auditoria').then(function(data){
				var receiveddata = angular.fromJson(data);			
				return receiveddata;
			}).catch(function(data){
				console.log(data);
			});
		},

		deleteAuditoria :function(id){
			return $http.get('http://CSistemas04:8080/InventarioSilvestres/rest/auditoria/borrar-auditoria/'+id)
			.then(function(data){
				var received = angular.fromJson(data);			
				return received;
			}).catch(function(data){
				console.log(data);
			});
		},
		saveAuditoria: function(auditoriaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/auditoria/crear-auditoria', auditoriaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			})
		},
		updateAuditoria: function(auditoriaIn){
			return $http.post('http://CSistemas04:8080/InventarioSilvestres/rest/auditoria/actualizar-auditoria', auditoriaIn).then(function(data){
				var msg=angular.fromJson(data);
				return msg;
			}).catch(function(data){
				console.log(data);
			});
		}
	}
});

