package dao.color.jdbc;

public class ColorSQL {
	
	private static final String TABLE_NAME="color";
	public static final String FIND_BY_ID ="SELECT id_color, nombre_es_color, nombre_us_color FROM "+ TABLE_NAME+" where id_color = ? and activo_color = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  nombre_es_color, nombre_us_color, activo_color )  VALUES ( ?, ?, 'Y' )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_es_color = ?, nombre_us_color = ? where id_color = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_color = 'N' where id_color = ?";
	public static final String LIST = "SELECT id_color, nombre_es_color, nombre_us_color FROM "+TABLE_NAME+" where activo_color = 'Y' ";
	
	
	public ColorSQL() {
		super();
	}
	
	

}
