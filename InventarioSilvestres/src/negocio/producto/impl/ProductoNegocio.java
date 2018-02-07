package negocio.producto.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.producto.IProductoDAO;
import dao.producto.jdbc.ProductoDAO;
import dto.ProductoDTO;
import negocio.producto.IProductoNegocio;
import util.PersistUtil;

public class ProductoNegocio implements IProductoNegocio{
	
	private IProductoDAO productoDAO;
    private DataSource dataSource;
	
	public ProductoNegocio(){
		dataSource = PersistUtil.getDataSource();
		productoDAO = new ProductoDAO();
	}
	
	@Override
	public ProductoDTO consultarProductoPorId(Integer id) {
		Connection con = null;
		ProductoDTO productoDTO = null;
		try {
			con = dataSource.getConnection();
			productoDTO= productoDAO.consultarProductoPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return productoDTO;
	}

	@Override
	public String actualizarProducto(ProductoDTO productoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoDAO.actualizarProducto(productoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearProducto(ProductoDTO productoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoDAO.crearProducto(productoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarProducto(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoDAO.borrarProducto(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<ProductoDTO> ListarProductos() {
		Connection con = null;
		List<ProductoDTO> listaProductos = null;
		try {
			con = dataSource.getConnection();
			listaProductos= productoDAO.ListarProductos(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaProductos;
	}


}
