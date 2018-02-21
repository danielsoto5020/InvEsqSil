package dao.cosecha;

import java.sql.Connection;
import java.util.List;

import dto.CosechaDTO;

public interface ICosechaDAO {
	
	public CosechaDTO consultarCosechaPorId(Integer id, Connection con) throws Exception;

	public String actualizarCosecha(CosechaDTO cosechaDTO, Connection con) throws Exception;

	public String crearCosecha(CosechaDTO cosechaDTO,Connection con) throws Exception;

	public String borrarCosecha(Integer id, Connection con) throws Exception;
	
	public List<CosechaDTO> ListarCosechas(Connection con) throws Exception;

}
