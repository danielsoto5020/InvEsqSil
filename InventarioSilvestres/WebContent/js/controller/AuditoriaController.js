app.controller("auditoriaController", [
		"$scope",
		"auditoriaService",
		function auditoriaController($scope, auditoriaService) {
			$scope.mostrarDatosAuditoria = {};
			$scope.id = "";
			$scope.auditoriaOut = {};
			$scope.auditoriaSearch = function(id) {
				auditoriaService.auditoriaSearch(id).then(function(message) {
					$scope.auditoriaOut = {
						"id" : message.data.id,
						"tabla" : message.data.tabla,
						"columna" : message.data.columna,
						"valor" : message.data.valor,
						"usuario" : message.data.usuario,
						"accion" : message.data.accion,
						"fecha" : message.data.fecha
					};
					if (message.data.id == null) {
						alert("Auditoria no registrada");
					} else {
						$scope.mostrarDatosAuditoria = auditoriaOut;
					}
				});
			}
			$scope.auditoriaList = {};
			$scope.getListAuditoria = function() {
				auditoriaService.getListAuditoria().then(function(message) {
					$scope.auditoriaList = message.data;
					if ($scope.auditoriaList === {}) {
						alert("No hay ninguna auditoria registrada");
					}
				})
			}

			$scope.date = new Date();

			$scope.deleteAuditoria = function(id) {
				auditoriaService.deleteAuditoria(id).then(function(message) {
					alert(message.data);
				});
			}

			$scope.date = new Date();

			$scope.showForm = false;

			$scope.auditoriaIn = {};
			$scope.saveAuditoria = function(auditoriaIn) {
				auditoria = {
					"id" : auditoriaIn.id,
					"tabla" : auditoriaIn.tabla,
					"columna" : auditoriaIn.columna,
					"valor" : auditoriaIn.valor,
					"usuario" : auditoriaIn.usuario,
					"accion" : auditoriaIn.accion,
					"fecha" : auditoriaIn.fecha
				};

				$scope.showForm = false;
				
				auditoriaService.saveAuditoria(auditoriaIn).then(
						function(message) {
							alert(message.data);
						})
						$scope.auditoriaIn = {};
			}
			$scope.auditoriaIn = {};
			$scope.updateAuditoria = function(auditoriaIn) {
				auditoria = {
					"id" : auditoriaIn.id,
					"tabla" : auditoriaIn.tabla,
					"columna" : auditoriaIn.columna,
					"valor" : auditoriaIn.valor,
					"usuario" : auditoriaIn.usuario,
					"accion" : auditoriaIn.accion,
					"fecha" : auditoriaIn.fecha
				};
				auditoriaService.updateAuditoria(auditoriaIn).then(
						function(message) {
							alert(message.data);
						});
			}
		} ]);
