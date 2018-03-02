package negocio.ingreso.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.ingreso.IIngresoDAO;
import dao.ingreso.jdbc.IngresoDAO;
import dto.IngresoDTO;
import negocio.ingreso.IIngresoNegocio;
import util.PersistUtil;

public class IngresoNegocio implements IIngresoNegocio{
	
	private IIngresoDAO ingresoDAO;
    private DataSource dataSource;
	
	public IngresoNegocio(){
		dataSource = PersistUtil.getDataSource();
		ingresoDAO = new IngresoDAO();
	}
	
	@Override
	public IngresoDTO consultarIngresoPorId(Integer id) {
		Connection con = null;
		IngresoDTO ingresoDTO = null;
		try {
			con = dataSource.getConnection();
			ingresoDTO= ingresoDAO.consultarIngresoPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return ingresoDTO;
	}

	@Override
	public String actualizarIngreso(IngresoDTO ingresoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = ingresoDAO.actualizarIngreso(ingresoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearIngreso(IngresoDTO ingresoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = ingresoDAO.crearIngreso(ingresoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarIngreso(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = ingresoDAO.borrarIngreso(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<IngresoDTO> ListarIngresos() {
		Connection con = null;
		List<IngresoDTO> listaIngresos = null;
		try {
			con = dataSource.getConnection();
			listaIngresos= ingresoDAO.ListarIngresos(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaIngresos;
	}

}
