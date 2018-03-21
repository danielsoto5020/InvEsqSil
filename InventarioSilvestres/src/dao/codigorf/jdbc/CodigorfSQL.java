package dao.codigorf.jdbc;

public class CodigorfSQL {
	
	private static final String TABLE_NAME="codigorf";
	public static final String FIND_BY_ID ="SELECT id_codigorf, nombre_codigorf, nombre_ planta, fk_id_planta FROM "+ TABLE_NAME+", planta where id_planta = fk_id_planta and id_codigorf = ? and activo_codigorf = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  nombre_codigorf, activo_codigorf, fk_id_planta )  VALUES ( ?, 'Y', ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_codigorf = ?, fk_id_planta = ? where id_codigorf = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_codigorf = 'N' where id_codigorf = ?";
	public static final String LIST = "SELECT id_codigorf, nombre_codigorf, nombre_ planta, fk_id_planta FROM "+TABLE_NAME+", planta where id_planta = fk_id_planta and activo_codigorf = 'Y'";
	
	public CodigorfSQL() {
		super();
	}
	
}
