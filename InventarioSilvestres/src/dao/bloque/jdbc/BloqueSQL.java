package dao.bloque.jdbc;

public class BloqueSQL {
	
	private static final String TABLE_NAME="bloque";
	public static final String FIND_BY_ID ="SELECT id_bloque, nombre_bloque, ncama_bloque, fk_id_finca FROM "+ TABLE_NAME+" where id_bloque = ? and activo_bloque = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( nombre_bloque, ncama_bloque, activo_bloque, fk_id_finca ) VALUES ( ?, ?, 'Y', ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_bloque= ?, ncama_bloque= ?, fk_id_finca FROM  = ?  where id_bloque = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_bloque = 'N' where id_bloque = ?";
	public static final String LIST = "SELECT id_bloque, nombre_bloque, ncama_bloque, fk_id_finca FROM "+TABLE_NAME+" where activo_bloque = 'Y' ";
	
	public BloqueSQL() {
		super();
		
	}
}