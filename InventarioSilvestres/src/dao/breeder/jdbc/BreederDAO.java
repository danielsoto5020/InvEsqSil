package dao.breeder.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.breeder.IBreederDAO;
import dto.BreederDTO;
import util.PersistUtil;

public class BreederDAO implements IBreederDAO{
	
	@Override
	public BreederDTO consultarBreederPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		BreederDTO breederDTO =  null;
		try {
			query = BreederSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				breederDTO = new BreederDTO();
				setInfoBreeder(resultado, breederDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return breederDTO;
	}

	private void setInfoBreeder(ResultSet resultado, BreederDTO breederDTO) throws Exception {
		
		
		breederDTO.setId(resultado.getInt("id_breeder"));
		breederDTO.setNombre(resultado.getString("nombre_breeder"));
		breederDTO.setTelefono1(resultado.getString("telefono1_breeder"));
		breederDTO.setCorreo(resultado.getString("correo_breeder"));
		breederDTO.setWeb(resultado.getString("web_breeder"));
		breederDTO.setContacto(resultado.getString("contacto_breeder"));
	}

	@Override
	public String actualizarBreeder(BreederDTO breederDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
        try {
            query = BreederSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, breederDTO.getNombre());
            instruccion.setString(index++, breederDTO.getTelefono1());
            instruccion.setString(index++, breederDTO.getCorreo());
            instruccion.setString(index++, breederDTO.getWeb());
            instruccion.setString(index++, breederDTO.getContacto());
            instruccion.setInt(index++, breederDTO.getId());
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
	public String crearBreeder(BreederDTO breederDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = BreederSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, breederDTO.getNombre());
            instruccion.setString(index++, breederDTO.getTelefono1());
            instruccion.setString(index++, breederDTO.getCorreo());
            instruccion.setString(index++, breederDTO.getWeb());
            instruccion.setString(index++, breederDTO.getContacto());
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
	public String borrarBreeder(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = BreederSQL.DELETE;
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
	public List<BreederDTO> ListarBreeders(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		BreederDTO breederDTO = null;
		List<BreederDTO> listaBreeders = new ArrayList<>();
		try {
			query = BreederSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				breederDTO = new BreederDTO();
				setInfoBreeder(resultado, breederDTO);
				listaBreeders.add(breederDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaBreeders;
	}

}
