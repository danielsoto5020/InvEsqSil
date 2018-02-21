package dto;

public class CosechaDTO {
	
	private Integer id;
	private Integer cama;
	private Integer variedad;
	private Integer empleado;
	private String cantidad;
	private String fecha;
	private Integer siembra;
	
	public CosechaDTO() {
		super();		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCama() {
		return cama;
	}

	public void setCama(Integer cama) {
		this.cama = cama;
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

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getSiembra() {
		return siembra;
	}

	public void setSiembra(Integer siembra) {
		this.siembra = siembra;
	}
	
}
