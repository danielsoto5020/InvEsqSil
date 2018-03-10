package dao.siembra;

import java.sql.Connection;
import java.util.List;

import dto.SiembraDTO;

public interface ISiembraDAO {
	
	public SiembraDTO consultarSiembraPorId(Integer id, Connection con) throws Exception;
	
	public Integer stockSiembra(Integer id, Connection con) throws Exception;

	public String actualizarSiembra(SiembraDTO siembraDTO, Connection con) throws Exception;

	public String crearSiembra(SiembraDTO siembraDTO,Connection con) throws Exception;

	public String borrarSiembra(Integer id, Connection con) throws Exception;
	
	public List<SiembraDTO> ListarSiembras(Connection con) throws Exception;

}
