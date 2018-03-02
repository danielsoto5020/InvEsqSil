package dao.finca.jdbc;

public class FincaSQL {
	
	private static final String TABLE_NAME="finca";
	public static final String FIND_BY_ID ="SELECT id_finca, nombre_finca, ubicacion_finca, telefono1_finca FROM "+ TABLE_NAME+" where id_finca = ? and activo_finca = 'Y'";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( nombre_finca, ubicacion_finca, telefono1_finca, activo_finca )  VALUES ( ?, ?, ?, 'Y' )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_finca = ?, ubicacion_finca = ?, telefono1_finca = ? where id_finca = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_finca = 'N' where id_finca = ?";
	public static final String LIST = "SELECT id_finca, nombre_finca, ubicacion_finca, telefono1_finca FROM "+TABLE_NAME+" where activo_finca = 'Y'";
	
	public FincaSQL() {
		super();
	}
	
}
