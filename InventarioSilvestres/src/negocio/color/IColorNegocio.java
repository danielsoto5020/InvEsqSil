package negocio.color;

import java.util.List;

import dto.ColorDTO;

public interface IColorNegocio {
	
	public ColorDTO consultarColorPorId(Integer id);

	public String actualizarColor(ColorDTO colorDTO);

	public String crearColor(ColorDTO colorDTO);

	public String borrarColor(Integer id);
	
	public List<ColorDTO> ListarColors();

}
