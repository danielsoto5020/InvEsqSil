package negocio.codigorf;

import java.util.List;

import dto.CodigorfDTO;


public interface ICodigorfNegocio {

	
	public CodigorfDTO consultarCodigorfPorId(Integer id);

	public String actualizarCodigorf(CodigorfDTO codigorfDTO);

	public String crearCodigorf(CodigorfDTO codigorfDTO);

	public String borrarCodigorf(Integer id);
	
	public List<CodigorfDTO> ListarCodigorfs();

}
