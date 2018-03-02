package dto;

public class IngresoDTO {
	
	private Integer id;
	private String cantidad;
	private String puesto;
	private String nivel;
	private String lado;
	private String fecha;
	private Integer variedad;
	private Integer empleado;
	private Integer cama;
	private Integer siembra;
	
	public IngresoDTO() {
		super();
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getVariedad() {
		return variedad;
	}

	public void setVariedad(Integer variedad) {
		this.variedad = variedad;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getCama() {
		return cama;
	}

	public void setCama(Integer cama) {
		this.cama = cama;
	}

	public Integer getSiembra() {
		return siembra;
	}

	public void setSiembra(Integer siembra) {
		this.siembra = siembra;
	}	
}
