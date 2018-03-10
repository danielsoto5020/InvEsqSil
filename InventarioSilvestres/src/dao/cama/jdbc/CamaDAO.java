package dao.cama.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import dao.cama.ICamaDAO;
import dto.CamaDTO;
import negocio.bloque.impl.BloqueNegocio;
import negocio.cama.impl.CamaNegocio;
import util.PersistUtil;

public class CamaDAO implements ICamaDAO{
	
	@Override
	public CamaDTO consultarCamaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CamaDTO camaDTO = null;
		try {
			query = CamaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				camaDTO = new CamaDTO();
				setInfoCama(resultado, camaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return camaDTO;
	}

	private void setInfoCama(ResultSet resultado, CamaDTO camaDTO) throws Exception {	
		camaDTO.setId(resultado.getInt("id_cama"));
		camaDTO.setNumero(resultado.getString("numero_cama"));
		camaDTO.setAncho(resultado.getString("ancho_cama"));
		camaDTO.setLargo(resultado.getString("largo_cama"));
		camaDTO.setLineas(resultado.getString("lineas_cama"));
		camaDTO.setNlinea(resultado.getString("nlinea_cama"));
		camaDTO.setEstado(resultado.getString("estado_cama"));
		camaDTO.setEsterilizacion(resultado.getString("esterilizacion_cama"));
		camaDTO.setBloque(resultado.getInt("fk_id_bloque"));
	}
	
	private Boolean buscarBloque(Integer bloque){
		BloqueNegocio bloqueNegocio = new BloqueNegocio();
    	if(bloqueNegocio.consultarBloquePorId(bloque) != null){
    		return true;
    	}else{
    		return false;
    	}
	}
	
	@Override
	public Integer buscarCama(String ncama, String nbloque, Connection con)throws Exception{
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		Integer id= null;
		String query;
		try {
			query = CamaSQL.FIND_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setString(index++, ncama);
			instruccion.setString(index++, nbloque);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				id = resultado.getInt("id_cama");
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return id;
	}
	
	private Boolean buscarCama(Integer id){
		CamaNegocio camaNegocio = new CamaNegocio();
		if(camaNegocio.consultarCamaPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarCama(CamaDTO camaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarCama(camaDTO.getId())){
			try {
        	
	            query = CamaSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setString(index++, camaDTO.getNumero());
                instruccion.setString(index++, camaDTO.getAncho());
                instruccion.setString(index++, camaDTO.getLargo());
                instruccion.setString(index++, camaDTO.getLineas());
                instruccion.setString(index++, camaDTO.getNlinea());
                instruccion.setString(index++, camaDTO.getEstado());
                instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(camaDTO.getEsterilizacion()));
	            instruccion.setInt(index++, camaDTO.getBloque());
	            instruccion.setInt(index++, camaDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="La cama no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearCama(CamaDTO camaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarBloque(camaDTO.getBloque())){
        	try {
        	
        		 query = CamaSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, camaDTO.getNumero());
                 instruccion.setString(index++, camaDTO.getAncho());
                 instruccion.setString(index++, camaDTO.getLargo());
                 instruccion.setString(index++, camaDTO.getLineas());
                 instruccion.setString(index++, camaDTO.getNlinea());
                 instruccion.setString(index++, camaDTO.getEstado());
                 instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(camaDTO.getEsterilizacion()));
 	            instruccion.setInt(index++, camaDTO.getBloque());
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El bloque no esta registrada en la base de datos!!!";}
        return message;
	}
	
	@Override
	public String esterilizarCama(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CamaSQL.ESTERIL;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, id);
            instruccion.executeUpdate();
            message ="Cama esterilizada";
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
	public String borrarCama(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CamaSQL.DELETE;
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
	public List<CamaDTO> ListarCamas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CamaDTO camaDTO = null;
		List<CamaDTO> listaCamas = new ArrayList<>();
		try {
			query = CamaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				camaDTO = new CamaDTO();
				setInfoCama(resultado, camaDTO);
				listaCamas.add(camaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaCamas;
	}
	

	@Override
	public List<CamaDTO> SelectCamas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CamaDTO camaDTO = null;
		List<CamaDTO> listaCamas = new ArrayList<>();
		try {
			query = CamaSQL.ACTIV;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				camaDTO = new CamaDTO();
				setInfoCama(resultado, camaDTO);
				listaCamas.add(camaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaCamas;
	}
	
	
	@Override
	public CamaDTO consultarEspacio(Integer id, Integer cantidad, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CamaDTO camaDTO = null;
		try {
			query = CamaSQL.FIND_ESPACE;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				camaDTO = new CamaDTO();
				setInfoCama(resultado, camaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		if((Integer.parseInt(camaDTO.getLineas())*(Integer.parseInt(camaDTO.getNlinea()))) >= cantidad) {

			return camaDTO;
			
		}else {

			return null;
			
		}
	}
}
