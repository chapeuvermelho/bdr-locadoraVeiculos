package br.com.bdr.locadora.Modelo;

/**
 * Classe representa o Modelo
 */
public class Veiculo {

	/**
	 * @param id
	 *            - mostrado na interface como campo C�digo, � auto incremento e
	 *            pode ser informado diretamente no campo, ao informar este
	 *            valor a aplica��o ir� verificar se existe alguma entidade para
	 *            altera��o
	 */
	private int id;
	/**
	 * @param Campo
	 *            de entrada de informa��o Placa do ve�culo
	 */
	private String placa;
	/**
	 * @param Campo
	 *            de entrada de informa��o Marca do ve�culo
	 */
	private String marca;
	/**
	 * @param Campo
	 *            de entrada de informa��o Modelo do ve�culo
	 */
	private String modelo;
	/**
	 * @param Campo
	 *            de entrada de informa��o Tipo Combust�vel do ve�culo
	 */
	private String combustivel;
	/**
	 * @param Campo
	 *            de entrada de informa��o Cor do ve�culo
	 */
	private String cor;
	
	/**
	 * @param Campo de entrada de informa��o Valor da Di�ria do ve�culo par aloca��o.
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