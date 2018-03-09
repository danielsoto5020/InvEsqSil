package dao.salida.jdbc;

public class SalidaSQL {
	
	private static final String TABLE_NAME="salida";
	public static final String FIND_BY_ID ="SELECT id_salida, cantidad_salida, fecha_salida, fk_id_planta, fk_id_empleado, fk_id_ingreso  FROM "+TABLE_NAME+" where id_salida = ? and activo_salida = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_salida, fecha_salida, activo_siembra, fk_id_planta, fk_id_empleado, fk_id_ingreso)  VALUES ( ?, ?, 'Y' , ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_salida = ?, fecha_salida = ?, fk_id_planta = ?, fk_id_empleado = ?, fk_id_ingreso = ?  where id_salida = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_salida = 'N' where id_salida = ?";
	public static final String LIST = "SELECT id_salida, cantidad_salida, fecha_salida, fk_id_planta, fk_id_empleado, fk_id_ingreso FROM "+TABLE_NAME+" where activo_salida = 'Y'";
	public static final String FIND_LAST ="SELECT id_ingreso, cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, fk_id_planta FROM ingreso WHERE fecha_ingreso = (SELECT MIN(fecha_ingreso) AS fecha_ingreso FROM ingreso)";
	
	public SalidaSQL() {
		super();
	}	
}
