package dao.salida;

import java.sql.Connection;
import java.util.List;

import dto.SalidaDTO;

public interface ISalidaDAO {
	
	public SalidaDTO consultarSalidaPorId(Integer id, Connection con) throws Exception;

	public String actualizarSalida(SalidaDTO salidaDTO, Connection con) throws Exception;

	public String crearSalida(SalidaDTO salidaDTO,Connection con) throws Exception;

	public String borrarSalida(Integer id, Connection con) throws Exception;
	
	public List<SalidaDTO> ListarSalidas(Connection con) throws Exception;

}