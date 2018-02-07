package dao.producto;

import java.sql.Connection;
import java.util.List;

import dto.ProductoDTO;


public interface IProductoDAO {
	
	public ProductoDTO consultarProductoPorId(Integer id, Connection con) throws Exception;

	public String actualizarProducto(ProductoDTO productoDTO, Connection con) throws Exception;

	public String crearProducto(ProductoDTO productoDTO,Connection con) throws Exception;

	public String borrarProducto(Integer id, Connection con) throws Exception;
	
	public List<ProductoDTO> ListarProductos(Connection con) throws Exception;


}
