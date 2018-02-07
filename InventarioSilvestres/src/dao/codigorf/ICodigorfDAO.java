package dao.codigorf;

import java.sql.Connection;
import java.util.List;

import dto.CodigorfDTO;

public interface ICodigorfDAO {
	
	public CodigorfDTO consultarCodigorfPorId(Integer id, Connection con) throws Exception;

	public String actualizarCodigorf(CodigorfDTO codigorfDTO, Connection con) throws Exception;

	public String crearCodigorf(CodigorfDTO codigorfDTO,Connection con) throws Exception;

	public String borrarCodigorf(Integer id, Connection con) throws Exception;
	
	public List<CodigorfDTO> ListarCodigorfs(Connection con) throws Exception;

}
