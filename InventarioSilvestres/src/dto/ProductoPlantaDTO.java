package dto;

public class ProductoPlantaDTO {

	private Integer id;
	private Integer producto;
	private String nproducto;
	private String nplanta;
	private Integer planta;
	
	public String getNproducto() {
		return nproducto;
	}

	public void setNproducto(String nproducto) {
		this.nproducto = nproducto;
	}

	public String getNplanta() {
		return nplanta;
	}

	public void setNplanta(String nplanta) {
		this.nplanta = nplanta;
	}

	public ProductoPlantaDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProducto() {
		return producto;
	}

	public void setProducto(Integer producto) {
		this.producto = producto;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setPlanta(Integer planta) {
		this.planta = planta;
	}

}
