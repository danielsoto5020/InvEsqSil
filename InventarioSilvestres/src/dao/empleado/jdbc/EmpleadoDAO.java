package dao.empleado.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.empleado.IEmpleadoDAO;
import dto.EmpleadoDTO;
import util.PersistUtil;

public class EmpleadoDAO implements IEmpleadoDAO{
	
	@Override
	public EmpleadoDTO consultarEmpleadoPorId(Integer id, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		EmpleadoDTO empleadoDTO= null;
		try {
			query = EmpleadoSQL.FIND_BY_ID;
			instruccion = con.prepareStatement(query);
			int index = 1;
			instruccion.setInt(index++, id);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				empleadoDTO = new EmpleadoDTO();
				setInfoEmpleado(resultado, empleadoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return empleadoDTO;
	}

	private void setInfoEmpleado(ResultSet resultado, EmpleadoDTO empleadoDTO) throws Exception {
		
		
		empleadoDTO.setId(resultado.getInt("id_empleado"));
		empleadoDTO.setTipodoc(resultado.getString("tipodoc_empleado"));
		empleadoDTO.setDocumento(resultado.getString("documento_empleado"));
		empleadoDTO.setNombre(resultado.getString("nombre_empleado"));
		empleadoDTO.setApellido(resultado.getString("apellido_empleado"));
	}

	@Override
	public String actualizarEmpleado(EmpleadoDTO empleadoDTO, Connection con) throws Exception {
		PreparedStatement instruccion = null;
		String message ="";
		String query;
        try {
            query = EmpleadoSQL.UPDATE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, empleadoDTO.getTipodoc());
            instruccion.setString(index++, empleadoDTO.getDocumento());
            instruccion.setString(index++, empleadoDTO.getNombre());
            instruccion.setString(index++, empleadoDTO.getApellido());
            instruccion.setInt(index++, empleadoDTO.getId());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String crearEmpleado(EmpleadoDTO empleadoDTO, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = EmpleadoSQL.INSERT;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setString(index++, empleadoDTO.getTipodoc());
            instruccion.setString(index++, empleadoDTO.getDocumento());
            instruccion.setString(index++, empleadoDTO.getNombre());
            instruccion.setString(index++, empleadoDTO.getApellido());
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public String borrarEmpleado(Integer id, Connection con) throws Exception {
		String message ="";
		String query;
        PreparedStatement instruccion = null;
        try {
            query = EmpleadoSQL.DELETE;
            instruccion = con.prepareStatement(query);
            int index = 1;
            instruccion.setInt(index++, id);
            instruccion.executeUpdate();
            message ="OK";
        } catch (SQLException sql) {
        	 message ="ERROR";
        	con.rollback();
            throw new Exception(sql.toString());
        } finally {
           PersistUtil.closeResources(instruccion);
        }
        return message;
	}

	@Override
	public List<EmpleadoDTO> ListarEmpleados(Connection con) throws Exception {
		PreparedStatement instruccion = null;
		ResultSet resultado = null;
		String query;
		EmpleadoDTO empleadoDTO = null;
		List<EmpleadoDTO> listaEmpleados = new ArrayList<>();
		try {
			query = EmpleadoSQL.LIST;
			instruccion = con.prepareStatement(query);
			resultado = instruccion.executeQuery();
			while (resultado.next()) {
				empleadoDTO = new EmpleadoDTO();
				setInfoEmpleado(resultado, empleadoDTO);
				listaEmpleados.add(empleadoDTO);
			}
		} finally {
			PersistUtil.closeResources(instruccion, resultado);
		}
		return listaEmpleados;
	}

}
