package dao.origen.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.origen.IOrigenDAO;
import dto.OrigenDTO;
import util.PersistUtil;

public class OrigenDAO implements IOrigenDAO{
	
	@Override
	public OrigenDTO consultarOrigenPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		OrigenDTO origenDTO= null;
		try {
			query = OrigenSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				origenDTO = new OrigenDTO();
				setInfoOrigen(resultado, origenDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return origenDTO;
	}

	private void setInfoOrigen(ResultSet resultado, OrigenDTO origenDTO) throws Exception {
		
		
		origenDTO.setId(resultado.getInt("id_origen"));
		origenDTO.setNombre(resultado.getString("nombre_origen"));
	}

	@Override
	public String actualizarOrigen(OrigenDTO origenDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
        try {
            query = OrigenSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, origenDTO.getNombre());
            instruccion.setInt(index++, origenDTO.getId());
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
	public String crearOrigen(OrigenDTO origenDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(origenDTO.getNombre()!="") {
        try {
            query = OrigenSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, origenDTO.getNombre());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        }finally {
           PersistUtil.closeResources(instruccion);
        }
        }else {
			message = "El nombre del origen debe de ser valido.";
		}
        return message;
	}

	@Override
	public String borrarOrigen(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = OrigenSQL.DELETE;
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
	public Integer obtenerOrigen(String nombre, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		Integer id = null;
		try {
			query = OrigenSQL.FIND_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setString(index++, nombre);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				id = resultado.getInt("id_origen");
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return id;
	}

	@Override
	public List<OrigenDTO> ListarOrigens(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		OrigenDTO origenDTO = null;
		List<OrigenDTO> listaOrigens = new ArrayList<>();
		try {
			query = OrigenSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				origenDTO = new OrigenDTO();
				setInfoOrigen(resultado, origenDTO);
				listaOrigens.add(origenDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaOrigens;
	}

}
