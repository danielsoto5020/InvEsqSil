package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ColorDTO;
import negocio.color.IColorNegocio;
import negocio.color.impl.ColorNegocio;


@Path("/color")

public class ColorServiceWS {
	
	private IColorNegocio colorNegocio;
	
	public ColorServiceWS(){
		colorNegocio = new ColorNegocio();
	}
	

	@GET
	@Path("/consultar-color/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ColorDTO consultarColorPorId(@PathParam("id") Integer id) {
		return colorNegocio.consultarColorPorId(id);
	}

	@POST
	@Path("/actualizar-color")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarColor(ColorDTO colorDTO) {
		return colorNegocio.actualizarColor(colorDTO);
	}

	@POST
	@Path("/crear-color")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearColor(ColorDTO colorDTO) {
		return colorNegocio.crearColor(colorDTO);
	}

	@GET
	@Path("/borrar-color/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarColor(@PathParam("id") Integer id) {
		return colorNegocio.borrarColor(id);
	}

	@GET
	@Path("/listar-color")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ColorDTO> ListarColors() {
		return colorNegocio.ListarColors();
	}
	

}
