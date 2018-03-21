package dao.codigorf.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.codigorf.ICodigorfDAO;
import dto.CodigorfDTO;
import negocio.codigorf.impl.CodigorfNegocio;
import negocio.planta.impl.PlantaNegocio;
import util.PersistUtil;

public class CodigorfDAO implements ICodigorfDAO{


	@Override
	public CodigorfDTO consultarCodigorfPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CodigorfDTO codigorfDTO = null;
		try {
			query = CodigorfSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				codigorfDTO = new CodigorfDTO();
				setInfoCodigorf(resultado, codigorfDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return codigorfDTO;
	}

	private void setInfoCodigorf(ResultSet resultado, CodigorfDTO codigorfDTO) throws Exception {	
		codigorfDTO.setId(resultado.getInt("id_codigorf"));
		codigorfDTO.setCodigo(resultado.getString("nombre_codigorf"));
		codigorfDTO.setNplanta(resultado.getString("nombre_planta"));
	}
	
	
	private Boolean buscarCodigorf(Integer id){
		CodigorfNegocio codigorfNegocio = new CodigorfNegocio();
		if(codigorfNegocio.consultarCodigorfPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}
	
	private Boolean buscarPlanta(Integer planta){
		PlantaNegocio plantaNegocio = new PlantaNegocio();
    	if(plantaNegocio.consultarPlantaPorId(planta) != null){
    		return true;
    	}else{
    		return false;
    	}
	}

	@Override
	public String actualizarCodigorf(CodigorfDTO codigorfDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarCodigorf(codigorfDTO.getId())){
			try {
        	
	            query = CodigorfSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
	            instruccion.setString(index++, codigorfDTO.getCodigo());
	            instruccion.setInt(index++, codigorfDTO.getPlanta());
	            instruccion.setInt(index++, codigorfDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El codigo de RedFlor no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearCodigorf(CodigorfDTO codigorfDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarPlanta(codigorfDTO.getPlanta())){
        	try {
        		 query = CodigorfSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, codigorfDTO.getCodigo());
                 instruccion.setInt(index++, codigorfDTO.getPlanta());
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="No exite la variedad en la base de datos!!!";}
        return message;
	}

	@Override
	public String borrarCodigorf(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = CodigorfSQL.DELETE;
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
	public List<CodigorfDTO> ListarCodigorfs(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		CodigorfDTO codigorfDTO = null;
		List<CodigorfDTO> listaCodigorfs = new ArrayList<>();
		try {
			query = CodigorfSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				codigorfDTO = new CodigorfDTO();
				setInfoCodigorf(resultado, codigorfDTO);
				listaCodigorfs.add(codigorfDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaCodigorfs;
	}


}
