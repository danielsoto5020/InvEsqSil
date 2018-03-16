package negocio.origen;

import java.util.List;

import dto.OrigenDTO;

public interface IOrigenNegocio {

	public OrigenDTO consultarOrigenPorId(Integer id);

	public String actualizarOrigen(OrigenDTO origenDTO);

	public String crearOrigen(OrigenDTO origenDTO);

	public String borrarOrigen(Integer id);

	public Integer obtenerOrigen(String nombre);
	
	public List<OrigenDTO> ListarOrigens();

}
