package dao.temperatura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.temperatura.ITemperaturaDAO;
import dto.TemperaturaDTO;
import negocio.bloque.impl.BloqueNegocio;
import negocio.persona.impl.PersonaNegocio;
import negocio.temperatura.impl.TemperaturaNegocio;
import util.PersistUtil;

public class TemperaturaDAO implements ITemperaturaDAO{
	

	@Override
	public TemperaturaDTO consultarTemperaturaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TemperaturaDTO temperaturaDTO = null;
		try {
			query = TemperaturaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				temperaturaDTO = new TemperaturaDTO();
				setInfoTemperatura(resultado, temperaturaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return temperaturaDTO;
	}

	private void setInfoTemperatura(ResultSet resultado, TemperaturaDTO temperaturaDTO) throws Exception {	
		temperaturaDTO.setId(resultado.getInt("id_temperatura"));
		temperaturaDTO.setValor(resultado.getString("valor_temperatura"));
		temperaturaDTO.setFecha(resultado.getString("fecha_temperatura"));
		temperaturaDTO.setSector(resultado.getString("sector_temperatura"));
		temperaturaDTO.setLugar(resultado.getString("lugar_temperatura"));
		temperaturaDTO.setBloque(resultado.getInt("fk_id_bloque"));
		temperaturaDTO.setPersona(resultado.getInt("fk_id_persona"));
		temperaturaDTO.setNpersona(resultado.getString("nombre_persona"));	
	}
	
	private Boolean buscarBloque(Integer bloque){
		BloqueNegocio bloqueNegocio = new BloqueNegocio();
    	if(bloqueNegocio.consultarBloquePorId(bloque) != null){
    		return true;
    	}else{
    		return false;
    	}
	}
	
	private Boolean buscarPersona(Integer persona){
		PersonaNegocio personaNegocio = new PersonaNegocio();
    	if(personaNegocio.consultarPersonaPorId(persona) != null){
    		return true;
    	}else{
    		return false;
    	}
	}
	
	private Boolean buscarTemperatura(Integer id){
		TemperaturaNegocio temperaturaNegocio = new TemperaturaNegocio();
		if(temperaturaNegocio.consultarTemperaturaPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarTemperatura(TemperaturaDTO temperaturaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarTemperatura(temperaturaDTO.getId())){
			try {
        	
	            query = TemperaturaSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setString(index++, temperaturaDTO.getValor());
                instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(temperaturaDTO.getFecha()));
                instruccion.setString(index++, temperaturaDTO.getSector());
                instruccion.setString(index++, temperaturaDTO.getLugar());
                instruccion.setInt(index++, temperaturaDTO.getBloque());
                instruccion.setInt(index++, temperaturaDTO.getPersona());
	            instruccion.setInt(index++, temperaturaDTO.getId());
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
	public String crearTemperatura(TemperaturaDTO temperaturaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarBloque(temperaturaDTO.getBloque()) && buscarPersona(temperaturaDTO.getPersona())){
        	try {
        	
        		 query = TemperaturaSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, temperaturaDTO.getValor());
                 instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(temperaturaDTO.getFecha()));
                 instruccion.setString(index++, temperaturaDTO.getSector());
                 instruccion.setString(index++, temperaturaDTO.getLugar());
                 instruccion.setInt(index++, temperaturaDTO.getBloque());
                 instruccion.setInt(index++, temperaturaDTO.getPersona());   
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El bloque o persona no esta registrada en la base de datos!!!";}
        return message;
	}

	@Override
	public String borrarTemperatura(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = TemperaturaSQL.DELETE;
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
	public List<TemperaturaDTO> ListarTemperaturas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		TemperaturaDTO temperaturaDTO = null;
		List<TemperaturaDTO> listaTemperaturas = new ArrayList<>();
		try {
			query = TemperaturaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				temperaturaDTO = new TemperaturaDTO();
				setInfoTemperatura(resultado, temperaturaDTO);
				listaTemperaturas.add(temperaturaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaTemperaturas;
	}

}
