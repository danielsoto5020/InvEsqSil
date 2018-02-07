package negocio.tipo.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.tipo.ITipoDAO;
import dao.tipo.jdbc.TipoDAO;
import dto.TipoDTO;
import negocio.tipo.ITipoNegocio;
import util.PersistUtil;

public class TipoNegocio implements ITipoNegocio{
	
	private ITipoDAO tipoDAO;
    private DataSource dataSource;
	
	public TipoNegocio(){
		dataSource = PersistUtil.getDataSource();
		tipoDAO = new TipoDAO();
	}
	
	@Override
	public TipoDTO consultarTipoPorId(Integer id) {
		Connection con = null;
		TipoDTO tipoDTO = null;
		try {
			con = dataSource.getConnection();
			tipoDTO= tipoDAO.consultarTipoPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return tipoDTO;
	}

	@Override
	public String actualizarTipo(TipoDTO tipoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = tipoDAO.actualizarTipo(tipoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearTipo(TipoDTO tipoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = tipoDAO.crearTipo(tipoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarTipo(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = tipoDAO.borrarTipo(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<TipoDTO> ListarTipos() {
		Connection con = null;
		List<TipoDTO> listaTipos = null;
		try {
			con = dataSource.getConnection();
			listaTipos= tipoDAO.ListarTipos(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaTipos;
	}
}
