package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.BreederDTO;
import negocio.breeder.IBreederNegocio;
import negocio.breeder.impl.BreederNegocio;

@Path("/breeder")

public class BreederServiceWS {
	
	private IBreederNegocio  breederNegocio;
	
	public BreederServiceWS() {
		breederNegocio = new BreederNegocio();
	}
	
	@GET
	@Path("/consultar-breeder/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BreederDTO consultarBreederPorId(@PathParam("id") Integer id) {
		return breederNegocio.consultarBreederPorId(id);
	}

	@POST
	@Path("/actualizar-breeder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarBreeder(BreederDTO breederDTO) {
		return breederNegocio.actualizarBreeder(breederDTO);
	}

	@POST
	@Path("/crear-breeder")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearBreeder(BreederDTO breederDTO) {
		return breederNegocio.crearBreeder(breederDTO);
	}

	@GET
	@Path("/borrar-breeder/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarBreeder(@PathParam("id") Integer id) {
		return breederNegocio.borrarBreeder(id);
	}

	@GET
	@Path("/listar-breeder")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BreederDTO> ListarBreeders() {
		return breederNegocio.ListarBreeders();
	}

}
