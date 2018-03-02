package dao.planta.jdbc;

public class PlantaSQL {

	private static final String TABLE_NAME="planta";
	public static final String FIND_BY_ID ="SELECT id_planta, nombre_planta, renombre_planta, esquejecf_planta, productividad_planta, flush_planta, flushs_planta, fk_id_breeder, fk_id_color1, fk_id_color2  FROM "+ TABLE_NAME+" where id_planta = ? and activo_planta = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (nombre_planta, renombre_planta, esquejecf_planta, productividad_planta, flush_planta, flushs_planta, activo_planta, fk_id_breeder, fk_id_color1, fk_id_color2)  VALUES ( ?, ?, ?, ?, ?, ?, 'Y', ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_planta = ?, renombre_planta = ?, esquejecf_planta = ?, productividad_planta = ?, flush_planta = ?, flushs_planta = ?, fk_id_breeder = ?, fk_id_color1 = ?, fk_id_color2 = ? where id_planta = ?";
	public static final String DELETE ="UPDATE \"+TABLE_NAME+\"  SET  activo_planta = 'N' where id_planta = ?";
	public static final String LIST = "SELECT id_planta, nombre_planta, renombre_planta, esquejecf_planta, productividad_planta, flush_planta, flushs_planta, fk_id_breeder, "
			+ "nombre_breeder, fk_id_color1, a.nombre_es_color AS \"a.nombre_es_color\", fk_id_color2, c.nombre_es_color AS \"c.nombre_es_color\" "
			+ "FROM  "+TABLE_NAME+", color a, color c, breeder "
			+ "where  fk_id_breeder = id_breeder and fk_id_color1 = a.id_color and fk_id_color2 = c.id_color  and activo_planta = 'Y' ";
		
	public PlantaSQL() {
		super();
		
	}
}
