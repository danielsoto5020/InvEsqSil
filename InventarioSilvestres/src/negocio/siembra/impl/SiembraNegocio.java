package negocio.siembra.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.siembra.ISiembraDAO;
import dao.siembra.jdbc.SiembraDAO;
import dto.SiembraDTO;
import negocio.siembra.ISiembraNegocio;
import util.PersistUtil;

public class SiembraNegocio implements ISiembraNegocio{
	
	
	private ISiembraDAO siembraDAO;
    private DataSource dataSource;
	
	public SiembraNegocio(){
		dataSource = PersistUtil.getDataSource();
		siembraDAO = new SiembraDAO();
	}
	
	@Override
	public SiembraDTO consultarSiembraPorId(Integer id) {
		Connection con = null;
		SiembraDTO siembraDTO = null;
		try {
			con = dataSource.getConnection();
			siembraDTO= siembraDAO.consultarSiembraPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return siembraDTO;
	}

	@Override
	public String actualizarSiembra(SiembraDTO siembraDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = siembraDAO.actualizarSiembra(siembraDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearSiembra(SiembraDTO siembraDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = siembraDAO.crearSiembra(siembraDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarSiembra(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = siembraDAO.borrarSiembra(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<SiembraDTO> ListarSiembras() {
		Connection con = null;
		List<SiembraDTO> listaSiembras = null;
		try {
			con = dataSource.getConnection();
			listaSiembras= siembraDAO.ListarSiembras(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaSiembras;
	}

	@Override
	public Integer stockSiembra(Integer id) {
		Connection con = null;
		Integer capacidad = 0;
		try {
			con = dataSource.getConnection();
			capacidad = siembraDAO.stockSiembra(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}		
		return  capacidad;
	}


}
