package dao.planta.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dao.planta.IPlantaDAO;
import dto.PlantaDTO;
import negocio.breeder.impl.BreederNegocio;
import negocio.planta.impl.PlantaNegocio;
import util.PersistUtil;

public class PlantaDAO implements IPlantaDAO{

	@Override
	public PlantaDTO consultarPlantaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		PlantaDTO plantaDTO = null;
		try {
			query = PlantaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				plantaDTO = new PlantaDTO();
				setInfoPlanta(resultado, plantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return plantaDTO;
	}

	private void setInfoPlanta(ResultSet resultado, PlantaDTO plantaDTO) throws Exception {
		

		plantaDTO.setId(resultado.getInt("id_planta"));
		plantaDTO.setNombre(resultado.getString("nombre_planta"));
		plantaDTO.setRenombre(resultado.getString("renombre_planta"));
		plantaDTO.setEsquejecf(resultado.getString("esquejecf_planta"));
		plantaDTO.setProductividad(resultado.getString("productividad_planta"));
		plantaDTO.setFlush(resultado.getString("flush_planta"));
		plantaDTO.setFlushs(resultado.getString("flushs_planta"));
		plantaDTO.setBreeder(resultado.getInt("fk_id_breeder"));
		plantaDTO.setNbreeder(resultado.getString("g.nombre_breeder"));
		plantaDTO.setColor1(resultado.getInt("fk_id_color1"));
		plantaDTO.setColores(resultado.getString("a.nombre_es_color"));
		plantaDTO.setColor2(resultado.getInt("fk_id_color2"));
		plantaDTO.setColorus(resultado.getString("c.nombre_es_color"));
		
	}
	
	private Boolean buscarBreeder(Integer breeder){
		BreederNegocio breederNegocio = new BreederNegocio();
    	if(breederNegocio.consultarBreederPorId(breeder) != null){
    		return true;
    	}else{
    		return false;
    	}
	}
	private Boolean buscarPlanta(Integer id){
		PlantaNegocio plantaNegocio = new PlantaNegocio();
		if(plantaNegocio.consultarPlantaPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String actualizarPlanta(PlantaDTO plantaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarPlanta(plantaDTO.getId())){
	        try {
	            query = PlantaSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
	            instruccion.setString(index++, plantaDTO.getNombre());
	            instruccion.setString(index++, plantaDTO.getRenombre());
	            instruccion.setString(index++, plantaDTO.getEsquejecf());
	            instruccion.setString(index++, plantaDTO.getProductividad());
	            instruccion.setString(index++, plantaDTO.getFlush());
	            instruccion.setString(index++, plantaDTO.getFlushs());
	            instruccion.setInt(index++, plantaDTO.getBreeder());
	            instruccion.setInt(index++, plantaDTO.getColor1());
	            instruccion.setInt(index++, plantaDTO.getColor2());
	            instruccion.setInt(index++, plantaDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
	        } catch (SQLException sql) {
	        	 message ="ERROR";
	        	con.rollback();
	            throw new Exception(sql.toString());
	        } finally {
	           PersistUtil.closeResources(instruccion);
        }}else{message ="La planta no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearPlanta(PlantaDTO plantaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarBreeder(plantaDTO.getBreeder())){
	        try {
	            query = PlantaSQL.INSERT;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
	            instruccion.setString(index++, plantaDTO.getNombre());
	            instruccion.setString(index++, plantaDTO.getRenombre());
	            instruccion.setString(index++, plantaDTO.getEsquejecf());
	            instruccion.setString(index++, plantaDTO.getProductividad());
	            instruccion.setString(index++, plantaDTO.getFlush());
	            instruccion.setString(index++, plantaDTO.getFlushs());
	            instruccion.setInt(index++, plantaDTO.getBreeder());
	            instruccion.setInt(index++, plantaDTO.getColor1());
	            instruccion.setInt(index++, plantaDTO.getColor2());
	            instruccion.executeUpdate();
	            message ="OK";
	        } catch (SQLException sql) {
	        	 message ="ERROR";
	        	con.rollback();
	            throw new Exception(sql.toString());
	        } finally {
	           PersistUtil.closeResources(instruccion);
        }}else{message ="El Breeder no esta registrada en la base de datos!!!";}
        return message;
	}

	@Override
	public String borrarPlanta(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = PlantaSQL.DELETE;
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
	public List<PlantaDTO> ListarPlantas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		PlantaDTO plantaDTO = null;
		List<PlantaDTO> listaPlantas = new ArrayList<>();
		try {
			query = PlantaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				plantaDTO = new PlantaDTO();
				setInfoPlanta(resultado, plantaDTO);
				listaPlantas.add(plantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaPlantas;
	}
}
