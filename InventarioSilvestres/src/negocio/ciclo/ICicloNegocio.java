package negocio.ciclo;

import java.util.List;

import dto.CicloDTO;

public interface ICicloNegocio {
	
	public CicloDTO consultarCicloPorId(Integer id);

	public String actualizarCiclo(CicloDTO cicloDTO);

	public String crearCiclo(CicloDTO cicloDTO);

	public String borrarCiclo(Integer id);
	
	public List<CicloDTO> ListarCiclos();

}
