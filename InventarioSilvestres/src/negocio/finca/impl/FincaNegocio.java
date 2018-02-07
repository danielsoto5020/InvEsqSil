package negocio.finca.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.finca.IFincaDAO;
import dao.finca.jdbc.FincaDAO;
import dto.FincaDTO;
import negocio.finca.IFincaNegocio;
import util.PersistUtil;

public class FincaNegocio implements IFincaNegocio{
	
	private IFincaDAO fincaDAO;
    private DataSource dataSource;
	
	public FincaNegocio(){
		dataSource = PersistUtil.getDataSource();
		fincaDAO = new FincaDAO();
	}
	
	@Override
	public FincaDTO consultarFincaPorId(Integer id) {
		Connection con = null;
		FincaDTO fincaDTO = null;
		try {
			con = dataSource.getConnection();
			fincaDTO= fincaDAO.consultarFincaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return fincaDTO;
	}

	@Override
	public String actualizarFinca(FincaDTO fincaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = fincaDAO.actualizarFinca(fincaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearFinca(FincaDTO fincaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = fincaDAO.crearFinca(fincaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarFinca(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = fincaDAO.borrarFinca(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<FincaDTO> ListarFincas() {
		Connection con = null;
		List<FincaDTO> listaFincas = null;
		try {
			con = dataSource.getConnection();
			listaFincas= fincaDAO.ListarFincas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaFincas;
	}

}
