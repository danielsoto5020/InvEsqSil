package negocio.tipoplanta;

import java.util.List;

import dto.TipoPlantaDTO;

public interface ITipoPlantaNegocio {

	public TipoPlantaDTO consultarTipoPlantaPorId(Integer id);

	public String actualizarTipoPlanta(TipoPlantaDTO tipoDTO);

	public String crearTipoPlanta(TipoPlantaDTO tipoDTO);

	public String borrarTipoPlanta(Integer id);
	
	public List<TipoPlantaDTO> ListarTipoPlantas();

}
