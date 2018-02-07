package dao.tipo;

import java.sql.Connection;
import java.util.List;

import dto.TipoDTO;


public interface ITipoDAO {
	
	
	public TipoDTO consultarTipoPorId(Integer id, Connection con) throws Exception;

	public String actualizarTipo(TipoDTO tipoDTO, Connection con) throws Exception;

	public String crearTipo(TipoDTO tipoDTO,Connection con) throws Exception;

	public String borrarTipo(Integer id, Connection con) throws Exception;
	
	public List<TipoDTO> ListarTipos(Connection con) throws Exception;


}
