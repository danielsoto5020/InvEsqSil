package dto;

public class AuditoriaDTO {
	
	private Integer id;
	private String tabla;
	private String operacion;
	private String oldValor;
	private String newValor;
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


	public String getOldValor() {
		return oldValor;
	}


	public void setOldValor(String oldValor) {
		this.oldValor = oldValor;
	}


	public String getNewValor() {
		return newValor;
	}


	public void setNewValor(String newValor) {
		this.newValor = newValor;
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
