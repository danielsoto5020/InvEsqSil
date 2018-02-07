package negocio.empleado.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.empleado.IEmpleadoDAO;
import dao.empleado.jdbc.EmpleadoDAO;
import dto.EmpleadoDTO;
import negocio.empleado.IEmpleadoNegocio;
import util.PersistUtil;

public class EmpleadoNegocio implements IEmpleadoNegocio{

	
	private IEmpleadoDAO empleadoDAO;
    private DataSource dataSource;
	
	public EmpleadoNegocio(){
		dataSource = PersistUtil.getDataSource();
		empleadoDAO = new EmpleadoDAO();
	}
	
	@Override
	public EmpleadoDTO consultarEmpleadoPorId(Integer id) {
		Connection con = null;
		EmpleadoDTO empleadoDTO = null;
		try {
			con = dataSource.getConnection();
			empleadoDTO= empleadoDAO.consultarEmpleadoPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return empleadoDTO;
	}

	@Override
	public String actualizarEmpleado(EmpleadoDTO empleadoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = empleadoDAO.actualizarEmpleado(empleadoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearEmpleado(EmpleadoDTO empleadoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = empleadoDAO.crearEmpleado(empleadoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarEmpleado(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = empleadoDAO.borrarEmpleado(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<EmpleadoDTO> ListarEmpleados() {
		Connection con = null;
		List<EmpleadoDTO> listaEmpleados = null;
		try {
			con = dataSource.getConnection();
			listaEmpleados= empleadoDAO.ListarEmpleados(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaEmpleados;
	}

}

