package dao.producto.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.producto.IProductoDAO;
import dto.ProductoDTO;
import negocio.producto.impl.ProductoNegocio;
import util.PersistUtil;

public class ProductoDAO implements IProductoDAO{
	

	@Override
	public ProductoDTO consultarProductoPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProductoDTO productoDTO = null;
		try {
			query = ProductoSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				productoDTO = new ProductoDTO();
				setInfoProducto(resultado, productoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return productoDTO;
	}

	private void setInfoProducto(ResultSet resultado, ProductoDTO productoDTO) throws Exception {	
		productoDTO.setId(resultado.getInt("id_producto"));
		productoDTO.setNombre(resultado.getString("nombre_producto"));	
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
	public String actualizarProducto(ProductoDTO productoDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
		if(buscarProducto(productoDTO.getId())){
			try {
        	
	            query = ProductoSQL.UPDATE;
	            instruccion = con.prepareStatement(query);
	            int index = 1;
                instruccion.setString(index++, productoDTO.getNombre());
	            instruccion.setInt(index++, productoDTO.getId());
	            instruccion.executeUpdate();
	            message ="OK";
        	}catch (SQLException sql) {
           	 message ="ERROR";
         	con.rollback();
             throw new Exception(sql.toString());
         } finally {
            PersistUtil.closeResources(instruccion);
         }}else{message ="El Producto no se encuentra en la Base de Datos!!!";}
        return message;
	}

	@Override
	public String crearProducto(ProductoDTO productoDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        	try {
        	
        		 query = ProductoSQL.INSERT;
                 instruccion = con.prepareStatement(query);
                 int index = 1;
                 instruccion.setString(index++, productoDTO.getNombre());  
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
	public String borrarProducto(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = ProductoSQL.DELETE;
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
	public List<ProductoDTO> ListarProductos(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		ProductoDTO productoDTO = null;
		List<ProductoDTO> listaProductos = new ArrayList<>();
		try {
			query = ProductoSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				productoDTO = new ProductoDTO();
				setInfoProducto(resultado, productoDTO);
				listaProductos.add(productoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaProductos;
	}


}
