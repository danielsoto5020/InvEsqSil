package dao.bloque.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.bloque.IBloqueDAO;
import dto.BloqueDTO;
import negocio.bloque.impl.BloqueNegocio;
import negocio.finca.impl.FincaNegocio;
import util.PersistUtil;

public class BloqueDAO implements IBloqueDAO{
	
	
	@Override
	public BloqueDTO consultarBloquePorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		BloqueDTO bloqueDTO = null;
		try {
			query = BloqueSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				bloqueDTO = new BloqueDTO();
				setInfoBloque(resultado, bloqueDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return bloqueDTO;
	}

	private void setInfoBloque(ResultSet resultado, BloqueDTO bloqueDTO) throws Exception {	
		bloqueDTO.setId(resultado.getInt("id_bloque"));
		bloqueDTO.setNombre(resultado.getString("nombre_bloque"));
		bloqueDTO.setNcama(resultado.getString("ncama_bloque"));
		bloqueDTO.setNfinca(resultado.getString("nombre_finca"));
	}
	
	private Boolean buscarFinca(Integer finca){
		FincaNegocio fincaNegocio = new FincaNegocio();
    	if(fincaNegocio.consultarFincaPorId(finca) != null){
    		return true;
    	}else{
    		return false;
    	}
	}
	private Boolean buscarBloque(Integer id){
		BloqueNegocio bloqueNegocio = new BloqueNegocio();
		if(bloqueNegocio.consultarBloquePorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarBloque(BloqueDTO bloqueDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarBloque(bloqueDTO.getId())){
			try {
        	
	            query = BloqueSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
	            instruccion.setString(index++, bloqueDTO.getNombre());
	            instruccion.setString(index++, bloqueDTO.getNcama());
	            instruccion.setInt(index++, bloqueDTO.getFinca());
	            instruccion.setInt(index++, bloqueDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El bloque no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearBloque(BloqueDTO bloqueDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarFinca(bloqueDTO.getFinca())){
        	try {
        	
        		 query = BloqueSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, bloqueDTO.getNombre());
                 instruccion.setString(index++, bloqueDTO.getNcama());
                 instruccion.setInt(index++, bloqueDTO.getFinca());
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="La finca no esta registrada en la base de datos!!!";}
        return message;
	}

	@Override
	public String borrarBloque(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = BloqueSQL.DELETE;
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
	public List<BloqueDTO> ListarBloques(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		BloqueDTO bloqueDTO = null;
		List<BloqueDTO> listaBloques = new ArrayList<>();
		try {
			query = BloqueSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				bloqueDTO = new BloqueDTO();
				setInfoBloque(resultado, bloqueDTO);
				listaBloques.add(bloqueDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaBloques;
	}

}
