package negocio.proceso;

import java.util.List;

import dto.ProcesoDTO;

public interface IProcesoNegocio {
	
	public ProcesoDTO consultarProcesoPorId(Integer id);

	public String actualizarProceso(ProcesoDTO procesoDTO);

	public String crearProceso(ProcesoDTO procesoDTO);

	public String borrarProceso(Integer id);
	
	public List<ProcesoDTO> ListarProcesos();

}
