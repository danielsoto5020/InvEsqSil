package dao.proceso.jdbc;

public class ProcesoSQL {
	
	private static final String TABLE_NAME="proceso";
	
	public static final String FIND_PROCESO_BY_ID ="SELECT id_proceso, nombre_proceso, fk_id_persona FROM "+ TABLE_NAME+" where id_proceso = ?";
	public static final String INSERT_PROCESO="INSERT INTO "+TABLE_NAME+" ( id_proceso, nombre_proceso, fk_id_persona )  VALUES (?, ?, ? )";
	public static final String UPDATE_PROCESO ="UPDATE "+TABLE_NAME+"  SET id_proceso = ?, nombre_proceso = ?, fk_id_persona = ? where id_proceso = ?";
	public static final String DELETE_PROCESO ="DELETE FROM "+ TABLE_NAME+" where id_proceso = ?";
	public static final String LIST_PROCESO = "SELECT id_proceso, nombre_proceso, fk_id_persona FROM "+TABLE_NAME;
	
	public ProcesoSQL() {
		super();
	}
}
