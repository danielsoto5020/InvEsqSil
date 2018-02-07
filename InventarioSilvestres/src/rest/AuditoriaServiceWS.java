package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.AuditoriaDTO;
import negocio.auditoria.IAuditoriaNegocio;
import negocio.auditoria.impl.AuditoriaNegocio;


@Path("/auditoria")

public class AuditoriaServiceWS {
	
private IAuditoriaNegocio  auditoriaNegocio;
	
	public AuditoriaServiceWS(){
		auditoriaNegocio = new AuditoriaNegocio();
	}
	

	@GET
	@Path("/consultar-auditoria/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public AuditoriaDTO consultarAuditoriaPorId(@PathParam("id") Integer id) {
		return auditoriaNegocio.consultarAuditoriaPorId(id);
	}

	@POST
	@Path("/actualizar-auditoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarAuditoria(AuditoriaDTO auditoriaDTO) {
		return auditoriaNegocio.actualizarAuditoria(auditoriaDTO);
	}

	@POST
	@Path("/crear-auditoria")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearAuditoria(AuditoriaDTO auditoriaDTO) {
		return auditoriaNegocio.crearAuditoria(auditoriaDTO);
	}

	@GET
	@Path("/borrar-auditoria/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarAuditoria(@PathParam("id") Integer id) {
		return auditoriaNegocio.borrarAuditoria(id);
	}

	@GET
	@Path("/listar-auditoria")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AuditoriaDTO> ListarAuditorias() {
		return auditoriaNegocio.ListarAuditorias();
	}

}
