package dao.cosecha.jdbc;

public class CosechaSQL {
	
	private static final String TABLE_NAME="cosecha";
	public static final String FIND_BY_ID ="SELECT id_cosecha, cama_cosecha, variedad_cosecha, empleado_cosecha, cantidad_cosecha, fecha_cosecha, fk_id_siembra FROM "+ TABLE_NAME+" where id_cosecha = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (  cama_cosecha, variedad_cosecha, empleado_cosecha, cantidad_cosecha, fecha_cosecha, fk_id_siembra )  VALUES ( ?, ?, ?, ?, ?, ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET cama_cosecha = ?, variedad_cosecha = ?, empleado_cosecha = ?, cantidad_cosecha = ?, fecha_cosecha = ?, fk_id_siembra = ? where id_colsecha = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_cosecha = ?";
	public static final String LIST = "SELECT id_cosecha, cama_cosecha, variedad_cosecha, empleado_cosecha, cantidad_cosecha, fecha_cosecha, fk_id_siembra FROM "+TABLE_NAME;
	
	public CosechaSQL() {
		super();
	}
}
