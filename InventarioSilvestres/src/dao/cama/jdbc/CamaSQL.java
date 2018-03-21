package dao.cama.jdbc;

public class CamaSQL {
	
	private static final String TABLE_NAME="cama";
	public static final String FIND_BY_ID ="SELECT id_cama, numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, fk_id_bloque FROM "+ TABLE_NAME+", bloque WHERE id_bloque = fk_id_bloque and id_cama = ?  and activo_cama = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, activo_vama, fk_id_bloque )  VALUES (?, ?, ?, ?, ?, ?, ?, 'Y', ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  numero_cama = ?, ancho_cama = ?, largo_cama = ?, lineas_cama = ?, nlinea_cama = ?, estado_cama = ?, esterilizacion_cama = ?, fk_id_bloque = ? where id_cama = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_cama = 'N' where id_cama = ?";
	public static final String ESTERIL ="UPDATE "+TABLE_NAME+"  SET esterilizacion_cama = now() where id_cama = ?";
	public static final String ACTIV = "SELECT id_cama, nombre_bloque, numero_cama FROM "+TABLE_NAME+", bloque where activo_cama = 'Y' and estado_cama != 'ACTIVA' id_bloque = fk_id_bloque";
	public static final String LIST = "SELECT id_cama, numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, nombre_bloque, fk_id_bloque FROM "+TABLE_NAME+", bloque where  id_bloque = fk_id_bloque and activo_cama = 'Y'";
	public static final String FIND_ID = "SELECT id_cama FROM "+TABLE_NAME+",bloque WHERE numero_cama = ? and nombre_bloque = ? and fk_id_bloque = id_bloque";
	public static final String FIND_ESPACE ="SELECT id_cama, numero_cama, ancho_cama, largo_cama, lineas_cama, nlinea_cama, estado_cama, esterilizacion_cama, fk_id_bloque FROM "+ TABLE_NAME+" WHERE  id_cama = ?  and activo_cama = 'Y'";
	
	
	public CamaSQL() {
		super();
	}
}
