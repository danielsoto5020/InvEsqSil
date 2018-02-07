package negocio.persona.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.persona.IPersonaDAO;
import dao.persona.jdbc.PersonaDAO;
import dto.PersonaDTO;
import negocio.persona.IPersonaNegocio;
import util.PersistUtil;

public class PersonaNegocio implements IPersonaNegocio{
	
	private IPersonaDAO personaDAO;
    private DataSource dataSource;
	
	public PersonaNegocio(){
		dataSource = PersistUtil.getDataSource();
		personaDAO = new PersonaDAO();
	}
	
	@Override
	public PersonaDTO consultarPersonaPorId(Integer id) {
		Connection con = null;
		PersonaDTO personaDTO = null;
		try {
			con = dataSource.getConnection();
			personaDTO= personaDAO.consultarPersonaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return personaDTO;
	}

	@Override
	public String actualizarPersona(PersonaDTO personaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.actualizarPersona(personaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearPersona(PersonaDTO personaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.crearPersona(personaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarPersona(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = personaDAO.borrarPersona(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<PersonaDTO> ListarPersonas() {
		Connection con = null;
		List<PersonaDTO> listaPersonas = null;
		try {
			con = dataSource.getConnection();
			listaPersonas= personaDAO.ListarPersonas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaPersonas;
	}

	
}
