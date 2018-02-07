package dao.temperatura.jdbc;

public class TemperaturaSQL {
	
	private static final String TABLE_NAME="temperatura";
	public static final String FIND_BY_ID ="SELECT id_temperatura, valor_temperatura, fecha_temperatura, sector_temperatura, lugar_temperatura, fk_id_bloque, fk_id_persona, nombre_persona  FROM "+ TABLE_NAME+" INNER JOIN persona on persona.id_persona = "+TABLE_NAME+".fk_id_persona where id_temperatura = ? ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( valor_temperatura, fecha_temperatura, sector_temperatura, lugar_temperatura, fk_id_bloque,  fk_id_persona)  VALUES ( ?, ?, ?, ?, ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  valor_temperatura = ?, fecha_temperatura = ?, sector_temperatura = ?, lugar_temperatura = ?, fk_id_bloque = ?, fk_id_persona = ?  where id_temperatura = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_temperatura = ?";
	public static final String LIST = "SELECT id_temperatura, valor_temperatura, fecha_temperatura, sector_temperatura, lugar_temperatura, fk_id_bloque, fk_id_persona, nombre_persona  FROM "+TABLE_NAME+" INNER JOIN persona on persona.id_persona = "+TABLE_NAME+".fk_id_persona";
	

	public TemperaturaSQL() {
		super();
	}	
}
