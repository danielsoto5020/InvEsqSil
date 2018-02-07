package dao.finca;

import java.sql.Connection;
import java.util.List;

import dto.FincaDTO;


public interface IFincaDAO {
	
	public FincaDTO consultarFincaPorId(Integer id, Connection con) throws Exception;

	public String actualizarFinca(FincaDTO fincaDTO, Connection con) throws Exception;

	public String crearFinca(FincaDTO fincaDTO,Connection con) throws Exception;

	public String borrarFinca(Integer id, Connection con) throws Exception;
	
	public List<FincaDTO> ListarFincas(Connection con) throws Exception;


}
