package dao.salida.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.salida.ISalidaDAO;
import dto.SalidaDTO;
import negocio.empleado.impl.EmpleadoNegocio;
import negocio.ingreso.impl.IngresoNegocio;
import negocio.planta.impl.PlantaNegocio;
import negocio.salida.impl.SalidaNegocio;
import util.PersistUtil;

public class SalidaDAO implements ISalidaDAO{
	
	@Override
	public SalidaDTO consultarSalidaPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		SalidaDTO salidaDTO = null;
		try {
			query = SalidaSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				salidaDTO = new SalidaDTO();
				setInfoSalida(resultado, salidaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return salidaDTO;
	}

	private void setInfoSalida(ResultSet resultado, SalidaDTO salidaDTO) throws Exception {
		
		salidaDTO.setId(resultado.getInt("id_salida"));
		salidaDTO.setCantidad(resultado.getString("cantidad_salida"));
		salidaDTO.setFecha(resultado.getString("fecha_salida"));
		salidaDTO.setVariedad(resultado.getInt("fk_id_planta"));
		salidaDTO.setIngreso(resultado.getInt("fk_id_ingreso"));
		salidaDTO.setEmpleado(resultado.getInt("fk_id_empleado"));
	}

	private Boolean buscarIngreso(Integer id) {
		IngresoNegocio ingresoNegocio = new IngresoNegocio();
		if (ingresoNegocio.consultarIngresoPorId(id) != null) {
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

	private Boolean buscarSalida(Integer id) {
		SalidaNegocio salidaNegocio = new SalidaNegocio();
		if (salidaNegocio.consultarSalidaPorId(id) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String actualizarSalida(SalidaDTO salidaDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message = "";
		String query;
		if (buscarSalida(salidaDTO.getId())) {
			try {
				query = SalidaSQL.UPDATE;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, salidaDTO.getCantidad());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(salidaDTO.getFecha()));
				instruccion.setInt(index++, salidaDTO.getVariedad());
				instruccion.setInt(index++, salidaDTO.getIngreso());
				instruccion.setInt(index++, salidaDTO.getEmpleado());
				instruccion.setInt(index++, salidaDTO.getId());
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
	public String crearSalida(SalidaDTO salidaDTO, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		if (buscarIngreso(salidaDTO.getIngreso()) && buscarEmpleado(salidaDTO.getEmpleado()) && buscarPlanta(salidaDTO.getVariedad())) {
			try {

				query = SalidaSQL.INSERT;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, salidaDTO.getCantidad());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(salidaDTO.getFecha()));
				instruccion.setInt(index++, salidaDTO.getVariedad());
				instruccion.setInt(index++, salidaDTO.getEmpleado());
				instruccion.setInt(index++, salidaDTO.getIngreso());
				
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
			message = "verifica los datos de Cama, Empleado y Variedad";
		}
		return message;
	}

	@Override
	public String borrarSalida(Integer id, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		try {
			query = SalidaSQL.DELETE;
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
	public List<SalidaDTO> ListarSalidas(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		SalidaDTO salidaDTO = null;
		List<SalidaDTO> listaSalidas = new ArrayList<>();
		try {
			query = SalidaSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				salidaDTO = new SalidaDTO();
				setInfoSalida(resultado, salidaDTO);
				listaSalidas.add(salidaDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaSalidas;
	}
	
	public List<SalidaDTO> ListaSalida(String cantidad, String variedad, Connection con) throws Exception{
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		SalidaDTO salidaDTO = null;
		List<SalidaDTO> listado = new ArrayList<>();
		try {
			query = SalidaSQL.FIND_LAST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while(resultado.next()) {
				salidaDTO = new SalidaDTO();
				setInfoSalida(resultado, salidaDTO);
				
				listado.add(salidaDTO);
			}
		} finally{
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listado;
	}

}
