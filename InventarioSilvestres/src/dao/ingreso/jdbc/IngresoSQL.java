package dao.ingreso.jdbc;

public class IngresoSQL {
	
	private static final String TABLE_NAME="ingreso";
	public static final String FIND_BY_ID ="SELECT id_ingreso, cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, fk_id_planta, fk_id_empleado, fk_id_cama, fk_id_siembra  FROM "+TABLE_NAME+" where id_siembra = ? and activo_ingreso = 'Y'";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, activo_ingreso, fk_id_planta, fk_id_empleado, fk_id_cama, fk_id_siembra)  VALUES ( ?, ?, ?, ?, ?, 'Y', ?, ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_ingreso = ?, puesto_ingreso = ?, nivel_ingreso = ?, lado_ingreso = ?, fecha_ingreso = ?, fk_id_planta = ?, fk_id_empleado = ?, fk_id_cama = ?, fk_id_siembra = ?  where id_ingreso = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_ingreso = 'N' where id_ingreso = ?";
	public static final String LIST = "SELECT id_ingreso, cantidad_ingreso, puesto_ingreso, nivel_ingreso, lado_ingreso, fecha_ingreso, fk_id_planta, fk_id_empleado, fk_id_cama, fk_id_siembra FROM "+TABLE_NAME+" where activo_ingreso = 'Y'";
	
	public IngresoSQL() {
		super();
	}
	

}
