package dao.ingreso;

import java.sql.Connection;
import java.util.List;

import dto.IngresoDTO;

public interface IIngresoDAO {

	
	public IngresoDTO consultarIngresoPorId(Integer id, Connection con) throws Exception;

	public String actualizarIngreso(IngresoDTO ingresoDTO, Connection con) throws Exception;

	public String crearIngreso(IngresoDTO ingresoDTO,Connection con) throws Exception;

	public String borrarIngreso(Integer id, Connection con) throws Exception;
	
	public List<IngresoDTO> ListarIngresos(Connection con) throws Exception;

}

