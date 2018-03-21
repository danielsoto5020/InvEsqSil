package dao.productoplanta.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.productoplanta.IProductoPlantaDAO;
import dto.ProductoPlantaDTO;
import negocio.planta.impl.PlantaNegocio;
import negocio.producto.impl.ProductoNegocio;
import negocio.productoplanta.impl.ProductoPlantaNegocio;
import util.PersistUtil;

public class ProductoPlantaDAO implements IProductoPlantaDAO{
	
	

	@Override
	public ProductoPlantaDTO consultarProductoPlantaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProductoPlantaDTO productoPlantaDTO = null;
		try {
			query = ProductoPlantaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				productoPlantaDTO = new ProductoPlantaDTO();
				setInfoProductoPlanta(resultado, productoPlantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return productoPlantaDTO;
	}

	private void setInfoProductoPlanta(ResultSet resultado, ProductoPlantaDTO productoPlantaDTO) throws Exception {	
		productoPlantaDTO.setId(resultado.getInt("id_producto_planta"));
		
		productoPlantaDTO.setNplanta(resultado.getString("nombre_planta"));
		productoPlantaDTO.setNproducto(resultado.getString("nombre_producto"));
	}
	
	
	private Boolean buscarProductoPlanta(Integer id){
		ProductoPlantaNegocio productoPlantaNegocio = new ProductoPlantaNegocio();
		if(productoPlantaNegocio.consultarProductoPlantaPorId(id)!= null){
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
	
	private Boolean buscarProducto(Integer id){
		ProductoNegocio productoNegocio = new ProductoNegocio();
		if(productoNegocio.consultarProductoPorId(id)!= null){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public String actualizarProductoPlanta(ProductoPlantaDTO productoPlantaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarProductoPlanta(productoPlantaDTO.getId())){
			try {
        	
	            query = ProductoPlantaSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setInt(index++, productoPlantaDTO.getPlanta());
                instruccion.setInt(index++, productoPlantaDTO.getProducto());
	            instruccion.setInt(index++, productoPlantaDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="Relacion Planta Producto no encontrada verifique los datos!!!";}
        return message;
	}

	@Override
	public String crearProductoPlanta(ProductoPlantaDTO productoPlantaDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        if(buscarPlanta(productoPlantaDTO.getPlanta()) && buscarProducto(productoPlantaDTO.getProducto())){
        	try {
        	
        		 query = ProductoPlantaSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setInt(index++, productoPlantaDTO.getPlanta()); 
                 instruccion.setInt(index++, productoPlantaDTO.getProducto());
                 instruccion.executeUpdate();
                 message ="OK";
        	}catch (SQLException sql) {
           	 message =" ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="La planta o el producto incorrectos verifique los datos!!!";}
        return message;
	}

	@Override
	public String borrarProductoPlanta(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ProductoPlantaSQL.DELETE;
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
	public List<ProductoPlantaDTO> ListarProductoPlantas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProductoPlantaDTO productoPlantaDTO = null;
		List<ProductoPlantaDTO> listaProductoPlantas = new ArrayList<>();
		try {
			query = ProductoPlantaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				productoPlantaDTO = new ProductoPlantaDTO();
				setInfoProductoPlanta(resultado, productoPlantaDTO);
				listaProductoPlantas.add(productoPlantaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaProductoPlantas;
	}
}
