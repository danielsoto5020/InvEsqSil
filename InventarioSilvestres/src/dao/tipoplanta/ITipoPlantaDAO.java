package dao.tipoplanta;

import java.sql.Connection;
import java.util.List;

import dto.TipoPlantaDTO;


public interface ITipoPlantaDAO {
	
	public TipoPlantaDTO consultarTipoPlantaPorId(Integer id, Connection con) throws Exception;

	public String actualizarTipoPlanta(TipoPlantaDTO tipoPlantaDTO, Connection con) throws Exception;

	public String crearTipoPlanta(TipoPlantaDTO tipoPlantaDTO,Connection con) throws Exception;

	public String borrarTipoPlanta(Integer id, Connection con) throws Exception;
	
	public List<TipoPlantaDTO> ListarTipoPlantas(Connection con) throws Exception;

}
