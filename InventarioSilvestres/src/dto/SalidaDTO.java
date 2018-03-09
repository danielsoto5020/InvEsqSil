package dto;

public class SalidaDTO {
	
	
	private Integer id;
	private String cantidad;
	private String destino;
	private String fecha;
	private Integer variedad;
	private Integer empleado;
	private Integer ingreso;

	public SalidaDTO() {
		super();
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
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


	public Integer getIngreso() {
		return ingreso;
	}


	public void setIngreso(Integer ingreso) {
		this.ingreso = ingreso;
	}
	
	

}
