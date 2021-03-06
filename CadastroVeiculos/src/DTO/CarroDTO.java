package DTO;

public class CarroDTO {
	
	private Integer id;
	private String modelo;
	private String marca;
	private String placa;
	
	public CarroDTO() {}
	
	public CarroDTO(String modelo, String marca, String placa) {
		this.modelo = modelo;
		this.marca = marca;
		this.placa = placa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
}