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
						"operacion" : message.data.operacion,
						"oldvalor" : message.data.oldvalor,
						"newvalor" : message.data.newvalor,
						"fecha" : message.data.fecha,
						"usuario" : message.data.usuario
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
					"operacion" : auditoriaIn.operacion,
					"oldvalor" : auditoriaIn.oldvalor,
					"newvalor" : auditoriaIn.newvalor,
					"fecha" : auditoriaIn.fecha,
					"usuario" : auditoriaIn.usuario
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
					"operacion" : auditoriaIn.operacion,
					"oldvalor" : auditoriaIn.oldvalor,
					"newvalor" : auditoriaIn.newvalor,
					"fecha" : auditoriaIn.fecha,
					"usuario" : auditoriaIn.usuario
				};
				auditoriaService.updateAuditoria(auditoriaIn).then(
						function(message) {
							alert(message.data);
						});
			}
		} ]);
