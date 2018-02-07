package dao.persona.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.persona.IPersonaDAO;
import dto.PersonaDTO;
import util.PersistUtil;

public class PersonaDAO implements IPersonaDAO{
	
	@Override
	public PersonaDTO consultarPersonaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		PersonaDTO personaDTO= null;
		try {
			query = PersonaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				personaDTO = new PersonaDTO();
				setInfoPersona(resultado, personaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return personaDTO;
	}

	private void setInfoPersona(ResultSet resultado, PersonaDTO personaDTO) throws Exception {
		
		
		personaDTO.setId(resultado.getInt("id_persona"));
		personaDTO.setDocumento(resultado.getString("documento_persona"));
		personaDTO.setNombre(resultado.getString("nombre_persona"));
		personaDTO.setTelefono(resultado.getString("telefono_persona"));
		personaDTO.setCorreo(resultado.getString("correo_persona"));
		personaDTO.setCargo(resultado.getString("cargo_persona"));
		personaDTO.setCodigo(resultado.getString("codigo_persona"));
		personaDTO.setUsuario(resultado.getString("usuario_persona"));
		personaDTO.setContrasenia(resultado.getString("contrasenia_persona"));
	}

	@Override
	public String actualizarPersona(PersonaDTO personaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
        try {
            query = PersonaSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, personaDTO.getDocumento());
            instruccion.setString(index++, personaDTO.getNombre());
            instruccion.setString(index++, personaDTO.getTelefono());
            instruccion.setString(index++, personaDTO.getCorreo());
            instruccion.setString(index++, personaDTO.getCargo());
            instruccion.setString(index++, personaDTO.getCodigo());
            instruccion.setString(index++, personaDTO.getUsuario());
            instruccion.setString(index++, personaDTO.getContrasenia());
            instruccion.setInt(index++, personaDTO.getId());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String crearPersona(PersonaDTO personaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PersonaSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, personaDTO.getDocumento());
            instruccion.setString(index++, personaDTO.getNombre());
            instruccion.setString(index++, personaDTO.getTelefono());
            instruccion.setString(index++, personaDTO.getCorreo());
            instruccion.setString(index++, personaDTO.getCargo());
            instruccion.setString(index++, personaDTO.getCodigo());
            instruccion.setString(index++, personaDTO.getUsuario());
            instruccion.setString(index++, personaDTO.getContrasenia());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String borrarPersona(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PersonaSQL.DELETE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, id);
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public List<PersonaDTO> ListarPersonas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		PersonaDTO personaDTO = null;
		List<PersonaDTO> listaPersonas = new ArrayList<>();
		try {
			query = PersonaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				personaDTO = new PersonaDTO();
				setInfoPersona(resultado, personaDTO);
				listaPersonas.add(personaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaPersonas;
	}

}
