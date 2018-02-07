package negocio.bloque;

import java.util.List;

import dto.BloqueDTO;

public interface IBloqueNegocio {
	
	public BloqueDTO consultarBloquePorId(Integer id);

	public String actualizarBloque(BloqueDTO bloqueDTO);

	public String crearBloque(BloqueDTO bloqueDTO);

	public String borrarBloque(Integer id);
	
	public List<BloqueDTO> ListarBloques();

}
