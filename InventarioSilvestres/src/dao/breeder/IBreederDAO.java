package dao.breeder;

import java.sql.Connection;
import java.util.List;

import dto.BreederDTO;

public interface IBreederDAO {
	
	public BreederDTO consultarBreederPorId(Integer id, Connection con) throws Exception;

	public String actualizarBreeder(BreederDTO breederDTO, Connection con) throws Exception;

	public String crearBreeder(BreederDTO breederDTO,Connection con) throws Exception;

	public String borrarBreeder(Integer id, Connection con) throws Exception;
	
	public List<BreederDTO> ListarBreeders(Connection con) throws Exception;

}
