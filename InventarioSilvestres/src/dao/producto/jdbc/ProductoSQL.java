package dao.producto.jdbc;

public class ProductoSQL {
	
	private static final String TABLE_NAME="producto";
	public static final String FIND_BY_ID ="SELECT id_producto, nombre_producto FROM "+ TABLE_NAME+" where id_producto = ? and activo_producto = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (nombre_producto, activo_producto )  VALUES ( ?, 'Y' )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  nombre_producto = ?  where id_producto = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_producto = 'N' where id_producto = ?";
	public static final String LIST = "SELECT id_producto, nombre_producto  FROM "+TABLE_NAME+" where activo_producto = 'Y'";
	

	public ProductoSQL() {
		super();
	}


}
