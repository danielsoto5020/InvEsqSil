package dao.productoplanta;

import java.sql.Connection;
import java.util.List;

import dto.ProductoPlantaDTO;

public interface IProductoPlantaDAO {

	public ProductoPlantaDTO consultarProductoPlantaPorId(Integer id, Connection con) throws Exception;

	public String actualizarProductoPlanta(ProductoPlantaDTO productoPlantaDTO, Connection con) throws Exception;

	public String crearProductoPlanta(ProductoPlantaDTO productoPlantaDTO,Connection con) throws Exception;

	public String borrarProductoPlanta(Integer id, Connection con) throws Exception;
	
	public List<ProductoPlantaDTO> ListarProductoPlantas(Connection con) throws Exception;

}
