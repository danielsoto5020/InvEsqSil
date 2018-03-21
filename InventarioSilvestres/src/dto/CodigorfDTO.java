package dto;

public class CodigorfDTO {
	
	private Integer id;
	private String codigo;
	private String nplanta;
	private Integer planta;
	
	public CodigorfDTO() {
		super();
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

}
