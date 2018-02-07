package dao.empleado;

import java.sql.Connection;
import java.util.List;

import dto.EmpleadoDTO;

public interface IEmpleadoDAO {
	
	public EmpleadoDTO consultarEmpleadoPorId(Integer id, Connection con) throws Exception;

	public String actualizarEmpleado(EmpleadoDTO empleadoDTO, Connection con) throws Exception;

	public String crearEmpleado(EmpleadoDTO empleadoDTO,Connection con) throws Exception;

	public String borrarEmpleado(Integer id, Connection con) throws Exception;
	
	public List<EmpleadoDTO> ListarEmpleados(Connection con) throws Exception;

}
