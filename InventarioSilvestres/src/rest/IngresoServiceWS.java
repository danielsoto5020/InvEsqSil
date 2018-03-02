package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.IngresoDTO;
import negocio.ingreso.IIngresoNegocio;
import negocio.ingreso.impl.IngresoNegocio;


@Path("/ingreso")
public class IngresoServiceWS {
	

	private IIngresoNegocio  ingresoNegocio;
	
	public IngresoServiceWS() {
		ingresoNegocio = new IngresoNegocio();
	}
	
	@GET
	@Path("/consultar-ingreso/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public IngresoDTO consultarIngresoPorId(@PathParam("id") Integer id) {
		return ingresoNegocio.consultarIngresoPorId(id);
	}

	@POST
	@Path("/actualizar-ingreso")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarIngreso(IngresoDTO ingresoDTO) {
		return ingresoNegocio.actualizarIngreso(ingresoDTO);
	}

	@POST
	@Path("/crear-ingreso")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearIngreso(IngresoDTO ingresoDTO) {
		return ingresoNegocio.crearIngreso(ingresoDTO);
	}

	@GET
	@Path("/borrar-ingreso/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarFinca(@PathParam("id") Integer id) {
		return ingresoNegocio.borrarIngreso(id);
	}

	@GET
	@Path("/listar-ingreso")
	@Produces(MediaType.APPLICATION_JSON)
	public List<IngresoDTO> ListarIngresos() {
		return ingresoNegocio.ListarIngresos();
	}


}
