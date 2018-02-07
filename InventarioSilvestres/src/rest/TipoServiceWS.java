package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.TipoDTO;
import negocio.tipo.ITipoNegocio;
import negocio.tipo.impl.TipoNegocio;


@Path("/tipo")

public class TipoServiceWS {
	
	private ITipoNegocio  tipoNegocio;
	
	public TipoServiceWS(){
		tipoNegocio = new TipoNegocio();
	}
	
	@GET
	@Path("/consultar-tipo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoDTO consultarTipoPorId(@PathParam("id") Integer id) {
		return tipoNegocio.consultarTipoPorId(id);
	}

	@POST
	@Path("/actualizar-tipo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarTipo(TipoDTO tipoDTO) {
		return tipoNegocio.actualizarTipo(tipoDTO);
	}

	@POST
	@Path("/crear-tipo")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearTipo(TipoDTO tipoDTO) {
		return tipoNegocio.crearTipo(tipoDTO);
	}

	@GET
	@Path("/borrar-tipo/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarTipo(@PathParam("id") Integer id) {
		return tipoNegocio.borrarTipo(id);
	}

	@GET
	@Path("/listar-tipo")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoDTO> ListarTipos() {
		return tipoNegocio.ListarTipos();
	}
}
