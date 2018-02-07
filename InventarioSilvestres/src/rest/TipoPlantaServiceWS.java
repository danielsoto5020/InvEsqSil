package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.TipoPlantaDTO;
import negocio.tipoplanta.ITipoPlantaNegocio;
import negocio.tipoplanta.impl.TipoPlantaNegocio;


@Path("/tipoplanta")

public class TipoPlantaServiceWS {
	
	private ITipoPlantaNegocio  tipoPlantaNegocio;
	
	public TipoPlantaServiceWS(){
		tipoPlantaNegocio = new TipoPlantaNegocio();
	}
	
	@GET
	@Path("/consultar-tipoplanta/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TipoPlantaDTO consultarTipoPlantaPorId(@PathParam("id") Integer id) {
		return tipoPlantaNegocio.consultarTipoPlantaPorId(id);
	}

	@POST
	@Path("/actualizar-tipoplanta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarTipo(TipoPlantaDTO tipoPlantaDTO) {
		return tipoPlantaNegocio.actualizarTipoPlanta(tipoPlantaDTO);
	}

	@POST
	@Path("/crear-tipoplanta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearTipoPlanta(TipoPlantaDTO tipoPlantaDTO) {
		return tipoPlantaNegocio.crearTipoPlanta(tipoPlantaDTO);
	}

	@GET
	@Path("/borrar-tipoplanta/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarTipoPlanta(@PathParam("id") Integer id) {
		return tipoPlantaNegocio.borrarTipoPlanta(id);
	}

	@GET
	@Path("/listar-tipoplanta")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TipoPlantaDTO> ListarTipoPlantas() {
		return tipoPlantaNegocio.ListarTipoPlantas();
	}

}
