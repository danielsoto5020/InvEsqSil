package negocio.cama.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.cama.ICamaDAO;
import dao.cama.jdbc.CamaDAO;
import dto.CamaDTO;
import negocio.cama.ICamaNegocio;
import util.PersistUtil;

public class CamaNegocio implements ICamaNegocio{
	
	private ICamaDAO camaDAO;
    private DataSource dataSource;
	
	public CamaNegocio(){
		dataSource = PersistUtil.getDataSource();
		camaDAO = new CamaDAO();
	}
	
	@Override
	public CamaDTO consultarCamaPorId(Integer id) {
		Connection con = null;
		CamaDTO camaDTO = null;
		try {
			con = dataSource.getConnection();
			camaDTO= camaDAO.consultarCamaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return camaDTO;
	}

	@Override
	public String actualizarCama(CamaDTO camaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = camaDAO.actualizarCama(camaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}
	

	@Override
	public Integer buscarCama(String ncama, String nbloque) {
		Connection con = null;
		Integer valor = null;
		try {
			con = dataSource.getConnection();
			valor = camaDAO.buscarCama(ncama, nbloque, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return valor;
		
	}

	@Override
	public String crearCama(CamaDTO camaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = camaDAO.crearCama(camaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarCama(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = camaDAO.borrarCama(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<CamaDTO> ListarCamas() {
		Connection con = null;
		List<CamaDTO> listaCamas = null;
		try {
			con = dataSource.getConnection();
			listaCamas= camaDAO.ListarCamas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaCamas;
	}

	@Override
	public List<CamaDTO> SelectCamas() {
		Connection con = null;
		List<CamaDTO> listaCamas = null;
		try {
			con = dataSource.getConnection();
			listaCamas= camaDAO.ListarCamas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaCamas;
	}

	@Override
	public CamaDTO consultarEspacio(Integer id, String cantidad) {
		Connection con = null;
		CamaDTO camaDTO = null;
		try {
			con = dataSource.getConnection();
			camaDTO= camaDAO.consultarEspacio(id, cantidad, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return camaDTO;
		
	}

}
