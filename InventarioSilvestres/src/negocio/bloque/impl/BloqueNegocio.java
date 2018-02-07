package negocio.bloque.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.bloque.IBloqueDAO;
import dao.bloque.jdbc.BloqueDAO;
import dto.BloqueDTO;
import negocio.bloque.IBloqueNegocio;
import util.PersistUtil;

public class BloqueNegocio implements IBloqueNegocio{
	
	private IBloqueDAO bloqueDAO;
    private DataSource dataSource;
	
	public BloqueNegocio(){
		dataSource = PersistUtil.getDataSource();
		bloqueDAO = new BloqueDAO();
	}
	
	@Override
	public BloqueDTO consultarBloquePorId(Integer id) {
		Connection con = null;
		BloqueDTO bloqueDTO = null;
		try {
			con = dataSource.getConnection();
			bloqueDTO= bloqueDAO.consultarBloquePorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return bloqueDTO;
	}

	@Override
	public String actualizarBloque(BloqueDTO bloqueDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = bloqueDAO.actualizarBloque(bloqueDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearBloque(BloqueDTO bloqueDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = bloqueDAO.crearBloque(bloqueDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarBloque(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = bloqueDAO.borrarBloque(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<BloqueDTO> ListarBloques() {
		Connection con = null;
		List<BloqueDTO> listaBloques = null;
		try {
			con = dataSource.getConnection();
			listaBloques= bloqueDAO.ListarBloques(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaBloques;
	}

}
