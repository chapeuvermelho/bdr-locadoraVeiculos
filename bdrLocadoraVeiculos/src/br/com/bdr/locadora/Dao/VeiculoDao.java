package br.com.bdr.locadora.Dao;

import java.util.List;

import br.com.bdr.locadora.Modelo.Veiculo;

/**
 * Classe DAO, responsavel pela comunicação com o banco de dados
 * */
public class VeiculoDao {

	/**
	 * @param instancia de Classe Banco, utilizada para simular um banco em memória
	 * */
	private Banco banco = new Banco();

	/**
	 * @param Método que simula a chamada para persistir os dados
	 * em banco fará a persistencia em memoria no arraylist
	 * recebe e envia a entidade veiculo
	 * */
	public void salva(Veiculo veiculo) {
		banco.save(veiculo);
	}

	/**
	 * @param efetua chamada para listar todos os dados cdastrados
	 * */
	public List<Veiculo> todosVeiculos() {
		return banco.listaVeiculos();
	}

	/**
	 * @param efetua chamada para remover a entidade da memória
	 * */
	public void removerVeiculo(Veiculo rem) {
		banco.remover(rem);
	}

}
