package dao.proceso;

import java.sql.Connection;
import java.util.List;

import dto.ProcesoDTO;

public interface IProcesoDAO {
	
	public ProcesoDTO consultarProcesoPorId(Integer id, Connection con) throws Exception;

	public String actualizarProceso(ProcesoDTO procesoDTO, Connection con) throws Exception;

	public String crearProceso(ProcesoDTO procesoDTO,Connection con) throws Exception;

	public String borrarProceso(Integer id, Connection con) throws Exception;
	
	public List<ProcesoDTO> ListarProcesos(Connection con) throws Exception;
}
