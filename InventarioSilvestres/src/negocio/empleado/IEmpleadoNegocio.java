package negocio.empleado;

import java.util.List;

import dto.EmpleadoDTO;

public interface IEmpleadoNegocio {
	
	public EmpleadoDTO consultarEmpleadoPorId(Integer id);

	public String actualizarEmpleado(EmpleadoDTO empleadoDTO);

	public String crearEmpleado(EmpleadoDTO empleadoDTO);

	public String borrarEmpleado(Integer id);
	
	public List<EmpleadoDTO> ListarEmpleados();

}
