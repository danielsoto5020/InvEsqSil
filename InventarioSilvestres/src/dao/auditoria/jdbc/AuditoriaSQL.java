package dao.auditoria.jdbc;

public class AuditoriaSQL {
	
	private static final String TABLE_NAME="auditoria";
	public static final String FIND_BY_ID ="SELECT id_auditoria, tabla_auditoria, columna_auditoria, valor_auditoria, usuario_auditoria, accion_auditoria, fecha_auditoria FROM "+ TABLE_NAME+" where id_auditoria = ?";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( tabla_auditoria, columna_auditoria, valor_auditoria, usuario_auditoria, accion_auditoria, fecha_auditoria)  VALUES (?, ?, ?, ?, ?, ? )";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET  tabla_auditoria = ?, columna_auditoria = ?, valor_auditoria = ?, usuario_auditoria = ?, accion_auditoria = ?, fecha_auditoria = ? where id_auditoria = ?";
	public static final String DELETE ="DELETE FROM "+ TABLE_NAME+" where id_auditoria = ?";
	public static final String LIST = "SELECT id_auditoria, tabla_auditoria, columna_auditoria, valor_auditoria, usuario_auditoria, accion_auditoria, fecha_auditoria FROM "+TABLE_NAME;
	
	
	public AuditoriaSQL() {
		super();
	}

}
