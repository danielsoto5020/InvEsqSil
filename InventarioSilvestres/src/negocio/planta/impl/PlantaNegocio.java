package negocio.planta.impl;

import java.sql.Connection;
import java.util.List;

import javax.sql.DataSource;

import dao.planta.IPlantaDAO;
import dao.planta.jdbc.PlantaDAO;
import dto.PlantaDTO;
import negocio.planta.IPlantaNegocio;
import util.PersistUtil;

public class PlantaNegocio implements IPlantaNegocio {
	
    private IPlantaDAO plantaDAO;
    private DataSource dataSource;
	
	public PlantaNegocio(){
		dataSource = PersistUtil.getDataSource();
		plantaDAO = new PlantaDAO();
	}
	
	@Override
	public PlantaDTO consultarPlantaPorId(Integer id) {
		Connection con = null;
		PlantaDTO plantaDTO = null;
		try {
			con = dataSource.getConnection();
			plantaDTO = plantaDAO.consultarPlantaPorId(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return plantaDTO;
	}
	
	@Override
	public PlantaDTO buscarPlantaId(Integer id) {
		Connection con = null;
		PlantaDTO plantaDTO = null;
		try {
			con = dataSource.getConnection();
			plantaDTO = plantaDAO.buscarPlantaId(id, con);
		} catch (Exception e){
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return plantaDTO;
	}

	@Override
	public String actualizarPlanta(PlantaDTO plantaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = plantaDAO.actualizarPlanta(plantaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String crearPlanta(PlantaDTO plantaDTO) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = plantaDAO.crearPlanta(plantaDTO, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public String borrarPlanta(Integer id) {
		Connection con = null;
		String message="";
		try {
			con = dataSource.getConnection();
			message = plantaDAO.borrarPlanta(id, con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return message;
	}

	@Override
	public List<PlantaDTO> ListarPlantas() {
		Connection con = null;
		List<PlantaDTO> listaPlantas = null;
		try {
			con = dataSource.getConnection();
			listaPlantas= plantaDAO.ListarPlantas(con);
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			PersistUtil.closeConnection(con);
		}
		return listaPlantas;
	}

}
