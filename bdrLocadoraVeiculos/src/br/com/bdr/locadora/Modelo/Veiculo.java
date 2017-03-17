package br.com.bdr.locadora.Modelo;

/**
 * Classe representa o Modelo
 */
public class Veiculo {

	/**
	 * @param id
	 *            - mostrado na interface como campo Código, é auto incremento e
	 *            pode ser informado diretamente no campo, ao informar este
	 *            valor a aplicação irá verificar se existe alguma entidade para
	 *            alteração
	 */
	private int id;
	/**
	 * @param Campo
	 *            de entrada de informação Placa do veículo
	 */
	private String placa;
	/**
	 * @param Campo
	 *            de entrada de informação Marca do veículo
	 */
	private String marca;
	/**
	 * @param Campo
	 *            de entrada de informação Modelo do veículo
	 */
	private String modelo;
	/**
	 * @param Campo
	 *            de entrada de informação Tipo Combustível do veículo
	 */
	private String combustivel;
	/**
	 * @param Campo
	 *            de entrada de informação Cor do veículo
	 */
	private String cor;
	
	/**
	 * @param Campo de entrada de informação Valor da Diária do veículo par alocação.
	 * */
	private Double vl_diaria;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Double getVl_diaria() {
		return vl_diaria;
	}

	public void setVl_diaria(Double vl_diaria) {
		this.vl_diaria = vl_diaria;
	}
}