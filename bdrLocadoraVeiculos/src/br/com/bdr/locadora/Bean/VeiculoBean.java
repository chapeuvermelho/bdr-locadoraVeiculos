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
	 * Instacia ve�culo
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
	 * m�todo mapeado na vis�o, chama a valida��o de campos e se nao retornar
	 * erro delega para classe dao dar seguencia. ap�s instancia a entidade para
	 * limpar os dados dos componentes da tela.
	 */
	public void cadastra() {

		if (validarCampos()) {

			this.dao.salva(veiculo);
			this.veiculo = new Veiculo();

		}
	}

	/**
	 * Chamada para o m�todo remover do Dao, remove a entidade.
	 */
	public void remover(Veiculo veiculo) {
		dao.removerVeiculo(veiculo);
	}

	/**
	 * Este M�todo carrega os dados no formul�rio quando clicado na op��o Editar
	 * da Grid
	 */
	public void carregar(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	/**
	 * Chamada para o m�todo que lista todos as entidades;
	 */
	public List<Veiculo> getVeiculos() {
		return this.dao.todosVeiculos();
	}

	/**
	 * m�thodo de valida��o de campos
	 * 
	 */
	private boolean validarCampos() {

		/**
		 * Valida se Codigo � negativo mostra mensagem do contr�rio o Modelo
		 * setar� sempre 0, e a classe banco cria novo registro se este for null
		 * ou zero ou se numero n�o estiver em mem�ria.
		 */
		if (veiculo.getId() < 0) {
			FacesContext.getCurrentInstance().addMessage("id",
					new FacesMessage("Deixe em branco ou Zero (0) para seguir segu�ncia autom�tica."
							+ " Informe o C�digo e as Demais informa��es para Editar um Autom�vel."
							+ " Ou ainda poder� visualizar os dados para edi��o pelo link na grid a baixo."));
			return false;
		}

		/**
		 * Valida campo Placa, n�o pode ser nulo
		 */
		if (veiculo.getPlaca().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("placa",
					new FacesMessage("A placa � uma informa��o Obrigat�ria."));
			return false;
		}

		/**
		 * Valida campo Marca, n�o pode ser nulo
		 */
		if (veiculo.getMarca().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("ano",
					new FacesMessage("A marca � uma informa��o Obrigat�ria."));
			return false;
		}

		/**
		 * Valida campo Modelo, n�o pode ser nulo
		 */
		if (veiculo.getModelo().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("modelo",
					new FacesMessage("O modelo � uma informa��o Obrigat�ria."));
			return false;
		}

		/**
		 * Valida campo Combustivel, n�o pode ser nulo
		 */
		if (veiculo.getCombustivel().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("combustivel",
					new FacesMessage("O Combust�vel � uma informa��o Obrigat�ria."));
			return false;
		}

		/**
		 * Valida campo Cor, n�o pode ser nulo
		 */
		if (veiculo.getCor().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("cor",
					new FacesMessage("A cor � uma informa��o Obrigat�ria."));
			return false;
		}

		/**
		 * Valida campo Valor Di�ria, n�o pode ser nulo
		 */
		if (veiculo.getVl_diaria() == null || veiculo.getVl_diaria() < 150) {
			FacesContext.getCurrentInstance().addMessage("vl_diaria",
					new FacesMessage("O Valor m�nimo para loca��o di�ria � R$ 150,00."));
			return false;
		}

		/**
		 * Se todos ok retorna verdadeiro para proseguir sen�o devolve msg para
		 * usu�rio na tela.
		 */
		return true;

	}

}