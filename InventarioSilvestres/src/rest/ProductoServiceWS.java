package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ProductoDTO;
import negocio.producto.IProductoNegocio;
import negocio.producto.impl.ProductoNegocio;


@Path("/producto")

public class ProductoServiceWS {
	
	private IProductoNegocio  productoNegocio;
	
	public ProductoServiceWS(){
		productoNegocio = new ProductoNegocio();
	}
	
	@GET
	@Path("/consultar-producto/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoDTO consultarProductoPorId(@PathParam("id") Integer id) {
		return productoNegocio.consultarProductoPorId(id);
	}

	@POST
	@Path("/actualizar-producto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarProducto(ProductoDTO productoDTO) {
		return productoNegocio.actualizarProducto(productoDTO);
	}

	@POST
	@Path("/crear-producto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearProducto(ProductoDTO productoDTO) {
		return productoNegocio.crearProducto(productoDTO);
	}

	@GET
	@Path("/borrar-producto/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarProducto(@PathParam("id") Integer id) {
		return productoNegocio.borrarProducto(id);
	}

	@GET
	@Path("/listar-producto")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductoDTO> ListarProductos() {
		return productoNegocio.ListarProductos();
	}



}
