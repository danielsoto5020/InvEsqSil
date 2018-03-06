package dao.tipoplanta.jdbc;

public class TipoPlantaSQL {
	
	private static final String TABLE_NAME="tipo_planta";
	public static final String FIND_BY_ID ="SELECT id_tipo_planta, fk_id_planta, fk_id_tipo FROM "+TABLE_NAME+" where id_tipo_planta = ? and activo_tipo_planta = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (activo_tipo_planta, fk_id_planta, fk_id_tipo)  VALUES ('Y', ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  fk_id_planta = ?, fk_id_tipo = ?  where id_tipo_planta = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_tipo_planta = 'N' where id_tipo_planta = ?";
	public static final String LIST = "SELECT id_tipo_planta, fk_id_planta, fk_id_tipo  FROM "+TABLE_NAME+" where activo_tipo_planta = 'Y' ";
	
	public TipoPlantaSQL() {
		super();
	}
}
