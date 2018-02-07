package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.BloqueDTO;
import negocio.bloque.IBloqueNegocio;
import negocio.bloque.impl.BloqueNegocio;



@Path("/bloque")

public class BloqueServiceWS {
	
	private IBloqueNegocio  bloqueNegocio;
	
	public BloqueServiceWS(){
		bloqueNegocio = new BloqueNegocio();
	}
	
	@GET
	@Path("/consultar-bloque/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public BloqueDTO consultarBloquePorId(@PathParam("id") Integer id) {
		return bloqueNegocio.consultarBloquePorId(id);
	}

	@POST
	@Path("/actualizar-bloque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarBloque(BloqueDTO bloqueDTO) {
		return bloqueNegocio.actualizarBloque(bloqueDTO);
	}

	@POST
	@Path("/crear-bloque")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearBloque(BloqueDTO bloqueDTO) {
		return bloqueNegocio.crearBloque(bloqueDTO);
	}

	@GET
	@Path("/borrar-bloque/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarBloque(@PathParam("id") Integer id) {
		return bloqueNegocio.borrarBloque(id);
	}

	@GET
	@Path("/listar-bloque")
	@Produces(MediaType.APPLICATION_JSON)
	public List<BloqueDTO> ListarBloques() {
		return bloqueNegocio.ListarBloques();
	}

}
