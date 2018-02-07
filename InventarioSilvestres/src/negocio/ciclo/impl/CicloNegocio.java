package negocio.ciclo.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.ciclo.ICicloDAO;
import dao.ciclo.jdbc.CicloDAO;
import dto.CicloDTO;
import negocio.ciclo.ICicloNegocio;
import util.PersistUtil;

public class CicloNegocio implements ICicloNegocio{
	
	private ICicloDAO cicloDAO;
    private DataSource dataSource;
	
	public CicloNegocio(){
		dataSource = PersistUtil.getDataSource();
		cicloDAO = new CicloDAO();
	}
	
	@Override
	public CicloDTO consultarCicloPorId(Integer id) {
		Connection con = null;
		CicloDTO cicloDTO = null;
		try {
			con = dataSource.getConnection();
			cicloDTO= cicloDAO.consultarCicloPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return cicloDTO;
	}

	@Override
	public String actualizarCiclo(CicloDTO cicloDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = cicloDAO.actualizarCiclo(cicloDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearCiclo(CicloDTO cicloDTO){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = cicloDAO.crearCiclo(cicloDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarCiclo(Integer id){
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = cicloDAO.borrarCiclo(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<CicloDTO> ListarCiclos(){
		Connection con = null;
		List<CicloDTO> listaCiclos = null;
		try {
			con = dataSource.getConnection();
			listaCiclos= cicloDAO.ListarCiclos(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaCiclos;
	}
}
