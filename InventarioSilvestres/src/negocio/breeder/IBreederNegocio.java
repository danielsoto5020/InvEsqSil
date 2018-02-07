package negocio.breeder;

import java.util.List;

import dto.BreederDTO;

public interface IBreederNegocio {
	
	public BreederDTO consultarBreederPorId(Integer id);

	public String actualizarBreeder(BreederDTO breederDTO);

	public String crearBreeder(BreederDTO breederDTO);

	public String borrarBreeder(Integer id);
	
	public List<BreederDTO> ListarBreeders();

}
