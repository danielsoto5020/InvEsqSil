package negocio.breeder.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.breeder.IBreederDAO;
import dao.breeder.jdbc.BreederDAO;
import dto.BreederDTO;
import negocio.breeder.IBreederNegocio;
import util.PersistUtil;

public class BreederNegocio implements IBreederNegocio {
	
	private IBreederDAO breederDAO;
    private DataSource dataSource;
	
	public BreederNegocio(){
		dataSource = PersistUtil.getDataSource();
		breederDAO = new BreederDAO();
	}
	
	@Override
	public BreederDTO consultarBreederPorId(Integer id) {
		Connection con = null;
		BreederDTO breederDTO = null;
		try {
			con = dataSource.getConnection();
			breederDTO= breederDAO.consultarBreederPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return breederDTO;
	}

	@Override
	public String actualizarBreeder(BreederDTO breederDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = breederDAO.actualizarBreeder(breederDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearBreeder(BreederDTO breederDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = breederDAO.crearBreeder(breederDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarBreeder(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = breederDAO.borrarBreeder(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<BreederDTO> ListarBreeders() {
		Connection con = null;
		List<BreederDTO> listaBreeders = null;
		try {
			con = dataSource.getConnection();
			listaBreeders= breederDAO.ListarBreeders(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaBreeders;
	}

}
