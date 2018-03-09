package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.SalidaDTO;
import negocio.salida.ISalidaNegocio;
import negocio.salida.impl.SalidaNegocio;



@Path("/salida")

public class SalidaServiceWS {
	
	private ISalidaNegocio  salidaNegocio;
	
	public SalidaServiceWS(){
		salidaNegocio = new SalidaNegocio();
	}
	
	@GET
	@Path("/consultar-salida/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public SalidaDTO consultarSalidaPorId(@PathParam("id") Integer id) {
		return salidaNegocio.consultarSalidaPorId(id);
	}

	@POST
	@Path("/actualizar-salida")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarSalida(SalidaDTO salidaDTO) {
		return salidaNegocio.actualizarSalida(salidaDTO);
	}

	@POST
	@Path("/crear-salida")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearSalida(SalidaDTO salidaDTO) {
		return salidaNegocio.crearSalida(salidaDTO);
	}

	@GET
	@Path("/borrar-salida/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarSalida(@PathParam("id") Integer id) {
		return salidaNegocio.borrarSalida(id);
	}

	@GET
	@Path("/listar-salida")
	@Produces(MediaType.APPLICATION_JSON)
	public List<SalidaDTO> ListarSalidas() {
		return salidaNegocio.ListarSalidas();
	}
}
