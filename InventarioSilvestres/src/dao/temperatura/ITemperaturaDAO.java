package dao.temperatura;

import java.sql.Connection;
import java.util.List;

import dto.TemperaturaDTO;

public interface ITemperaturaDAO {
	
	public TemperaturaDTO consultarTemperaturaPorId(Integer id, Connection con) throws Exception;

	public String actualizarTemperatura(TemperaturaDTO temperaturaDTO, Connection con) throws Exception;

	public String crearTemperatura(TemperaturaDTO temperaturaDTO,Connection con) throws Exception;

	public String borrarTemperatura(Integer id, Connection con) throws Exception;
	
	public List<TemperaturaDTO> ListarTemperaturas(Connection con) throws Exception;

}
