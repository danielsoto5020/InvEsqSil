package negocio.origen.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.origen.IOrigenDAO;
import dao.origen.jdbc.OrigenDAO;
import dto.OrigenDTO;
import negocio.origen.IOrigenNegocio;
import util.PersistUtil;

public class OrigenNegocio implements IOrigenNegocio{
	
	private IOrigenDAO origenDAO;
    private DataSource dataSource;
	
	public OrigenNegocio(){
		dataSource = PersistUtil.getDataSource();
		origenDAO = new OrigenDAO();
	}
	
	@Override
	public OrigenDTO consultarOrigenPorId(Integer id) {
		Connection con = null;
		OrigenDTO origenDTO = null;
		try {
			con = dataSource.getConnection();
			origenDTO= origenDAO.consultarOrigenPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return origenDTO;
	}

	@Override
	public String actualizarOrigen(OrigenDTO origenDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = origenDAO.actualizarOrigen(origenDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearOrigen(OrigenDTO origenDTO){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = origenDAO.crearOrigen(origenDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarOrigen(Integer id){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = origenDAO.borrarOrigen(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}
	
	@Override
	public Integer obtenerOrigen(String nombre){
		Connection con = null;
		Integer id = null;
		try {
			con = dataSource.getConnection();
			id = origenDAO.obtenerOrigen(nombre, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return id;
	}

	@Override
	public List<OrigenDTO> ListarOrigens(){
		Connection con = null;
		List<OrigenDTO> listaOrigens = null;
		try {
			con = dataSource.getConnection();
			listaOrigens = origenDAO.ListarOrigens(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaOrigens;
	}
}
