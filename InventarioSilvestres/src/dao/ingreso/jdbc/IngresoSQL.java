package dao.ingreso.jdbc;

public class IngresoSQL {
	
	private static final String TABLE_NAME="ingreso";
	public static final String FIND_BY_ID ="SELECT id_ingreso, cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, nombre_planta, nombre_empleado, apellido_empleado, nombre_bloque , numero_cama, fk_id_siembra FROM ingreso, cama, empleado, planta, bloque, siembra WHERE id_bloque = fk_id_bloque and id_planta = fk_id_planta and id_cama = fk_id_cama and id_empleado = ingreso.fk_id_empleado and fk_id_siembra = id_siembra and id_siembra = ? and activo_ingreso = 'Y'";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, fk_id_empleado, fk_id_siembra, activo_ingreso )  VALUES ( ?, ?, ?, ?, ?, ?, ?, 'Y' )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_ingreso = ?, puesto_ingreso = ?, nivel_ingreso = ?, lado_ingreso = ?, fecha_ingreso = ?, fk_id_empleado = ?,  fk_id_siembra = ?  where id_ingreso = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_ingreso = 'N' where id_ingreso = ?";
	public static final String LIST = "SELECT id_ingreso, cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, nombre_planta, nombre_empleado, apellido_empleado, nombre_bloque , numero_cama, fk_id_siembra FROM ingreso, cama, empleado, planta, bloque, siembra WHERE id_bloque = fk_id_bloque and id_planta = fk_id_planta and id_cama = fk_id_cama and id_empleado = ingreso.fk_id_empleado and fk_id_siembra = id_siembra and activo_ingreso = 'Y'";
	
	public IngresoSQL() {
		super();
	}
	

}
