package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import dto.ProcesoDTO;
import negocio.proceso.IProcesoNegocio;
import negocio.proceso.impl.ProcesoNegocio;


@Path("/proceso")

public class ProcesoServiceWS {
	
	private IProcesoNegocio  procesoNegocio;
	
	public ProcesoServiceWS(){
		procesoNegocio = new ProcesoNegocio();
	}

	@GET
	@Path("/consultar-proceso/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProcesoDTO consultarProcesoPorId(@PathParam("id") Integer id) {
		return procesoNegocio.consultarProcesoPorId(id);
	}

	@POST
	@Path("/actualizar-proceso")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarProceso(ProcesoDTO procesoDTO) {
		return procesoNegocio.actualizarProceso(procesoDTO);
	}

	@POST
	@Path("/crear-proceso")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearProceso(ProcesoDTO procesoDTO) {
		return procesoNegocio.crearProceso(procesoDTO);
	}

	@GET
	@Path("/borrar-proceso/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarProceso(@PathParam("id") Integer id) {
		return procesoNegocio.borrarProceso(id);
	}

	@GET
	@Path("/listar-proceso")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProcesoDTO> ListarProcesos() {
		return procesoNegocio.ListarProcesos();
	}
}
