package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.PersonaDTO;
import negocio.persona.IPersonaNegocio;
import negocio.persona.impl.PersonaNegocio;


@Path("/persona")

public class PersonaServiceWS {
	
	private IPersonaNegocio  personaNegocio;
	
	public PersonaServiceWS() {
		personaNegocio = new PersonaNegocio();
	}
	
	@GET
	@Path("/consultar-persona/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarPersonaPorId(@PathParam("id") Integer id) {
		return personaNegocio.consultarPersonaPorId(id);
	}

	@POST
	@Path("/actualizar-persona")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarPersona(PersonaDTO personaDTO) {
		return personaNegocio.actualizarPersona(personaDTO);
	}

	@POST
	@Path("/crear-persona")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearPersona(PersonaDTO personaDTO) {
		return personaNegocio.crearPersona(personaDTO);
	}

	@GET
	@Path("/borrar-persona/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarPersona(@PathParam("id") Integer id) {
		return personaNegocio.borrarPersona(id);
	}

	@GET
	@Path("/listar-persona")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> ListarPersonas() {
		return personaNegocio.ListarPersonas();
	}


}
