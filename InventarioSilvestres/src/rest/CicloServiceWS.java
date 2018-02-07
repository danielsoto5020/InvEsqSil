package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.CicloDTO;
import negocio.ciclo.ICicloNegocio;
import negocio.ciclo.impl.CicloNegocio;

@Path("/ciclo")

public class CicloServiceWS {

	private ICicloNegocio  cicloNegocio;
	
	public CicloServiceWS(){
		cicloNegocio = new CicloNegocio();
	}

	@GET
	@Path("/consultar-ciclo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CicloDTO consultarCicloPorId(@PathParam("id") Integer id) {
		return cicloNegocio.consultarCicloPorId(id);
	}

	@POST
	@Path("/actualizar-ciclo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarCiclo(CicloDTO cicloDTO) {
		return cicloNegocio.actualizarCiclo(cicloDTO);
	}

	@POST
	@Path("/crear-ciclo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearCiclo(CicloDTO cicloDTO) {
		return cicloNegocio.crearCiclo(cicloDTO);
	}

	@GET
	@Path("/borrar-ciclo/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarCiclo(@PathParam("id") Integer id) {
		return cicloNegocio.borrarCiclo(id);
	}

	@GET
	@Path("/listar-ciclo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CicloDTO> ListarCiclos() {
		return cicloNegocio.ListarCiclos();
	}
}
