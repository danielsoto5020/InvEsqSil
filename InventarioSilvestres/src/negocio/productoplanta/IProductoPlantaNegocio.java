package negocio.productoplanta;

import java.util.List;

import dto.ProductoPlantaDTO;


public interface IProductoPlantaNegocio {
	
	public ProductoPlantaDTO consultarProductoPlantaPorId(Integer id);

	public String actualizarProductoPlanta(ProductoPlantaDTO productoPlantaDTO);

	public String crearProductoPlanta(ProductoPlantaDTO productoPlantaDTO);

	public String borrarProductoPlanta(Integer id);
	
	public List<ProductoPlantaDTO> ListarProductoPlantas();

}
