package br.com.bdr.locadora.Bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.bdr.locadora.Dao.VeiculoDao;
import br.com.bdr.locadora.Modelo.Veiculo;

/**
 * Classe que representa o Controler
 */
@ManagedBean
public class VeiculoBean {

	/**
	 * Instacia veículo
	 */
	private Veiculo veiculo = new Veiculo();

	/**
	 * Instacia Dao
	 */
	private VeiculoDao dao = new VeiculoDao();

	public Veiculo getVeiculo() {
		return veiculo;
	}

	/**
	 * método mapeado na visão, chama a validação de campos e se nao retornar
	 * erro delega para classe dao dar seguencia. após instancia a entidade para
	 * limpar os dados dos componentes da tela.
	 */
	public void cadastra() {

		if (validarCampos()) {

			this.dao.salva(veiculo);
			this.veiculo = new Veiculo();

		}
	}

	/**
	 * Chamada para o método remover do Dao, remove a entidade.
	 */
	public void remover(Veiculo veiculo) {
		dao.removerVeiculo(veiculo);
	}

	/**
	 * Este Método carrega os dados no formulário quando clicado na opção Editar
	 * da Grid
	 */
	public void carregar(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * Chamada para o método que lista todos as entidades;
	 */
	public List<Veiculo> getVeiculos() {
		return this.dao.todosVeiculos();
	}

	/**
	 * méthodo de validação de campos
	 * 
	 */
	private boolean validarCampos() {

		/**
		 * Valida se Codigo é negativo mostra mensagem do contrário o Modelo
		 * setará sempre 0, e a classe banco cria novo registro se este for null
		 * ou zero ou se numero não estiver em memória.
		 */
		if (veiculo.getId() < 0) {
			FacesContext.getCurrentInstance().addMessage("id",
					new FacesMessage("Deixe em branco ou Zero (0) para seguir seguência automática."
							+ " Informe o Código e as Demais informações para Editar um Automóvel."
							+ " Ou ainda poderá visualizar os dados para edição pelo link na grid a baixo."));
			return false;
		}

		/**
		 * Valida campo Placa, não pode ser nulo
		 */
		if (veiculo.getPlaca().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("placa",
					new FacesMessage("A placa é uma informação Obrigatória."));
			return false;
		}

		/**
		 * Valida campo Marca, não pode ser nulo
		 */
		if (veiculo.getMarca().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("ano",
					new FacesMessage("A marca é uma informação Obrigatória."));
			return false;
		}

		/**
		 * Valida campo Modelo, não pode ser nulo
		 */
		if (veiculo.getModelo().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("modelo",
					new FacesMessage("O modelo é uma informação Obrigatória."));
			return false;
		}

		/**
		 * Valida campo Combustivel, não pode ser nulo
		 */
		if (veiculo.getCombustivel().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("combustivel",
					new FacesMessage("O Combustível é uma informação Obrigatória."));
			return false;
		}

		/**
		 * Valida campo Cor, não pode ser nulo
		 */
		if (veiculo.getCor().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("cor",
					new FacesMessage("A cor é uma informação Obrigatória."));
			return false;
		}

		/**
		 * Valida campo Valor Diária, não pode ser nulo
		 */
		if (veiculo.getVl_diaria() == null || veiculo.getVl_diaria() < 150) {
			FacesContext.getCurrentInstance().addMessage("vl_diaria",
					new FacesMessage("O Valor mínimo para locação diária é R$ 150,00."));
			return false;
		}

		/**
		 * Se todos ok retorna verdadeiro para proseguir senão devolve msg para
		 * usuário na tela.
		 */
		return true;

	}

}