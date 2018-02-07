package dao.persona;

import java.sql.Connection;
import java.util.List;


import dto.PersonaDTO;

public interface IPersonaDAO {
	
	public PersonaDTO consultarPersonaPorId(Integer id, Connection con) throws Exception;

	public String actualizarPersona(PersonaDTO personaDTO, Connection con) throws Exception;

	public String crearPersona(PersonaDTO personaDTO,Connection con) throws Exception;

	public String borrarPersona(Integer id, Connection con) throws Exception;
	
	public List<PersonaDTO> ListarPersonas(Connection con) throws Exception;
}
