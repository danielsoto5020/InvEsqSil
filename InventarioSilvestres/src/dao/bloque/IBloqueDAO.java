package dao.bloque;

import java.sql.Connection;
import java.util.List;

import dto.BloqueDTO;


public interface IBloqueDAO {
	
	public BloqueDTO consultarBloquePorId(Integer id, Connection con) throws Exception;

	public String actualizarBloque(BloqueDTO bloqueDTO, Connection con) throws Exception;

	public String crearBloque(BloqueDTO bloqueDTO,Connection con) throws Exception;

	public String borrarBloque(Integer id, Connection con) throws Exception;
	
	public List<BloqueDTO> ListarBloques(Connection con) throws Exception;
	

}
