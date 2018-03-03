package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.CamaDTO;
import negocio.cama.ICamaNegocio;
import negocio.cama.impl.CamaNegocio;


@Path("/cama")

public class CamaServiceWS {
	
	private ICamaNegocio  camaNegocio;
	
	public CamaServiceWS(){
		camaNegocio = new CamaNegocio();
	}
	
	@GET
	@Path("/consultar-cama/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CamaDTO consultarCamaPorId(@PathParam("id") Integer id) {
		return camaNegocio.consultarCamaPorId(id);
	}

	@POST
	@Path("/actualizar-cama")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarCama(CamaDTO camaDTO) {
		return camaNegocio.actualizarCama(camaDTO);
	}

	@POST
	@Path("/crear-cama")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearCama(CamaDTO camaDTO) {
		return camaNegocio.crearCama(camaDTO);
	}

	@GET
	@Path("/borrar-cama/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarCama(@PathParam("id") Integer id) {
		return camaNegocio.borrarCama(id);
	}

	@GET
	@Path("/listar-cama")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CamaDTO> ListarCamas() {
		return camaNegocio.ListarCamas();
	}
	
	@GET
	@Path("/select-cama")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CamaDTO> SelectCamas() {
		return camaNegocio.ListarCamas();
	}

}
