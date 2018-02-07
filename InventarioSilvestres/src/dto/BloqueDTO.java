package dto;

public class BloqueDTO {
	
	private Integer id;
	private String nombre;
	private String ncama;
	private Integer finca;

	public BloqueDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNcama() {
		return ncama;
	}

	public void setNcama(String ncama) {
		this.ncama = ncama;
	}

	public Integer getFinca() {
		return finca;
	}

	public void setFinca(Integer finca) {
		this.finca = finca;
	}
}
