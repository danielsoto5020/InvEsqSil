package negocio.auditoria;

import java.util.List;

import dto.AuditoriaDTO;

public interface IAuditoriaNegocio {
	
	public AuditoriaDTO consultarAuditoriaPorId(Integer id);

	public String actualizarAuditoria(AuditoriaDTO auditoriaDTO);

	public String crearAuditoria(AuditoriaDTO auditoriaDTO);

	public String borrarAuditoria(Integer id);
	
	public List<AuditoriaDTO> ListarAuditorias();
}
