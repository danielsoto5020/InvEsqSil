package dao.tipo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.tipo.ITipoDAO;
import dto.TipoDTO;
import negocio.tipo.impl.TipoNegocio;
import util.PersistUtil;

public class TipoDAO implements ITipoDAO{
	

	@Override
	public TipoDTO consultarTipoPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TipoDTO tipoDTO = null;
		try {
			query = TipoSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				tipoDTO = new TipoDTO();
				setInfoTipo(resultado, tipoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return tipoDTO;
	}

	private void setInfoTipo(ResultSet resultado, TipoDTO tipoDTO) throws Exception {	
		tipoDTO.setId(resultado.getInt("id_tipo"));
		tipoDTO.setNombre(resultado.getString("nombre_tipo"));	
	}	
	
	private Boolean buscarTipo(Integer id){
		TipoNegocio tipoNegocio = new TipoNegocio();
		if(tipoNegocio.consultarTipoPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarTipo(TipoDTO tipoDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarTipo(tipoDTO.getId())){
			try {
        	
	            query = TipoSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setString(index++, tipoDTO.getNombre());
                instruccion.setInt(index, tipoDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="no exite ningun Tipo de Flor en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearTipo(TipoDTO tipoDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        	try {
        	
        		 query = TipoSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, tipoDTO.getNombre());   
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }
        return message;
	}

	@Override
	public String borrarTipo(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = TipoSQL.DELETE;
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
	public List<TipoDTO> ListarTipos(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TipoDTO tipoDTO = null;
		List<TipoDTO> listaTipos = new ArrayList<>();
		try {
			query = TipoSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				tipoDTO = new TipoDTO();
				setInfoTipo(resultado, tipoDTO);
				listaTipos.add(tipoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaTipos;
	}
}
