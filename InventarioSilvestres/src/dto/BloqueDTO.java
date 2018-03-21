package dto;

public class BloqueDTO {
	
	private Integer id;
	private String nombre;
	private String ncama;
	private Integer finca;
	private String nfinca;

	public BloqueDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNfinca() {
		return nfinca;
	}

	public void setNfinca(String nfinca) {
		this.nfinca = nfinca;
	}

	public void setFinca(Integer finca) {
		this.finca = finca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getFinca() {
		return finca;
	}

	public String getNcama() {
		return ncama;
	}

	public void setNcama(String ncama) {
		this.ncama = ncama;
	}
}
