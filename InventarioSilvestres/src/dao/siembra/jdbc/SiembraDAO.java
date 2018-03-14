package dao.siembra.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.siembra.ISiembraDAO;
import dto.SiembraDTO;
import negocio.cama.impl.CamaNegocio;
import negocio.empleado.impl.EmpleadoNegocio;
import negocio.planta.impl.PlantaNegocio;
import negocio.siembra.impl.SiembraNegocio;
import util.PersistUtil;

public class SiembraDAO implements ISiembraDAO {

	@Override
	public SiembraDTO consultarSiembraPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		SiembraDTO siembraDTO = null;
		try {
			query = SiembraSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				siembraDTO = new SiembraDTO();
				setInfoSiembra(resultado, siembraDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return siembraDTO;
	}
	
	@Override
	public Integer stockSiembra(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		Integer capacidad = 0;
		try {
			query = SiembraSQL.STOCK;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				capacidad = resultado.getInt("sum");
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
			return capacidad;
	}

	private void setInfoSiembra(ResultSet resultado, SiembraDTO siembraDTO) throws Exception {
		siembraDTO.setId(resultado.getInt("id_siembra"));
		siembraDTO.setCantidad(resultado.getString("cantidad_siembra"));
		siembraDTO.setFecha(resultado.getString("fecha_siembra"));
		siembraDTO.setObservacion(resultado.getString("observacion_siembra"));
		siembraDTO.setNcama(resultado.getString("nombre_bloque")+"/"+resultado.getString("numero_cama"));
		siembraDTO.setEsterilizacion(resultado.getString("esterilizacion_cama"));
		siembraDTO.setVariedad(resultado.getInt("fk_id_planta"));
		siembraDTO.setNvariedad(resultado.getString("nombre_planta"));
		siembraDTO.setEmpleado(resultado.getInt("fk_id_empleado"));
		siembraDTO.setNempleado(resultado.getString("nombre_empleado")+" "+resultado.getString("apellido_empleado"));
	}

	private Boolean buscarCama(Integer id) {
		CamaNegocio camaNegocio = new CamaNegocio();
		if (camaNegocio.consultarCamaPorId(id) != null) {
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
	
	private Boolean espacioCama(Integer id, String cantidad) {
		CamaNegocio camaNegocio = new CamaNegocio();
		SiembraNegocio siembraNegocio = new SiembraNegocio();
		Integer asembrar = 0;
		asembrar =  Integer.parseInt(cantidad) + siembraNegocio.stockSiembra(id);
		if (camaNegocio.consultarEspacio(id, asembrar) != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String actualizarSiembra(SiembraDTO siembraDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message = "";
		String query;
		if (buscarSiembra(siembraDTO.getId())) {
			try {

				query = SiembraSQL.UPDATE;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, siembraDTO.getCantidad());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(siembraDTO.getFecha()));
				instruccion.setString(index++, siembraDTO.getObservacion());
				instruccion.setInt(index++, siembraDTO.getVariedad());
				instruccion.setInt(index++, siembraDTO.getCama());
				instruccion.setInt(index++, siembraDTO.getEmpleado());
				instruccion.setInt(index++, siembraDTO.getId());
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
	public String crearSiembra(SiembraDTO siembraDTO, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		if (siembraDTO.getEsterilizacion() == "true" ) {
			CamaNegocio camaNegocio = new CamaNegocio();
			message = camaNegocio.esterilizarCama(siembraDTO.getCama());
		}
		if (buscarCama(siembraDTO.getCama()) 
				&& buscarEmpleado(siembraDTO.getEmpleado())
				&& buscarPlanta(siembraDTO.getVariedad())
				&& espacioCama(siembraDTO.getCama(), siembraDTO.getCantidad())) {
			try {

				query = SiembraSQL.INSERT;
				instruccion = con.prepareStatement(query);
				int index = 1;
				instruccion.setString(index++, siembraDTO.getCantidad());
				instruccion.setTimestamp(index++, PersistUtil.convertStringToDate(siembraDTO.getFecha()));
				instruccion.setString(index++, siembraDTO.getObservacion());
				instruccion.setInt(index++, siembraDTO.getVariedad());
				instruccion.setInt(index++, siembraDTO.getEmpleado());
				instruccion.setInt(index++, siembraDTO.getCama());

				instruccion.executeUpdate();
				message = message + " OK";
			} catch (SQLException sql) {
				message = " ERROR";
				con.rollback();
				throw new Exception(sql.toString());
			} finally {
				PersistUtil.closeResources(instruccion);
			}
		} else {
			if (!buscarCama(siembraDTO.getCama())) {
				message = "La cama ingresada no existe";
			}else if (!buscarEmpleado(siembraDTO.getEmpleado())) {
				message = "El empleado no existe";
			}else if (!buscarPlanta(siembraDTO.getVariedad())) {
				message = "La variedad no existe en la Base de datos";
			}else if (!espacioCama(siembraDTO.getCama(), siembraDTO.getCantidad())) {
				message = "La cama no tiene espacio suficiente";
			}else {
				message = "Datos ingresados erroneos";
			}
		}
		return message;
	}

	@Override
	public String borrarSiembra(Integer id, Connection con) throws Exception {
		String message = "";
		String query;
		PreparedStatement instruccion = null;
		try {
			query = SiembraSQL.DELETE;
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
	public List<SiembraDTO> ListarSiembras(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		SiembraDTO siembraDTO = null;
		List<SiembraDTO> listaSiembras = new ArrayList<>();
		try {
			query = SiembraSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				siembraDTO = new SiembraDTO();
				setInfoSiembra(resultado, siembraDTO);
				listaSiembras.add(siembraDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaSiembras;
	}

}
