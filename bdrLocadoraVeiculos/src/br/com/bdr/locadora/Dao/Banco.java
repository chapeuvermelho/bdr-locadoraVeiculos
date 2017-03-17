package br.com.bdr.locadora.Dao;

import java.util.ArrayList;
import java.util.List;

import br.com.bdr.locadora.Modelo.Veiculo;

public class Banco {
	
	/**
	 * instanciando array que armazenará os dados persistidos
	 */
	public static List<Veiculo> veiculos = new ArrayList<Veiculo>();

	/**
	 * @param cria a sequência para o ID sempre que for um novo cadastro
	 */
	private static int chave = 1;

	/**
	 * @param recebe a entidade Veiculo, verifica se existe um ID igual, se existir
	 * efetua alteração do contrário cria um novo registro
	 */
	public void save(Veiculo veiculo) {

		int verifica = 0;
		for (Veiculo busca : veiculos) {
			if (busca.getId() == veiculo.getId()) {
				verifica++;
			}
		}

		if (verifica > 0) {
			for (Veiculo x : veiculos) {
				if (x.getId() == veiculo.getId()) {
					x.setPlaca(veiculo.getPlaca());
					x.setMarca(veiculo.getMarca());
					x.setModelo(veiculo.getModelo());
					x.setCombustivel(veiculo.getCombustivel());
					x.setCor(veiculo.getCor());
					x.setVl_diaria(veiculo.getVl_diaria());
				}
			}
		} else {

			veiculo.setId(chave++);
			veiculos.add(veiculo);

		}
	}

	/**
	 * @param recebe a entidade e remove do array 
	 */
	public void remover(Veiculo rem) {
		veiculos.remove(rem);
	}

	/**
	 * retorna todos os registros
	 */
	public List<Veiculo> listaVeiculos() {
		return veiculos;
	}

}
