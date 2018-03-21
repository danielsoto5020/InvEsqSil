package dao.productoplanta.jdbc;

public class ProductoPlantaSQL {

	private static final String TABLE_NAME="producto_planta";
	public static final String FIND_BY_ID ="SELECT id_producto_planta, fk_id_planta,nombre_planta, nombre_producto, fk_id_producto FROM "+ TABLE_NAME+", planta, producto where id_planta = fk_id_planta and id_producto = fk_id_producto and id_producto_planta = ? and activo_producto_planta = 'Y' ";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (activo_producto_planta, fk_id_planta, fk_id_producto)  VALUES ('Y', ?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  fk_id_planta = ?, fk_id_producto = ?  where id_producto_planta = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_producto_planta = 'N' where id_producto_planta = ?";
	public static final String LIST = "SELECT id_producto_planta, nombre_planta, nombre_producto, fk_id_planta, fk_id_producto  FROM "+TABLE_NAME+" , planta, producto where id_planta = fk_id_planta and id_producto = fk_id_producto and activo_producto_planta = 'Y '";
	
	public ProductoPlantaSQL() {
		super();
	}	
}
