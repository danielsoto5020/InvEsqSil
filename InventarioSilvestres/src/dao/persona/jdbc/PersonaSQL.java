package dao.persona.jdbc;

public class PersonaSQL {
	
	private static final String TABLE_NAME="persona";
	public static final String FIND_BY_ID ="SELECT id_persona, documento_persona, nombre_persona, telefono_persona, correo_persona, cargo_persona, codigo_persona, usuario_persona, contrasenia_persona FROM "+ TABLE_NAME+" where id_persona = ? and  activo_persona = 'Y'";
	public static final String INSERT="INSERT INTO "+TABLE_NAME+" ( documento_persona, nombre_persona, telefono_persona, correo_persona, cargo_persona, codigo_persona, usuario_persona, contrasenia_persona, activo_persona )  VALUES (?, ?, ?, ?, ?, ?, ?, ?, 'Y')";
	public static final String UPDATE ="UPDATE "+TABLE_NAME+"  SET documento_persona = ?, nombre_persona = ?, telefono_persona = ?, correo_persona = ?, cargo_persona = ?, codigo_persona = ?, usuario_persona = ?, contrasenia_persona = ?  where id_persona = ?";
	public static final String DELETE ="UPDATE "+TABLE_NAME+"  SET  activo_persona = 'N' where id_persona = ?";
	public static final String LIST = "SELECT id_persona, documento_persona, nombre_persona, telefono_persona, correo_persona, cargo_persona, codigo_persona, usuario_persona, contrasenia_persona FROM "+TABLE_NAME+" where activo_persona = 'Y' ";

	public PersonaSQL() {
		super();
	}
}