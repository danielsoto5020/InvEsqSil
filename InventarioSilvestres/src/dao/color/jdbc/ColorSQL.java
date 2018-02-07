package dao.color.jdbc;

public class ColorSQL {
	
	private static final String TABLE_NAME="color";
	public static final String FIND_BY_ID ="SELECT id_color, nombre_es_color, nombre_us_color FROM "+ TABLE_NAME+" where id_color = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  nombre_es_color, nombre_us_color )  VALUES ( ?, ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_es_color = ?, nombre_us_color = ? where id_color = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_color = ?";
	public static final String LIST = "SELECT id_color, nombre_es_color, nombre_us_color FROM "+TABLE_NAME;
	
	
	public ColorSQL() {
		super();
	}
	
	

}
