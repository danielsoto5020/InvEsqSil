package dao.auditoria;

import java.sql.Connection;
import java.util.List;

import dto.AuditoriaDTO;


public interface IAuditoriaDAO {
	
	public AuditoriaDTO consultarAuditoriaPorId(Integer id, Connection con) throws Exception;

	public String actualizarAuditoria(AuditoriaDTO auditoriaDTO, Connection con) throws Exception;

	public String crearAuditoria(AuditoriaDTO auditoriaDTO,Connection con) throws Exception;

	public String borrarAuditoria(Integer id, Connection con) throws Exception;
	
	public List<AuditoriaDTO> ListarAuditorias(Connection con) throws Exception;

}
