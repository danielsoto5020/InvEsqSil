package dto;


public class SiembraDTO {
	
	private Integer id;
	private String cantidad;
	private Integer cama;
	private String nempleado;
	private Integer empleado;
	private String nvariedad;
	private Integer variedad;
	private String esterilizacion;
	private String ncama;
	private String fecha;
	private String observacion;
	
	public SiembraDTO() {
		super();
	}

	public String getNempleado() {
		return nempleado;
	}

	public void setNempleado(String nempleado) {
		this.nempleado = nempleado;
	}

	public String getNvariedad() {
		return nvariedad;
	}

	public void setNvariedad(String nvariedad) {
		this.nvariedad = nvariedad;
	}

	public String getEsterilizacion() {
		return esterilizacion;
	}

	public void setEsterilizacion(String esterilizacion) {
		this.esterilizacion = esterilizacion;
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

	public Integer getCama() {
		return cama;
	}

	public void setCama(Integer cama) {
		this.cama = cama;
	}

	public Integer getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Integer empleado) {
		this.empleado = empleado;
	}

	public Integer getVariedad() {
		return variedad;
	}

	public void setVariedad(Integer variedad) {
		this.variedad = variedad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getNcama() {
		return ncama;
	}

	public void setNcama(String ncama) {
		this.ncama = ncama;
	}
	
}
