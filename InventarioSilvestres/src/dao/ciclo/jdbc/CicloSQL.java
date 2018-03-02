package dao.ciclo.jdbc;

public class CicloSQL {
	
	private static final String TABLE_NAME="ciclo";
	
	public static final String FIND_CICLO_BY_ID ="SELECT id_ciclo, cantidad_ciclo, fecha_ciclo, fk_id_cama, fk_id_persona, fk_id_planta, fk_id_proceso, fk_id_ciclo FROM "+ TABLE_NAME+" where id_ciclo = ?";
	public static final String INSERT_CICLO="INSERT INTO "+TABLE_NAME+" ( id_ciclo, cantidad_ciclo, fecha_ciclo, fk_id_cama, fk_id_persona, fk_id_planta, fk_id_proceso, fk_id_ciclo )  VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE_CICLO ="UPDATE "+TABLE_NAME+"  SET id_ciclo = ?, cantidad_ciclo = ?, fecha_ciclo = ?, fk_id_cama = ?, fk_id_persona = ?, fk_id_planta = ?, fk_id_proceso = ?, fk_id_ciclo = ? where id_ciclo = ?";
	public static final String DELETE_CICLO ="UPDATE "+TABLE_NAME+"  SET  activo_ciclo = 'N' where id_ciclo = ?";
	public static final String LIST_CICLO = "SELECT id_ciclo, cantidad_ciclo, fecha_ciclo, fk_id_cama, fk_id_persona, fk_id_planta, fk_id_proceso, fk_id_ciclo FROM "+TABLE_NAME;

	public CicloSQL() {
		super();
	}
}
