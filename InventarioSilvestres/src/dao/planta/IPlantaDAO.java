package dao.planta;

import java.sql.Connection;
import java.util.List;

import dto.PlantaDTO;
public interface IPlantaDAO {

	public PlantaDTO consultarPlantaPorId(Integer id, Connection con) throws Exception;
	
	public PlantaDTO buscarPlantaId(Integer id, Connection con) throws Exception;

	public String actualizarPlanta(PlantaDTO personaDTO, Connection con) throws Exception;

	public String crearPlanta(PlantaDTO plantaDTO,Connection con) throws Exception;

	public String borrarPlanta(Integer id, Connection con) throws Exception;
	
	public List<PlantaDTO> ListarPlantas(Connection con) throws Exception;

}