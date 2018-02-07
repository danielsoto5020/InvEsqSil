package negocio.producto;

import java.util.List;

import dto.ProductoDTO;

public interface IProductoNegocio {
	
	public ProductoDTO consultarProductoPorId(Integer id);

	public String actualizarProducto(ProductoDTO productoDTO);

	public String crearProducto(ProductoDTO productoDTO);

	public String borrarProducto(Integer id);
	
	public List<ProductoDTO> ListarProductos();

}
