package dao.ciclo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ciclo.ICicloDAO;
import dto.CicloDTO;
import util.PersistUtil;

public class CicloDAO implements ICicloDAO{

	@Override
	public CicloDTO consultarCicloPorId(Integer id, Connection con) throws Exception{
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CicloDTO cicloDTO = null;
		try {
			query = CicloSQL.FIND_CICLO_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				cicloDTO = new CicloDTO();
				setInfoCiclo(resultado, cicloDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return cicloDTO;
	}

	private void setInfoCiclo(ResultSet resultado, CicloDTO cicloDTO) throws Exception {
		
		cicloDTO.setId(resultado.getInt("id_ciclo"));
		cicloDTO.setCantidad(resultado.getString("cantidad_ciclo"));
		cicloDTO.setFecha(resultado.getString("fecha_ciclo"));
		cicloDTO.setCama(resultado.getInt("fk_id_cama"));
		cicloDTO.setPersona(resultado.getInt("fk_id_persona"));	
		cicloDTO.setPlanta(resultado.getInt("fk_id_planta"));
		cicloDTO.setProceso(resultado.getInt("fk_id_proceso"));
		cicloDTO.setCiclo(resultado.getInt("fk_id_ciclo"));
	}
	
	@Override
	public String actualizarCiclo(CicloDTO cicloDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CicloSQL.UPDATE_CICLO;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, cicloDTO.getId());
            instruccion.setString(index++, cicloDTO.getCantidad());
            instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(cicloDTO.getFecha()));
            instruccion.setInt(index++, cicloDTO.getCama());
            instruccion.setInt(index++, cicloDTO.getPersona());
            instruccion.setInt(index++, cicloDTO.getPlanta());
            instruccion.setInt(index++, cicloDTO.getProceso());
            instruccion.setInt(index++, cicloDTO.getCiclo());
            instruccion.setInt(index++, cicloDTO.getId());
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
	public String crearCiclo(CicloDTO cicloDTO,Connection con) throws Exception{
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CicloSQL.INSERT_CICLO;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, cicloDTO.getId());
            instruccion.setString(index++, cicloDTO.getCantidad());
            instruccion.setTimestamp(index++, PersistUtil.date());
            instruccion.setInt(index++, cicloDTO.getCama());
            instruccion.setInt(index++, cicloDTO.getPersona());
            instruccion.setInt(index++, cicloDTO.getPlanta());
            instruccion.setInt(index++, cicloDTO.getProceso());
            instruccion.setInt(index++, cicloDTO.getCiclo());
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
	public String borrarCiclo(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CicloSQL.DELETE_CICLO;
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
	public List<CicloDTO> ListarCiclos(Connection con) throws Exception{
		
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CicloDTO cicloDTO = null;
		List<CicloDTO> listaCiclos = new ArrayList<>();
		try {
			query = CicloSQL.LIST_CICLO;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				cicloDTO = new CicloDTO();
				setInfoCiclo(resultado, cicloDTO);
				listaCiclos.add(cicloDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaCiclos;
	}
}
