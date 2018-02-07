package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.TemperaturaDTO;
import negocio.temperatura.ITemperaturaNegocio;
import negocio.temperatura.impl.TemperaturaNegocio;


@Path("/temperatura")

public class TemperaturaServiceWS {
	
	private ITemperaturaNegocio  temperaturaNegocio;
	
	public TemperaturaServiceWS(){
		temperaturaNegocio = new TemperaturaNegocio();
	}
	
	@GET
	@Path("/consultar-temperatura/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public TemperaturaDTO consultarTemperaturaPorId(@PathParam("id") Integer id) {
		return temperaturaNegocio.consultarTemperaturaPorId(id);
	}

	@POST
	@Path("/actualizar-temperatura")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarTemperatura(TemperaturaDTO temperaturaDTO) {
		return temperaturaNegocio.actualizarTemperatura(temperaturaDTO);
	}

	@POST
	@Path("/crear-temperatura")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearTemperatura(TemperaturaDTO temperaturaDTO) {
		return temperaturaNegocio.crearTemperatura(temperaturaDTO);
	}

	@GET
	@Path("/borrar-temperatura/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarTemperatura(@PathParam("id") Integer id) {
		return temperaturaNegocio.borrarTemperatura(id);
	}

	@GET
	@Path("/listar-temperatura")
	@Produces(MediaType.APPLICATION_JSON)
	public List<TemperaturaDTO> ListarTemperaturas() {
		return temperaturaNegocio.ListarTemperaturas();
	}


}
