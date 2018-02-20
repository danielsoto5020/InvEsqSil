package dao.siembra.jdbc;

public class SiembraSQL {
	
	private static final String TABLE_NAME="siembra";
	public static final String FIND_BY_ID ="SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_cama, fk_id_variedad, fk_id_empleado  FROM "+TABLE_NAME+" where id_siembra = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_cama, fk_id_variedad, fk_id_empleado)  VALUES ( ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  cantidad_siembra = ?, fecha_siembra = ?, observacion_siembra = ?, fk_id_cama = ?, fk_id_variedad = ?, fk_id_empleado = ?  where id_siembra = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_siembra = ?";
	public static final String LIST = "SELECT id_siembra, cantidad_siembra, fecha_siembra, observacion_siembra, fk_id_cama, fk_id_variedad, fk_id_empleado FROM "+TABLE_NAME;
	


}
