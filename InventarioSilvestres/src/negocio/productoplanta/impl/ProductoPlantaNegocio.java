package negocio.productoplanta.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.productoplanta.IProductoPlantaDAO;
import dao.productoplanta.jdbc.ProductoPlantaDAO;
import dto.ProductoPlantaDTO;
import negocio.productoplanta.IProductoPlantaNegocio;
import util.PersistUtil;

public class ProductoPlantaNegocio implements IProductoPlantaNegocio{
	
	private IProductoPlantaDAO productoPlantaDAO;
    private DataSource dataSource;
	
	public ProductoPlantaNegocio(){
		dataSource = PersistUtil.getDataSource();
		productoPlantaDAO = new ProductoPlantaDAO();
	}
	
	@Override
	public ProductoPlantaDTO consultarProductoPlantaPorId(Integer id) {
		Connection con = null;
		ProductoPlantaDTO productoPlantaDTO = null;
		try {
			con = dataSource.getConnection();
			productoPlantaDTO= productoPlantaDAO.consultarProductoPlantaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return productoPlantaDTO;
	}

	@Override
	public String actualizarProductoPlanta(ProductoPlantaDTO productoPlantaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoPlantaDAO.actualizarProductoPlanta(productoPlantaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearProductoPlanta(ProductoPlantaDTO productoPlantaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoPlantaDAO.crearProductoPlanta(productoPlantaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarProductoPlanta(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = productoPlantaDAO.borrarProductoPlanta(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<ProductoPlantaDTO> ListarProductoPlantas() {
		Connection con = null;
		List<ProductoPlantaDTO> listaProductoPlantas = null;
		try {
			con = dataSource.getConnection();
			listaProductoPlantas= productoPlantaDAO.ListarProductoPlantas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaProductoPlantas;
	}
}
