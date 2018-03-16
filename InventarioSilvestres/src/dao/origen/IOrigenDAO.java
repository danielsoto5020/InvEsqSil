package dao.origen;

import java.sql.Connection;
import java.util.List;

import dto.OrigenDTO;

public interface IOrigenDAO {

	public OrigenDTO consultarOrigenPorId(Integer id, Connection con) throws Exception;

	public String actualizarOrigen(OrigenDTO origenDTO, Connection con) throws Exception;

	public String crearOrigen(OrigenDTO origenDTO,Connection con) throws Exception;

	public String borrarOrigen(Integer id, Connection con) throws Exception;

	public Integer obtenerOrigen(String nombre, Connection con) throws Exception;
	
	public List<OrigenDTO> ListarOrigens(Connection con) throws Exception;
}
