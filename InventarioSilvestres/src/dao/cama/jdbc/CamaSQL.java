package dao.cama.jdbc;

public class CamaSQL {
	
	private static final String TABLE_NAME="cama";
	public static final String FIND_BY_ID ="SELECT id_cama, numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, fk_id_bloque FROM "+ TABLE_NAME+" where id_cama = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, fk_id_bloque )  VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  numero_cama = ?, ancho_cama = ?, largo_cama = ?, lineas_cama = ?, nlinea_cama = ?, estado_cama = ?, esterilizacion_cama = ?, fk_id_bloque = ? where id_cama = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_cama = ?";
	public static final String LIST = "SELECT id_cama, numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, fk_id_bloque FROM "+TABLE_NAME;
	
	
	public CamaSQL() {
		super();
	}
}
