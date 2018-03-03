package dto;

public class CamaDTO {
	
	private Integer id;
	private String numero;
	private String ancho;
	private String largo;
	private String lineas;
	private String nlinea;
	private String estado;
	private String esterilizacion;
	private Integer bloque;
	private String nbloque;
	
	
	public CamaDTO() {
		super();
	}


	public String getNbloque() {
		return nbloque;
	}


	public void setNbloque(String nbloque) {
		this.nbloque = nbloque;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getAncho() {
		return ancho;
	}


	public void setAncho(String ancho) {
		this.ancho = ancho;
	}


	public String getLargo() {
		return largo;
	}


	public void setLargo(String largo) {
		this.largo = largo;
	}


	public String getLineas() {
		return lineas;
	}


	public void setLineas(String lineas) {
		this.lineas = lineas;
	}


	public String getNlinea() {
		return nlinea;
	}


	public void setNlinea(String nlinea) {
		this.nlinea = nlinea;
	}


	public String getEstado() {
		return estado;
	}


	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEsterilizacion() {
		return esterilizacion;
	}


	public void setEsterilizacion(String esterilizacion) {
		this.esterilizacion = esterilizacion;
	}


	public Integer getBloque() {
		return bloque;
	}


	public void setBloque(Integer bloque) {
		this.bloque = bloque;
	}
}
