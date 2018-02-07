package dao.color.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.color.IColorDAO;
import dto.ColorDTO;
import negocio.color.impl.ColorNegocio;
import util.PersistUtil;

public class ColorDAO implements IColorDAO{

	@Override
	public ColorDTO consultarColorPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ColorDTO colorDTO = null;
		try {
			query = ColorSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				colorDTO = new ColorDTO();
				setInfoColor(resultado, colorDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return colorDTO;
	}

	private void setInfoColor(ResultSet resultado, ColorDTO colorDTO) throws Exception {	
		colorDTO.setId(resultado.getInt("id_color"));
		colorDTO.setNombre(resultado.getString("nombre_es_color"));
		colorDTO.setName(resultado.getString("nombre_us_color"));
	}
	
	
	private Boolean buscarColor(Integer id){
		ColorNegocio colorNegocio = new ColorNegocio();
		if(colorNegocio.consultarColorPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarColor(ColorDTO colorDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarColor(colorDTO.getId())){
			try {
        	
	            query = ColorSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
	            instruccion.setString(index++, colorDTO.getNombre());
	            instruccion.setString(index++, colorDTO.getName());
	            instruccion.setInt(index++, colorDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El color no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearColor(ColorDTO colorDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        	try {
        		 query = ColorSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, colorDTO.getNombre());
                 instruccion.setString(index++, colorDTO.getName());
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
	public String borrarColor(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ColorSQL.DELETE;
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
	public List<ColorDTO> ListarColors(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ColorDTO colorDTO = null;
		List<ColorDTO> listaColors = new ArrayList<>();
		try {
			query = ColorSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				colorDTO = new ColorDTO();
				setInfoColor(resultado, colorDTO);
				listaColors.add(colorDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaColors;
	}


}
