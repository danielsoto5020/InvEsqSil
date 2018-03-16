package dao.origen.jdbc;

public class OrigenSQL {
	
	
	private static final String TABLE_NAME="origen";
	public static final String FIND_BY_ID ="SELECT id_origen, nombre_origen FROM "+TABLE_NAME+" where id_origen = ? and  activo_origen = 'Y' ";
	public static final String FIND_ID ="SELECT id_origen FROM "+TABLE_NAME+" where nombre_origen = ? and  activo_origen = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( nombre_origen, activo_origen )  VALUES (?, 'Y' ) ";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  nombre_origen = ? where id_origen = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_origen = 'N' where id_origen = ?";
	public static final String LIST = "SELECT id_origen, nombre_origen FROM "+TABLE_NAME+" where activo_origen = 'Y' ";
	
	public OrigenSQL() {
		super();
	}
}
