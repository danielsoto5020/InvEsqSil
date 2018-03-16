package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.OrigenDTO;
import negocio.origen.IOrigenNegocio;
import negocio.origen.impl.OrigenNegocio;


@Path("/origen")
public class OrigenServiceWS {

	private IOrigenNegocio  origenNegocio;
	
	public OrigenServiceWS() {
		origenNegocio = new OrigenNegocio();
	}
	
	@GET
	@Path("/consultar-origen/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public OrigenDTO consultarOrigenPorId(@PathParam("id") Integer id) {
		return origenNegocio.consultarOrigenPorId(id);
	}

	@POST
	@Path("/actualizar-origen")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarIngreso(OrigenDTO origenDTO) {
		return origenNegocio.actualizarOrigen(origenDTO);
	}

	@POST
	@Path("/crear-origen")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearIngreso(OrigenDTO origenDTO) {
		return origenNegocio.crearOrigen(origenDTO);
	}

	@GET
	@Path("/borrar-origen/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarOrigen(@PathParam("id") Integer id) {
		return origenNegocio.borrarOrigen(id);
	}

	@GET
	@Path("/listar-origen")
	@Produces(MediaType.APPLICATION_JSON)
	public List<OrigenDTO> ListarOrigens() {
		return origenNegocio.ListarOrigens();
	}
}
