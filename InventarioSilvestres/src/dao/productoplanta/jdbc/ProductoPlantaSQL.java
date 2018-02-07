package dao.productoplanta.jdbc;

public class ProductoPlantaSQL {

	private static final String TABLE_NAME="producto_planta";
	public static final String FIND_BY_ID ="SELECT id_producto_planta, fk_id_planta, fk_id_producto FROM "+ TABLE_NAME+" where id_producto_planta = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" (fk_id_planta, fk_id_producto)  VALUES (?, ?)";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  fk_id_planta = ?, fk_id_producto = ?  where id_producto_planta = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_producto_planta = ?";
	public static final String LIST = "SELECT id_producto_planta, fk_id_planta, fk_id_producto  FROM "+TABLE_NAME;
	
	public ProductoPlantaSQL() {
		super();
	}	
}
