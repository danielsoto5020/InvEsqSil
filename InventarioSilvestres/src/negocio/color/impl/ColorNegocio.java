package negocio.color.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.color.IColorDAO;
import dao.color.jdbc.ColorDAO;
import dto.ColorDTO;
import negocio.color.IColorNegocio;
import util.PersistUtil;

public class ColorNegocio implements IColorNegocio{
	
	private IColorDAO colorDAO;
    private DataSource dataSource;
	
	public ColorNegocio(){
		dataSource = PersistUtil.getDataSource();
		colorDAO = new ColorDAO();
	}
	
	@Override
	public ColorDTO consultarColorPorId(Integer id) {
		Connection con = null;
		ColorDTO colorDTO = null;
		try {
			con = dataSource.getConnection();
			colorDTO= colorDAO.consultarColorPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return colorDTO;
	}

	@Override
	public String actualizarColor(ColorDTO colorDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = colorDAO.actualizarColor(colorDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearColor(ColorDTO colorDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = colorDAO.crearColor(colorDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarColor(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = colorDAO.borrarColor(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<ColorDTO> ListarColors() {
		Connection con = null;
		List<ColorDTO> listaColors = null;
		try {
			con = dataSource.getConnection();
			listaColors= colorDAO.ListarColors(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaColors;
	}


}
