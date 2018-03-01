package negocio.auditoria.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.auditoria.IAuditoriaDAO;
import dao.auditoria.jdbc.AuditoriaDAO;
import dto.AuditoriaDTO;
import negocio.auditoria.IAuditoriaNegocio;
import util.PersistUtil;

public class AuditoriaNegocio implements IAuditoriaNegocio{
	
	private IAuditoriaDAO auditoriaDAO;
    private DataSource dataSource;
	
	public AuditoriaNegocio(){
		dataSource = PersistUtil.getDataSource();
		auditoriaDAO = new AuditoriaDAO();
	}
	
	@Override
	public AuditoriaDTO consultarAuditoriaPorId(Integer id) {
		Connection con = null;
		AuditoriaDTO bloqueDTO = null;
		try {
			con = dataSource.getConnection();
			bloqueDTO= auditoriaDAO.consultarAuditoriaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return bloqueDTO;
	}

	@Override
	public String actualizarAuditoria(AuditoriaDTO auditoriaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = auditoriaDAO.actualizarAuditoria(auditoriaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearAuditoria(AuditoriaDTO auditoriaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = auditoriaDAO.crearAuditoria(auditoriaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarAuditoria(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = auditoriaDAO.borrarAuditoria(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<AuditoriaDTO> ListarAuditorias() {
		Connection con = null;
		List<AuditoriaDTO> listaAuditorias = null;
		try {
			con = dataSource.getConnection();
			listaAuditorias= auditoriaDAO.ListarAuditorias(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaAuditorias;
	}
}
