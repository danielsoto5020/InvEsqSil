package negocio.temperatura;

import java.util.List;

import dto.TemperaturaDTO;

public interface ITemperaturaNegocio {
	
	public TemperaturaDTO consultarTemperaturaPorId(Integer id);

	public String actualizarTemperatura(TemperaturaDTO temperaturaDTO);

	public String crearTemperatura(TemperaturaDTO temperaturaDTO);

	public String borrarTemperatura(Integer id);
	
	public List<TemperaturaDTO> ListarTemperaturas();

}
