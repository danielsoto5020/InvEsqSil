package dao.auditoria.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.auditoria.IAuditoriaDAO;
import dto.AuditoriaDTO;
import negocio.auditoria.impl.AuditoriaNegocio;
import util.PersistUtil;

public class AuditoriaDAO implements IAuditoriaDAO {

	@Override
	public AuditoriaDTO consultarAuditoriaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		AuditoriaDTO auditoriaDTO = null;
		try {
			query = AuditoriaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				auditoriaDTO = new AuditoriaDTO();
				setInfoAuditoria(resultado, auditoriaDTO);
			}
			if(auditoriaDTO.getOperacion() == "I"){//aqui voy
				
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return auditoriaDTO;
	}

	private void setInfoAuditoria(ResultSet resultado, AuditoriaDTO auditoriaDTO) throws Exception {
		auditoriaDTO.setId(resultado.getInt("id_auditoria"));
		auditoriaDTO.setTabla(resultado.getString("tabla_auditoria"));
		auditoriaDTO.setOperacion(resultado.getString("operacion_auditoria"));
		auditoriaDTO.setOldvalor(resultado.getString("old_valor_auditoria"));
		auditoriaDTO.setNewvalor(resultado.getString("new_valor_auditoria"));
		auditoriaDTO.setFecha(resultado.getString("fecha_auditoria"));
		auditoriaDTO.setUsuario(resultado.getString("usuario_auditoria"));
	}

	private Boolean buscarAuditoria(Integer id) {
		AuditoriaNegocio auditoriaNegocio = new AuditoriaNegocio();
		if (auditoriaNegocio.consultarAuditoriaPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String actualizarAuditoria(AuditoriaDTO auditoriaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message = "";
		String query;
		if (buscarAuditoria(auditoriaDTO.getId())) {
			try {
				query = AuditoriaSQL.UPDATE;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, auditoriaDTO.getTabla());
				instruccion.setString(index++, auditoriaDTO.getOperacion());
				instruccion.setString(index++, auditoriaDTO.getOldvalor());
				instruccion.setString(index++, auditoriaDTO.getNewvalor());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(auditoriaDTO.getFecha()));
				instruccion.setString(index++, auditoriaDTO.getUsuario());
				instruccion.setInt(index++, auditoriaDTO.getId());
				instruccion.executeUpdate();
				message = "OK";
			} catch (SQLException sql) {
				message = "ERROR";
				con.rollback();
				throw new Exception(sql.toString());
			} finally {
				PersistUtil.closeResources(instruccion);
			}
		} else {
			message = "La auditoria no se encuentra en la Base de Datos!!!";
		}
		return message;
	}

	@Override
	public String crearAuditoria(AuditoriaDTO auditoriaDTO, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		try {
			query = AuditoriaSQL.INSERT;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setString(index++, auditoriaDTO.getTabla());
			instruccion.setString(index++, auditoriaDTO.getOperacion());
			instruccion.setString(index++, auditoriaDTO.getOldvalor());
			instruccion.setString(index++, auditoriaDTO.getNewvalor());
			instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(auditoriaDTO.getFecha()));
			instruccion.setString(index++, auditoriaDTO.getUsuario());
			instruccion.executeUpdate();
			message = "OK";
		} catch (SQLException sql) {
			message = " ERROR";
			con.rollback();
			throw new Exception(sql.toString());
		} finally {
			PersistUtil.closeResources(instruccion);
		}
		return message;
	}

	@Override
	public String borrarAuditoria(Integer id, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		try {
			query = AuditoriaSQL.DELETE;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			instruccion.executeUpdate();
			message = "OK";
		} catch (SQLException sql) {
			message = "ERROR";
			con.rollback();
			throw new Exception(sql.toString());
		} finally {
			PersistUtil.closeResources(instruccion);
		}
		return message;
	}

	@Override
	public List<AuditoriaDTO> ListarAuditorias(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		AuditoriaDTO auditoriaDTO = null;
		List<AuditoriaDTO> listaAuditorias = new ArrayList<>();
		try {
			query = AuditoriaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				auditoriaDTO = new AuditoriaDTO();
				setInfoAuditoria(resultado, auditoriaDTO);
				listaAuditorias.add(auditoriaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaAuditorias;
	}

}
