package negocio.tipo;

import java.util.List;

import dto.TipoDTO;

public interface ITipoNegocio {
	
	public TipoDTO consultarTipoPorId(Integer id);

	public String actualizarTipo(TipoDTO tipoDTO);

	public String crearTipo(TipoDTO tipoDTO);

	public String borrarTipo(Integer id);
	
	public List<TipoDTO> ListarTipos();


}
