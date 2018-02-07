package dao.finca.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.finca.IFincaDAO;
import dto.FincaDTO;
import util.PersistUtil;

public class FincaDAO implements IFincaDAO{
	
	@Override
	public FincaDTO consultarFincaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		FincaDTO fincaDTO= null;
		try {
			query = FincaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				fincaDTO = new FincaDTO();
				setInfoFinca(resultado, fincaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return fincaDTO;
	}

	private void setInfoFinca(ResultSet resultado, FincaDTO fincaDTO) throws Exception {
		
		
		fincaDTO.setId(resultado.getInt("id_finca"));
		fincaDTO.setNombre(resultado.getString("nombre_finca"));
		fincaDTO.setUbicacion(resultado.getString("ubicacion_finca"));
		fincaDTO.setTelefono1(resultado.getString("telefono1_finca"));
	}

	@Override
	public String actualizarFinca(FincaDTO fincaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
        try {
            query = FincaSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, fincaDTO.getNombre());
            instruccion.setString(index++, fincaDTO.getUbicacion());
            instruccion.setString(index++, fincaDTO.getTelefono1());
            instruccion.setInt(index++, fincaDTO.getId());
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
	public String crearFinca(FincaDTO fincaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = FincaSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, fincaDTO.getNombre());
            instruccion.setString(index++, fincaDTO.getUbicacion());
            instruccion.setString(index++, fincaDTO.getTelefono1());
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
	public String borrarFinca(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = FincaSQL.DELETE;
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
	public List<FincaDTO> ListarFincas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		FincaDTO fincaDTO = null;
		List<FincaDTO> listaFincas = new ArrayList<>();
		try {
			query = FincaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				fincaDTO = new FincaDTO();
				setInfoFinca(resultado, fincaDTO);
				listaFincas.add(fincaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaFincas;
	}

}
