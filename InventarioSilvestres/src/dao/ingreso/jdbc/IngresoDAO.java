package dao.ingreso.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ingreso.IIngresoDAO;
import dto.IngresoDTO;
import negocio.cama.impl.CamaNegocio;
import negocio.empleado.impl.EmpleadoNegocio;
import negocio.ingreso.impl.IngresoNegocio;
import negocio.planta.impl.PlantaNegocio;
import negocio.siembra.impl.SiembraNegocio;
import util.PersistUtil;

public class IngresoDAO implements IIngresoDAO {

	@Override
	public IngresoDTO consultarIngresoPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		IngresoDTO ingresoDTO = null;
		try {
			query = IngresoSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				ingresoDTO = new IngresoDTO();
				setInfoIngreso(resultado, ingresoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return ingresoDTO;
	}

	private void setInfoIngreso(ResultSet resultado, IngresoDTO ingresoDTO) throws Exception {
		ingresoDTO.setId(resultado.getInt("id_ingreso"));
		ingresoDTO.setCantidad(resultado.getString("cantidad_ingreso"));
		ingresoDTO.setPuesto(resultado.getString("puesto_ingreso"));
		ingresoDTO.setNivel(resultado.getString("nivel_ingreso"));
		ingresoDTO.setLado(resultado.getString("lado_ingreso"));
		ingresoDTO.setFecha(resultado.getString("fecha_ingreso"));
		ingresoDTO.setVariedad(resultado.getInt("fk_id_cama"));
		ingresoDTO.setCama(resultado.getInt("fk_id_planta"));
		ingresoDTO.setEmpleado(resultado.getInt("fk_id_empleado"));
	}

	private Boolean buscarCama(Integer cama) {
		CamaNegocio camaNegocio = new CamaNegocio();
		if (camaNegocio.consultarCamaPorId(cama) != null) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean buscarEmpleado(Integer id) {
		EmpleadoNegocio empleadoNegocio = new EmpleadoNegocio();
		if (empleadoNegocio.consultarEmpleadoPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean buscarPlanta(Integer id) {
		PlantaNegocio plantaNegocio = new PlantaNegocio();
		if (plantaNegocio.consultarPlantaPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean buscarSiembra(Integer id) {
		SiembraNegocio siembraNegocio = new SiembraNegocio();
		if (siembraNegocio.consultarSiembraPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	private Boolean buscarIngreso(Integer id) {
		IngresoNegocio ingresoNegocio = new IngresoNegocio();
		if (ingresoNegocio.consultarIngresoPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String actualizarIngreso(IngresoDTO ingresoDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message = "";
		String query;
		if (buscarIngreso(ingresoDTO.getId())) {
			try {

				query = IngresoSQL.UPDATE;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, ingresoDTO.getCantidad());
				instruccion.setString(index++, ingresoDTO.getPuesto());
				instruccion.setString(index++, ingresoDTO.getNivel());
				instruccion.setString(index++, ingresoDTO.getLado());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(ingresoDTO.getFecha()));
				instruccion.setInt(index++, ingresoDTO.getVariedad());
				instruccion.setInt(index++, ingresoDTO.getCama());
				instruccion.setInt(index++, ingresoDTO.getEmpleado());
				instruccion.setInt(index++, ingresoDTO.getSiembra());
				instruccion.setInt(index++, ingresoDTO.getId());
				instruccion.executeUpdate();
				message = "OK";
			} catch (SQLException sql) {
				message = "ERROR";
				con.rollback();
				throw new Exception(sql.toString());
			} finally {
				PersistUtil.closeResources(instruccion);
			}
		} else {
			message = "La siembra no se encuentra en la Base de Datos!!!";
		}
		return message;
	}

	@Override
	public String crearIngreso(IngresoDTO ingresoDTO, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		if (buscarCama(ingresoDTO.getCama()) && buscarEmpleado(ingresoDTO.getEmpleado())
				&& buscarPlanta(ingresoDTO.getVariedad()) && buscarSiembra(ingresoDTO.getSiembra())) {
			try {

				query = IngresoSQL.INSERT;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, ingresoDTO.getCantidad());
				instruccion.setString(index++, ingresoDTO.getPuesto());
				instruccion.setString(index++, ingresoDTO.getNivel());
				instruccion.setString(index++, ingresoDTO.getLado());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(ingresoDTO.getFecha()));
				instruccion.setInt(index++, ingresoDTO.getVariedad());
				instruccion.setInt(index++, ingresoDTO.getCama());
				instruccion.setInt(index++, ingresoDTO.getEmpleado());
				instruccion.setInt(index++, ingresoDTO.getSiembra());
				instruccion.executeUpdate();
				message = "OK";
			} catch (SQLException sql) {
				message = " ERROR";
				con.rollback();
				throw new Exception(sql.toString());
			} finally {
				PersistUtil.closeResources(instruccion);
			}
		} else {
			message = "los datos ingresados pueden no esta registrados en la base de datos!!!";
		}
		return message;
	}

	@Override
	public String borrarIngreso(Integer id, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		try {
			query = IngresoSQL.DELETE;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			instruccion.executeUpdate();
			message = "OK";
		} catch (SQLException sql) {
			message = "ERROR";
			con.rollback();
			throw new Exception(sql.toString());
		} finally {
			PersistUtil.closeResources(instruccion);
		}
		return message;
	}

	@Override
	public List<IngresoDTO> ListarIngresos(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		IngresoDTO ingresoDTO = null;
		List<IngresoDTO> listaIngresos = new ArrayList<>();
		try {
			query = IngresoSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				ingresoDTO = new IngresoDTO();
				setInfoIngreso(resultado, ingresoDTO);
				listaIngresos.add(ingresoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaIngresos;
	}

}
