package dto;

public class AuditoriaDTO {
	
	private Integer id;
	private String tabla;
	private String operacion;
	private String oldvalor;
	private String newvalor;
	private String fecha;
	private String usuario;
	
	public AuditoriaDTO() {
		super();
	}

	public String getOperacion() {
		return operacion;
	}


	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}


	public String getOldvalor() {
		return oldvalor;
	}


	public void setOldvalor(String oldvalor) {
		this.oldvalor = oldvalor;
	}


	public String getNewvalor() {
		return newvalor;
	}


	public void setNewvalor(String newvalor) {
		this.newvalor = newvalor;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTabla() {
		return tabla;
	}


	public void setTabla(String tabla) {
		this.tabla = tabla;
	}


	

	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
