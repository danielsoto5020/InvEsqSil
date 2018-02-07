package negocio.persona;

import java.util.List;

import dto.PersonaDTO;

public interface IPersonaNegocio {
	
	public PersonaDTO consultarPersonaPorId(Integer id);

	public String actualizarPersona(PersonaDTO personaDTO);

	public String crearPersona(PersonaDTO personaDTO);

	public String borrarPersona(Integer id);
	
	public List<PersonaDTO> ListarPersonas();

}
