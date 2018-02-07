package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.ProductoPlantaDTO;
import negocio.productoplanta.IProductoPlantaNegocio;
import negocio.productoplanta.impl.ProductoPlantaNegocio;

@Path("/productoplanta")

public class ProductoPlantaServiceWS {
	
	private IProductoPlantaNegocio  productoPlantaNegocio;
	
	public ProductoPlantaServiceWS(){
		productoPlantaNegocio = new ProductoPlantaNegocio();
	}

	@GET
	@Path("/consultar-productoplanta/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public ProductoPlantaDTO consultarProductoPlantaPorId(@PathParam("id") Integer id) {
		return productoPlantaNegocio.consultarProductoPlantaPorId(id);
	}

	@POST
	@Path("/actualizar-productoplanta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarProductoPlanta(ProductoPlantaDTO productoPlantaDTO) {
		return productoPlantaNegocio.actualizarProductoPlanta(productoPlantaDTO);
	}

	@POST
	@Path("/crear-productoplanta")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearProductoPlanta(ProductoPlantaDTO productoPlantaDTO) {
		return productoPlantaNegocio.crearProductoPlanta(productoPlantaDTO);
	}

	@GET
	@Path("/borrar-productoplanta/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarProductoPlanta(@PathParam("id") Integer id) {
		return productoPlantaNegocio.borrarProductoPlanta(id);
	}

	@GET
	@Path("/listar-productoplanta")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductoPlantaDTO> ListarProductoPlantas() {
		return productoPlantaNegocio.ListarProductoPlantas();
	}
}
