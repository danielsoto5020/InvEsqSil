package dao.tipo.jdbc;

public class TipoSQL {
	
	private static final String TABLE_NAME="tipo";
	public static final String FIND_BY_ID ="SELECT id_tipo, nombre_tipo FROM "+ TABLE_NAME+" where id_tipo = ? and where activo_tipo = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (nombre_tipo, activo_tipo )  VALUES (?, 'Y' )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  nombre_tipo = ?  where id_tipo = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_tipo = 'N' where id_tipo = ?";
	public static final String LIST = "SELECT id_tipo, nombre_tipo  FROM "+TABLE_NAME+" where activo_tipo = 'Y'";
	
	public TipoSQL() {
		super();
	}

}
