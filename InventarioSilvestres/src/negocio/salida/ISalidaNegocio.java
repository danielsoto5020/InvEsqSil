package negocio.salida;

import java.util.List;

import dto.SalidaDTO;

public interface ISalidaNegocio {
	
	public SalidaDTO consultarSalidaPorId(Integer id);

	public String actualizarSalida(SalidaDTO salidaDTO);

	public String crearSalida(SalidaDTO salidaDTO);

	public String borrarSalida(Integer id);
	
	public List<SalidaDTO> ListarSalidas();


}
