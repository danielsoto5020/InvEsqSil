package dto;

public class TipoPlantaDTO {

	private Integer id;
	private Integer tipo;
	private String ntipo;
	private String nplanta;
	private Integer planta;
	
	public TipoPlantaDTO() {
		super();
	}

	public String getNtipo() {
		return ntipo;
	}

	public void setNtipo(String ntipo) {
		this.ntipo = ntipo;
	}

	public String getNplanta() {
		return nplanta;
	}

	public void setNplanta(String nplanta) {
		this.nplanta = nplanta;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}
	

}
