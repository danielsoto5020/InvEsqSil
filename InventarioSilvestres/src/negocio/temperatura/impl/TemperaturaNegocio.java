package negocio.temperatura.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;


import dao.temperatura.ITemperaturaDAO;
import dao.temperatura.jdbc.TemperaturaDAO;
import dto.TemperaturaDTO;
import negocio.temperatura.ITemperaturaNegocio;
import util.PersistUtil;

public class TemperaturaNegocio implements ITemperaturaNegocio{
	
	private ITemperaturaDAO temperaturaDAO;
    private DataSource dataSource;
	
	public TemperaturaNegocio(){
		dataSource = PersistUtil.getDataSource();
		temperaturaDAO = new TemperaturaDAO();
	}
	
	@Override
	public TemperaturaDTO consultarTemperaturaPorId(Integer id) {
		Connection con = null;
		TemperaturaDTO temperaturaDTO = null;
		try {
			con = dataSource.getConnection();
			temperaturaDTO= temperaturaDAO.consultarTemperaturaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return temperaturaDTO;
	}

	@Override
	public String actualizarTemperatura(TemperaturaDTO temperaturaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = temperaturaDAO.actualizarTemperatura(temperaturaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearTemperatura(TemperaturaDTO temperaturaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = temperaturaDAO.crearTemperatura(temperaturaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarTemperatura(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = temperaturaDAO.borrarTemperatura(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<TemperaturaDTO> ListarTemperaturas() {
		Connection con = null;
		List<TemperaturaDTO> listaTemperaturas = null;
		try {
			con = dataSource.getConnection();
			listaTemperaturas= temperaturaDAO.ListarTemperaturas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaTemperaturas;
	}


}
