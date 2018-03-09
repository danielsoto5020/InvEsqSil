package negocio.salida.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.salida.ISalidaDAO;
import dao.salida.jdbc.SalidaDAO;
import dto.SalidaDTO;
import negocio.salida.ISalidaNegocio;
import util.PersistUtil;

public class SalidaNegocio implements ISalidaNegocio{

	private ISalidaDAO salidaDAO;
    private DataSource dataSource;
	
	public SalidaNegocio(){
		dataSource = PersistUtil.getDataSource();
		salidaDAO = new SalidaDAO();
	}
	
	@Override
	public SalidaDTO consultarSalidaPorId(Integer id) {
		Connection con = null;
		SalidaDTO salidaDTO = null;
		try {
			con = dataSource.getConnection();
			salidaDTO= salidaDAO.consultarSalidaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return salidaDTO;
	}

	@Override
	public String actualizarSalida(SalidaDTO salidaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = salidaDAO.actualizarSalida(salidaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearSalida(SalidaDTO salidaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = salidaDAO.crearSalida(salidaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarSalida(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = salidaDAO.borrarSalida(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<SalidaDTO> ListarSalidas() {
		Connection con = null;
		List<SalidaDTO> listaSalidas = null;
		try {
			con = dataSource.getConnection();
			listaSalidas = salidaDAO.ListarSalidas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaSalidas;
	}
}
