package rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dto.EmpleadoDTO;
import negocio.empleado.IEmpleadoNegocio;
import negocio.empleado.impl.EmpleadoNegocio;

@Path("/empleado")

public class EmpleadoServiceWS {
	
	private IEmpleadoNegocio  empleadoNegocio;
	
	public EmpleadoServiceWS() {
		empleadoNegocio = new EmpleadoNegocio();
	}
	
	@GET
	@Path("/consultar-empleado/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public EmpleadoDTO consultarEmpleadoPorId(@PathParam("id") Integer id) {
		return empleadoNegocio.consultarEmpleadoPorId(id);
	}

	@POST
	@Path("/actualizar-empleado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String actualizarEmpleado(EmpleadoDTO empleadoDTO) {
		return empleadoNegocio.actualizarEmpleado(empleadoDTO);
	}

	@POST
	@Path("/crear-empleado")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String crearEmpleado(EmpleadoDTO empleadoDTO) {
		return empleadoNegocio.crearEmpleado(empleadoDTO);
	}

	@GET
	@Path("/borrar-empleado/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String borrarEmpleado(@PathParam("id") Integer id) {
		return empleadoNegocio.borrarEmpleado(id);
	}

	@GET
	@Path("/listar-empleado")
	@Produces(MediaType.APPLICATION_JSON)
	public List<EmpleadoDTO> ListarEmpleados() {
		return empleadoNegocio.ListarEmpleados();
	}
}

