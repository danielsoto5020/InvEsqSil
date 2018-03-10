package negocio.siembra;

import java.util.List;

import dto.SiembraDTO;

public interface ISiembraNegocio {
	
	public SiembraDTO consultarSiembraPorId(Integer id);
	
	public Integer stockSiembra(Integer id);

	public String actualizarSiembra(SiembraDTO siembraDTO);

	public String crearSiembra(SiembraDTO siembraDTO);

	public String borrarSiembra(Integer id);
	
	public List<SiembraDTO> ListarSiembras();

}
