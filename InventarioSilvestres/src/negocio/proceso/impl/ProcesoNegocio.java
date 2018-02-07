package negocio.proceso.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.proceso.IProcesoDAO;
import dao.proceso.jdbc.ProcesoDAO;
import dto.ProcesoDTO;
import negocio.proceso.IProcesoNegocio;
import util.PersistUtil;

public class ProcesoNegocio implements IProcesoNegocio{
	
	private IProcesoDAO procesoDAO;
    private DataSource dataSource;
	
	public ProcesoNegocio(){
		dataSource = PersistUtil.getDataSource();
		procesoDAO = new ProcesoDAO();
	}
	
	@Override
	public ProcesoDTO consultarProcesoPorId(Integer id) {
		Connection con = null;
		ProcesoDTO procesoDTO = null;
		try {
			con = dataSource.getConnection();
			procesoDTO= procesoDAO.consultarProcesoPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return procesoDTO;
	}

	@Override
	public String actualizarProceso(ProcesoDTO procesoDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = procesoDAO.actualizarProceso(procesoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearProceso(ProcesoDTO procesoDTO){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = procesoDAO.crearProceso(procesoDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarProceso(Integer id){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = procesoDAO.borrarProceso(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<ProcesoDTO> ListarProcesos(){
		Connection con = null;
		List<ProcesoDTO> listaProcesos = null;
		try {
			con = dataSource.getConnection();
			listaProcesos= procesoDAO.ListarProcesos(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaProcesos;
	}

}
