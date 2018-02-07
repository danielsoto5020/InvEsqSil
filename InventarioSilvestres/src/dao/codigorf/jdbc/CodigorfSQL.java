package dao.codigorf.jdbc;

public class CodigorfSQL {
	
	private static final String TABLE_NAME="codigorf";
	public static final String FIND_BY_ID ="SELECT id_codigorf, nombre_codigorf, fk_id_planta FROM "+ TABLE_NAME+" where id_codigorf = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  nombre_codigorf, fk_id_planta )  VALUES ( ?, ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_codigorf = ?, fk_id_planta = ? where id_codigorf = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_codigorf = ?";
	public static final String LIST = "SELECT id_codigorf, nombre_codigorf, fk_id_planta FROM "+TABLE_NAME;
	
	public CodigorfSQL() {
		super();
	}
	
}
