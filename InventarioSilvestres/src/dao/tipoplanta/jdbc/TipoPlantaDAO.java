package dao.tipoplanta.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.tipoplanta.ITipoPlantaDAO;
import dto.TipoPlantaDTO;
import negocio.planta.impl.PlantaNegocio;
import negocio.tipo.impl.TipoNegocio;
import negocio.tipoplanta.impl.TipoPlantaNegocio;
import util.PersistUtil;

public class TipoPlantaDAO implements ITipoPlantaDAO{
	
	@Override
	public TipoPlantaDTO consultarTipoPlantaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TipoPlantaDTO tipoPlantaDTO = null;
		try {
			query = TipoPlantaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				tipoPlantaDTO = new TipoPlantaDTO();
				setInfoTipoPlanta(resultado, tipoPlantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return tipoPlantaDTO;
	}

	private void setInfoTipoPlanta(ResultSet resultado, TipoPlantaDTO tipoPlantaDTO) throws Exception {	
		tipoPlantaDTO.setId(resultado.getInt("id_tipo_planta"));
		tipoPlantaDTO.setPlanta(resultado.getInt("fk_id_planta"));
		tipoPlantaDTO.setTipo(resultado.getInt("fk_id_tipo"));
	}
	
	
	private Boolean buscarTipoPlanta(Integer id){
		TipoPlantaNegocio tipoPlantaNegocio = new TipoPlantaNegocio();
		if(tipoPlantaNegocio.consultarTipoPlantaPorId(id)!= null){
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
	
	private Boolean buscarTipo(Integer id){
		TipoNegocio tipoNegocio = new TipoNegocio();
		if(tipoNegocio.consultarTipoPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarTipoPlanta(TipoPlantaDTO tipoPlantaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarTipoPlanta(tipoPlantaDTO.getId())){
			try {
        	
	            query = TipoPlantaSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setInt(index++, tipoPlantaDTO.getPlanta());
                instruccion.setInt(index++, tipoPlantaDTO.getTipo());
	            instruccion.setInt(index++, tipoPlantaDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="Relacion Esqueje-Tipo Flor no encontrada verifique los datos!!!";}
        return message;
	}

	@Override
	public String crearTipoPlanta(TipoPlantaDTO tipoPlantaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarPlanta(tipoPlantaDTO.getPlanta()) && buscarTipo(tipoPlantaDTO.getTipo())){
        	try {
        	
        		 query = TipoPlantaSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setInt(index++, tipoPlantaDTO.getPlanta()); 
                 instruccion.setInt(index++, tipoPlantaDTO.getTipo());
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="La planta o el tipo de flor incorrectos verifique los datos!!!";}
        return message;
	}

	@Override
	public String borrarTipoPlanta(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = TipoPlantaSQL.DELETE;
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
	public List<TipoPlantaDTO> ListarTipoPlantas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TipoPlantaDTO tipoPlantaDTO = null;
		List<TipoPlantaDTO> listaTipoPlantas = new ArrayList<>();
		try {
			query = TipoPlantaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				tipoPlantaDTO = new TipoPlantaDTO();
				setInfoTipoPlanta(resultado, tipoPlantaDTO);
				listaTipoPlantas.add(tipoPlantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaTipoPlantas;
	}
}
