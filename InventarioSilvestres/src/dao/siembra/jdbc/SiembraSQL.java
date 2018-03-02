package dao.siembra.jdbc;

public class SiembraSQL {
	
	private static final String TABLE_NAME="siembra";
	public static final String FIND_BY_ID ="SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_planta, fk_id_empleado, fk_id_cama  FROM "+TABLE_NAME+" where id_siembra = ? and activo_siembra = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_siembra, fecha_siembra, observacion_siembra, activo_siembra, fk_id_planta, fk_id_empleado, fk_id_cama)  VALUES ( ?, ?, ?, 'Y', ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_siembra = ?, fecha_siembra = ?, observacion_siembra = ?, fk_id_planta = ?, fk_id_empleado = ?, fk_id_cama = ?  where id_siembra = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_siembra = 'N' where id_siembra = ?";
	public static final String LIST = "SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_planta, fk_id_empleado, fk_id_cama FROM "+TABLE_NAME+" where activo_siembra = 'Y'";
	
	
	public SiembraSQL() {
		super();
	}
}
