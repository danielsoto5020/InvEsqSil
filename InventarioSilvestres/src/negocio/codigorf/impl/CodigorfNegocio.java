package negocio.codigorf.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.codigorf.ICodigorfDAO;
import dao.codigorf.jdbc.CodigorfDAO;
import dto.CodigorfDTO;
import negocio.codigorf.ICodigorfNegocio;
import util.PersistUtil;

public class CodigorfNegocio implements ICodigorfNegocio{

	private ICodigorfDAO codigorfDAO;
    private DataSource dataSource;
	
	public CodigorfNegocio(){
		dataSource = PersistUtil.getDataSource();
		codigorfDAO = new CodigorfDAO();
	}
	
	@Override
	public CodigorfDTO consultarCodigorfPorId(Integer id) {
		Connection con = null;
		CodigorfDTO codigorfDTO = null;
		try {
			con = dataSource.getConnection();
			codigorfDTO= codigorfDAO.consultarCodigorfPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return codigorfDTO;
	}

	@Override
	public String actualizarCodigorf(CodigorfDTO codigorfDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = codigorfDAO.actualizarCodigorf(codigorfDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearCodigorf(CodigorfDTO codigorfDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = codigorfDAO.crearCodigorf(codigorfDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarCodigorf(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = codigorfDAO.borrarCodigorf(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<CodigorfDTO> ListarCodigorfs() {
		Connection con = null;
		List<CodigorfDTO> listaCodigorfs = null;
		try {
			con = dataSource.getConnection();
			listaCodigorfs= codigorfDAO.ListarCodigorfs(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaCodigorfs;
	}

}
