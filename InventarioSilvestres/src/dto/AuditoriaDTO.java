package dto;

public class AuditoriaDTO {
	
	private Integer id;
	private String tabla;
	private String columna;
	private String valor;
	private String usuario;
	private String accion;
	private String fecha;
	
	
	public AuditoriaDTO() {
		super();
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


	public String getColumna() {
		return columna;
	}


	public void setColumna(String columna) {
		this.columna = columna;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getAccion() {
		return accion;
	}


	public void setAccion(String accion) {
		this.accion = accion;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
}
