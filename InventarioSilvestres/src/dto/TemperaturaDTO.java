package dto;

public class TemperaturaDTO {
	
	private Integer id;
	private String valor;
	private String fecha;
	private String sector;
	private String lugar;
	private Integer bloque;
	private Integer persona;
	private String npersona;

	public TemperaturaDTO() {
		super();
	}

	public String getNpersona() {
		return npersona;
	}

	public void setNpersona(String npersona) {
		this.npersona = npersona;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getSector() {
		return sector;
	}

	public void setSector(String sector) {
		this.sector = sector;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	
	public Integer getBloque() {
		return bloque;
	}

	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}
	
	public Integer getPersona() {
		return persona;
	}

	public void setPersona(Integer persona) {
		this.persona = persona;
	}
}
