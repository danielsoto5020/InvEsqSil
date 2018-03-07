package negocio.planta;

import java.util.List;

import dto.PlantaDTO;

public interface IPlantaNegocio {

	public PlantaDTO consultarPlantaPorId(Integer id);

	public String actualizarPlanta(PlantaDTO plantaDTO);

	public String crearPlanta(PlantaDTO plantaDTO);

	public String borrarPlanta(Integer id);
	
	public List<PlantaDTO> ListarPlantas();
	
}
