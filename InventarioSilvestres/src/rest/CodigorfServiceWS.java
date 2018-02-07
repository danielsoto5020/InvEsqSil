package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.CodigorfDTO;
import negocio.codigorf.ICodigorfNegocio;
import negocio.codigorf.impl.CodigorfNegocio;

@Path("/codigorf")

public class CodigorfServiceWS {
	
	private ICodigorfNegocio codigorfNegocio;
	
	public CodigorfServiceWS(){
		codigorfNegocio = new CodigorfNegocio();
	}
	

	@GET
	@Path("/consultar-codigorf/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CodigorfDTO consultarCodigorfPorId(@PathParam("id") Integer id) {
		return codigorfNegocio.consultarCodigorfPorId(id);
	}

	@POST
	@Path("/actualizar-codigorf")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarCodigorf(CodigorfDTO codigorfDTO) {
		return codigorfNegocio.actualizarCodigorf(codigorfDTO);
	}

	@POST
	@Path("/crear-codigorf")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearCodigorf(CodigorfDTO codigorfDTO) {
		return codigorfNegocio.crearCodigorf(codigorfDTO);
	}

	@GET
	@Path("/borrar-codigorf/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarCodigorf(@PathParam("id") Integer id) {
		return codigorfNegocio.borrarCodigorf(id);
	}

	@GET
	@Path("/listar-codigorf")
	@Produces(MediaType.APPLICATION_JSON)
	public List<CodigorfDTO> ListarCodigorfs() {
		return codigorfNegocio.ListarCodigorfs();
	}
}

