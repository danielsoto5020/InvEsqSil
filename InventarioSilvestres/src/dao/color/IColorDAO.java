package dao.color;

import java.sql.Connection;
import java.util.List;

import dto.ColorDTO;

public interface IColorDAO {
	
	public ColorDTO consultarColorPorId(Integer id, Connection con) throws Exception;

	public String actualizarColor(ColorDTO colorDTO, Connection con) throws Exception;

	public String crearColor(ColorDTO colorDTO,Connection con) throws Exception;

	public String borrarColor(Integer id, Connection con) throws Exception;
	
	public List<ColorDTO> ListarColors(Connection con) throws Exception;

}
