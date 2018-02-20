package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.SiembraDTO;
import negocio.siembra.ISiembraNegocio;
import negocio.siembra.impl.SiembraNegocio;


@Path("/siembra")

public class SiembraServiceWS {
		
	private ISiembraNegocio  siembraNegocio;
	
	public SiembraServiceWS(){
		siembraNegocio = new SiembraNegocio();
	}
	
	@GET
	@Path("/consultar-siembra/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SiembraDTO consultarSiembraPorId(@PathParam("id") Integer id) {
		return siembraNegocio.consultarSiembraPorId(id);
	}

	@POST
	@Path("/actualizar-siembra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarSiembra(SiembraDTO siembraDTO) {
		return siembraNegocio.actualizarSiembra(siembraDTO);
	}

	@POST
	@Path("/crear-siembra")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearSiembra(SiembraDTO siembraDTO) {
		return siembraNegocio.crearSiembra(siembraDTO);
	}

	@GET
	@Path("/borrar-siembra/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarSiembra(@PathParam("id") Integer id) {
		return siembraNegocio.borrarSiembra(id);
	}

	@GET
	@Path("/listar-siembra")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SiembraDTO> ListarSiembras() {
		return siembraNegocio.ListarSiembras();
	}
}
