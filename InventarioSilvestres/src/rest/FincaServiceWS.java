package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.FincaDTO;
import negocio.finca.IFincaNegocio;
import negocio.finca.impl.FincaNegocio;



@Path("/finca")

public class FincaServiceWS {
	
	private IFincaNegocio  fincaNegocio;
	
	public FincaServiceWS() {
		fincaNegocio = new FincaNegocio();
	}
	
	@GET
	@Path("/consultar-finca/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public FincaDTO consultarFincaPorId(@PathParam("id") Integer id) {
		return fincaNegocio.consultarFincaPorId(id);
	}

	@POST
	@Path("/actualizar-finca")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarFinca(FincaDTO fincaDTO) {
		return fincaNegocio.actualizarFinca(fincaDTO);
	}

	@POST
	@Path("/crear-finca")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearFinca(FincaDTO fincaDTO) {
		return fincaNegocio.crearFinca(fincaDTO);
	}

	@GET
	@Path("/borrar-finca/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarFinca(@PathParam("id") Integer id) {
		return fincaNegocio.borrarFinca(id);
	}

	@GET
	@Path("/listar-finca")
	@Produces(MediaType.APPLICATION_JSON)
	public List<FincaDTO> ListarFincas() {
		return fincaNegocio.ListarFincas();
	}

}
