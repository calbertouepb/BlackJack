package util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Um baralho de cartas comum.
 * 
 * @author Carlos A.
 * @version 0.1
 * 
 */
public class Baralho {

	/**
	 * O baralho de cartas.
	 */
	protected ArrayList<Carta> baralho;

	/**
	 * Constrói um baralho padrão de cartas.
	 */
	public Baralho() {
		baralho = new ArrayList<Carta>();
		for(int valor = menorValor(); valor <= maiorValor(); valor++){
			for(int naipe = primeiroNaipe(); naipe <= ultimoNaipe(); naipe++){
				baralho.add(criaCarta(valor, naipe));
			}
		}
	}
	
	/**
	 * Cria uma carta de baralho.
	 * @param valor O valor da carta.
	 * @param naipe O naipe da carta.
	 * @return A carta criada.
	 */
	protected Carta criaCarta(int valor, int naipe) {
		return new Carta(valor, naipe);
	}
	
	/**
	 * Retorna o menor valor contido neste baralho.
	 * @return O menor valor contido no baralho.
	 */
	public int menorValor() {
		return Carta.menorValor();
	}
	
	/**
	 * Retorna o maior valor contido neste baralho.
	 * @return O maior valor contido no baralho.
	 */
	public int maiorValor() {
		return Carta.maiorValor();
	}
	/**
	 * Retorna o primeiro naipe do baralho.
	 * @return O primeiro naipe do baralho.
	 */
	public int primeiroNaipe() {
		return Carta.primeiroNaipe();
	}
	
	/**
	 * Retorna o último naipe do baralho.
	 * @return O último naipe do baralho.
	 */
	public int ultimoNaipe() {
		return Carta.ultimoNaipe();
	}
	
	/**
	 * Retorna o número de cartas atualmente no baralho.
	 * @return O número de cartas do baralho.
	 */
	public int numeroDeCartas() {
		return baralho.size();
	}
	
	/**
	 * Retorna um iterador para varrer o baralho.
	 * @return Um iterador do baralho.
	 */
	public Iterator<Carta> iterator() {
		return baralho.iterator();
	}
	
	/**
	 * Embaralha o baralho.
	 */
	public void baralhar() {
		for(int posicao = 0; posicao < numeroDeCartas() - 1; posicao++) {
			int novaPosicao = posicao +	
					(int)((numeroDeCartas() - posicao) * Math.random());
			Carta temp = (Carta)baralho.get(posicao);
			baralho.set(posicao, baralho.get(novaPosicao));
			baralho.set(novaPosicao, temp);
		}
	}
	
	/**
	 * Pega uma carta do baralho.
	 * @return A carta removida do baralho.
	 */
	public Carta pegaCarta() {
		if(numeroDeCartas() == 0){
			return null;
		}
		return (Carta) baralho.remove(numeroDeCartas() - 1);
	}
}
