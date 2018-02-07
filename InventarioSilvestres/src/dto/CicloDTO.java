package dto;

public class CicloDTO {

	private Integer id; 
    private String cantidad;
    private String fecha;
    private Integer cama;
    private Integer persona;
    private Integer planta;
    private Integer proceso;
    private Integer ciclo;
    
	public CicloDTO() {
		super();
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

	public Integer getCama() {
		return cama;
	}

	public void setCama(Integer cama) {
		this.cama = cama;
	}

	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

	public Integer getProceso() {
		return proceso;
	}

	public void setProceso(Integer proceso) {
		this.proceso = proceso;
	}

	public Integer getCiclo() {
		return ciclo;
	}

	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}
    

}
