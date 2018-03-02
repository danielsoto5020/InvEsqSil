package negocio.cama;

import java.util.List;

import dto.CamaDTO;

public interface ICamaNegocio {
	
	public CamaDTO consultarCamaPorId(Integer id);

	public String actualizarCama(CamaDTO camaDTO);

	public String crearCama(CamaDTO camaDTO);

	public String borrarCama(Integer id);
	
	public List<CamaDTO> ListarCamas();
	
	public CamaDTO consultarEspacio (Integer cantidad);

}
