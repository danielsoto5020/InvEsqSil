package dao.empleado.jdbc;

public class EmpleadoSQL {

	private static final String TABLE_NAME="empleado";
	public static final String FIND_BY_ID ="SELECT id_empleado, tipodoc_empleado, documento_empleado, nombre_empleado, apellido_empleado FROM "+ TABLE_NAME+" where id_empleado = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( tipodoc_empleado, documento_empleado, nombre_empleado, apellido_empleado )  VALUES ( ?, ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET tipodoc_empleado = ?, documento_empleado = ?, nombre_empleado = ?, apellido_empleado = ? where id_empleado = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_empleado = ?";
	public static final String LIST = "SELECT id_empleado, tipodoc_empleado, documento_empleado, nombre_empleado, apellido_empleado FROM "+TABLE_NAME;
	
	public EmpleadoSQL() {
		super();
	}
}
