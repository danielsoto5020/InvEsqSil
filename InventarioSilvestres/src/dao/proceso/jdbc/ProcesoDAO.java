package dao.proceso.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.proceso.IProcesoDAO;
import dto.ProcesoDTO;
import util.PersistUtil;

public class ProcesoDAO implements IProcesoDAO{
	
	@Override
	public ProcesoDTO consultarProcesoPorId(Integer id, Connection con) throws Exception{
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProcesoDTO procesoDTO = null;
		try {
			query = ProcesoSQL.FIND_PROCESO_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				procesoDTO = new ProcesoDTO();
				setInfoProceso(resultado, procesoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return procesoDTO;
	}

	private void setInfoProceso(ResultSet resultado, ProcesoDTO procesoDTO) throws Exception {
		
		procesoDTO.setId(resultado.getInt("id_proceso"));
		procesoDTO.setNombre(resultado.getString("nombre_proceso"));
		procesoDTO.setPersona(resultado.getInt("fk_id_persona"));	
	}
	
	@Override
	public String actualizarProceso(ProcesoDTO procesoDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ProcesoSQL.UPDATE_PROCESO;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, procesoDTO.getId());
            instruccion.setString(index++, procesoDTO.getNombre());
            instruccion.setInt(index++, procesoDTO.getPersona());
            instruccion.setInt(index++, procesoDTO.getId());
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
	public String crearProceso(ProcesoDTO procesoDTO,Connection con) throws Exception{
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ProcesoSQL.INSERT_PROCESO;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, procesoDTO.getId());
            instruccion.setString(index++, procesoDTO.getNombre());
            instruccion.setInt(index++, procesoDTO.getPersona());
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
	public String borrarProceso(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ProcesoSQL.DELETE_PROCESO;
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
	public List<ProcesoDTO> ListarProcesos(Connection con) throws Exception{
		
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProcesoDTO procesoDTO = null;
		List<ProcesoDTO> listaProcesos = new ArrayList<>();
		try {
			query = ProcesoSQL.LIST_PROCESO;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				procesoDTO = new ProcesoDTO();
				setInfoProceso(resultado, procesoDTO);
				listaProcesos.add(procesoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaProcesos;
	}

}
