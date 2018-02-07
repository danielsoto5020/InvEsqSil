package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PlantaDTO;
import negocio.planta.IPlantaNegocio;
import negocio.planta.impl.PlantaNegocio;

@Path("/planta")
public class PlantaServiceWS {
	
	private IPlantaNegocio  plantaNegocio;
	
	public PlantaServiceWS(){
		plantaNegocio = new PlantaNegocio();
	}
	
	@GET
	@Path("/consultar-planta/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PlantaDTO consultarPlantaPorId(@PathParam("id") Integer id) {
		return plantaNegocio.consultarPlantaPorId(id);
	}

	@POST
	@Path("/actualizar-planta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarPlanta(PlantaDTO plantaDTO) {
		return plantaNegocio.actualizarPlanta(plantaDTO);
	}

	@POST
	@Path("/crear-planta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearPlanta(PlantaDTO plantaDTO) {
		return plantaNegocio.crearPlanta(plantaDTO);
	}

	@GET
	@Path("/borrar-planta/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarPlanta(@PathParam("id") Integer id) {
		return plantaNegocio.borrarPlanta(id);
	}

	@GET
	@Path("/listar-planta")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PlantaDTO> ListarPlantas() {
		return plantaNegocio.ListarPlantas();
	}

}
