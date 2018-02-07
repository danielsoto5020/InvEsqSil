package negocio.finca;

import java.util.List;

import dto.FincaDTO;

public interface IFincaNegocio {
	
	public FincaDTO consultarFincaPorId(Integer id);

	public String actualizarFinca(FincaDTO fincaDTO);

	public String crearFinca(FincaDTO fincaDTO);

	public String borrarFinca(Integer id);
	
	public List<FincaDTO> ListarFincas();


}
