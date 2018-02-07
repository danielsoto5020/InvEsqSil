package dao.ciclo;

import java.sql.Connection;
import java.util.List;

import dto.CicloDTO;

public interface ICicloDAO {

	public CicloDTO consultarCicloPorId(Integer id, Connection con) throws Exception;

	public String actualizarCiclo(CicloDTO cicloDTO, Connection con) throws Exception;

	public String crearCiclo(CicloDTO cicloDTO,Connection con) throws Exception;

	public String borrarCiclo(Integer id, Connection con) throws Exception;
	
	public List<CicloDTO> ListarCiclos(Connection con) throws Exception;
}
