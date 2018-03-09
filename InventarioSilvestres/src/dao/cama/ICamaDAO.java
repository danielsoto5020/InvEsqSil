package dao.cama;

import java.sql.Connection;
import java.util.List;

import dto.CamaDTO;

public interface ICamaDAO {
	
	public CamaDTO consultarCamaPorId(Integer id, Connection con) throws Exception;

	public String actualizarCama(CamaDTO camaDTO, Connection con) throws Exception;

	public String crearCama(CamaDTO camaDTO,Connection con) throws Exception;

	public String borrarCama(Integer id, Connection con) throws Exception;
	
	public Integer buscarCama(String ncama, String nbloque, Connection con) throws Exception;
	
	public List<CamaDTO> SelectCamas(Connection con) throws Exception;
	
	public List<CamaDTO> ListarCamas(Connection con) throws Exception;

	public CamaDTO consultarEspacio(Integer id, String cantidad, Connection con) throws Exception;

}
