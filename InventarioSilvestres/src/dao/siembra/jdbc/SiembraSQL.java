package dao.siembra.jdbc;

public class SiembraSQL {
	
	private static final String TABLE_NAME="siembra";
	public static final String FIND_BY_ID ="SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_planta, nombre_planta, fk_id_empleado, nombre_empleado, apellido_empleado, nombre_bloque, numero_cama, esterilizacion_cama FROM "+TABLE_NAME+", empleado, planta, bloque , cama  WHERE fk_id_planta = id_planta and  fk_id_empleado = id_empleado and id_cama = fk_id_cama and id_bloque = fk_id_bloque and id_siembra = ? and activo_siembra = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_siembra, fecha_siembra, observacion_siembra, activo_siembra, fk_id_planta, fk_id_empleado, fk_id_cama)  VALUES ( ?, ?, ?, 'Y' , ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_siembra = ?, fecha_siembra = ?, observacion_siembra = ?, fk_id_planta = ?, fk_id_empleado = ?, fk_id_cama = ?  where id_siembra = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_siembra = 'N' where id_siembra = ?";
	public static final String LIST = "SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_planta, nombre_planta, fk_id_empleado, nombre_empleado, apellido_empleado, nombre_bloque, numero_cama, esterilizacion_cama FROM "+TABLE_NAME+", empleado, planta, bloque , cama  WHERE fk_id_planta = id_planta and  fk_id_empleado = id_empleado and id_cama = fk_id_cama and id_bloque = fk_id_bloque and activo_siembra = 'Y'";
	public static final String ESPACE = "SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_planta,  fk_id_empleado, fk_id_cama FROM "+TABLE_NAME+" WHERE fk_id_cama = ? and fk_id_planta = id_planta and  fk_id_empleado = id_empleado and activo_siembra = 'Y'";
	public static final String STOCK = "SELECT sum(cast(cantidad_siembra as int)) FROM "+TABLE_NAME+" WHERE fk_id_cama = ? and activo_siembra = 'Y'";
	
	
	public SiembraSQL() {
		super();
	}
}