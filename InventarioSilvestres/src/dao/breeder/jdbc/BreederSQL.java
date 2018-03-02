package dao.breeder.jdbc;

public class BreederSQL {
	
	private static final String TABLE_NAME="breeder";
	public static final String FIND_BY_ID ="SELECT id_breeder, nombre_breeder, telefono1_breeder, correo_breeder, web_breeder, contacto_breeder FROM "+ TABLE_NAME+" where id_breeder = ? and activo_breeder = 'Y'";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (nombre_breeder, telefono1_breeder, correo_breeder, web_breeder, contacto_breeder, activo_breeder )  VALUES (?, ?, ?, ?, 'Y')";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET nombre_breeder=?, telefono1_breeder=?, correo_breeder=?, web_breeder=?, contacto_breeder=?  where id_breeder = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_breeder = 'N' where id_breeder = ?";
	public static final String LIST = "SELECT id_breeder, nombre_breeder, telefono1_breeder, correo_breeder, web_breeder, contacto_breeder FROM "+TABLE_NAME+" where activo_breeder = 'Y' ";
	
	public BreederSQL() {
		super();
	}
	
}
