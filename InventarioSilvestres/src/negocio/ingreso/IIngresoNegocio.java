package negocio.ingreso;

import java.util.List;

import dto.IngresoDTO;


public interface IIngresoNegocio {
	
	public IngresoDTO consultarIngresoPorId(Integer id);

	public String actualizarIngreso(IngresoDTO ingresoDTO);

	public String crearIngreso(IngresoDTO ingresoDTO);

	public String borrarIngreso(Integer id);
	
	public List<IngresoDTO> ListarIngresos();


}
