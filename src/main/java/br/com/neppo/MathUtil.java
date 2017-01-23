package br.com.neppo;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {

	/**
	 * Dado um conjunto de números inteiros "ints" e um número arbitrário "sum",
	 * retorne true caso exista pelo menos um subconjunto de "ints" cuja soma
	 * soma dos seus elementos seja igual a "sum"
	 *
	 * @param ints
	 *            Conjunto de inteiros
	 * @param sum
	 *            Soma para o subconjunto
	 * @return
	 * @throws IllegalArgumentException
	 *             caso o argumento "ints" seja null
	 * 
	 *             public static boolean subsetSumChecker(int ints[], int sum)
	 *             throws Exception { throw new
	 *             UnsupportedOperationException("Please implement me."); }
	 */

	public static boolean subsetSumChecker(int[] ints, int sum) {
		if(ints == null || ints.length == 0){
			throw new IllegalArgumentException("Conjunto nao pode ser nulo!");
		}
		
		if(sum == 0){
			//conjunto vazio (soma = 0)
			return true;
		}
		
		List<int[]> combinacoes = new ArrayList<>();
		
		// gera as combinações de todos os subconjuntos possíveis
		gerarCombinacoes(ints, combinacoes);

		int soma = 0;
		
		//para cada subconjunto gerado, faz a soma de todos os elementos e verifica se o valor final 
		//é igual ao parâmetro sum
		for (int[] combinacao : combinacoes) {
			
			for (int num : combinacao) {
				soma = soma + num;
			}

			if (sum == soma) {
				return true;
			}
		}

		return false;

	}

	private static void gerarCombinacoes(int[] ints, List<int[]> combinacoes) {
		if (ints.length == 1) {
			return;
		}

		// cria um vetor com uma posição a menos que o vetor inicial
		int[] combinacao = new int[ints.length - 1];

		// a partir do vetor inicial, cria-se todas a combinações possíveis
		// com uma posição a menos do vetor inicial
		for (int i = 0; i < ints.length; i++) {
			int index = 0;
			for (int j = 0; j < ints.length; j++) {
				if (i != j) {
					combinacao[index] = ints[j];
					index++;
				}
			}

			//só adiciona no array de combinações caso ele ainda não exista
			if (!existe(combinacao, combinacoes)) {
				combinacoes.add(combinacao);
				
				//recursividade
				//chama o mesmo método para cada combinação gerada, até chegar a
				//um vetor com apenas 1 posição
				gerarCombinacoes(combinacao, combinacoes);
			}

			combinacao = new int[ints.length - 1];
		}

	}

	private static boolean existe(int[] combinacao, List<int[]> combinacoes) {
		for (int[] combinacaoExistente : combinacoes) {
			if (combinacaoExistente.length == combinacao.length) {
				boolean eIgual = true;

				for (int i = 0; i < combinacao.length; i++) {
					if (combinacao[i] != combinacaoExistente[i]) {
						eIgual = false;
					}

				}

				if (eIgual) {
					return true;
				}

			}
		}

		return false;
	}
}