package util;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Mão de cartas. Uma mão pode ter qualquer número de cartas. Pode receber mais
 * cartas e descartar cartas atualmente na mão.
 * 
 * @author Carlos A.
 * @version 0.1
 *
 */
public class Mao {

	/**
	 * A mão de cartas.
	 */
	protected ArrayList<Carta> mao;

	/**
	 * Cria uma mão de cartas vazia.
	 */
	public Mao(){
		mao = new ArrayList<Carta>();
	}

	/**
	 * Recebe uma carta e a adiciona na mão corrente. Retorna true se a carta
	 * foi adicionada com sucesso. false caso contrário.
	 * 
	 * @param umaCarta
	 * @return true se a carta foi adicionada com sucesso, false caso contrário.
	 */
	public boolean recebeCarta(Carta umaCarta){
		boolean adicionou = false;
		if(umaCarta instanceof Carta){
			adicionou = mao.add(umaCarta);
		}
		return adicionou;
	}

	/**
	 * Descarta uma carta da mão corrente. Retorna true se a carta foi removida
	 * com sucesso. false caso contrário.
	 * 
	 * @param umaCarta
	 * @return true se a carta foi removida com sucesso, false caso contrário.
	 */
	public boolean descartaCarta(Carta umaCarta){
		boolean removeu = false;
		if(mao.size() > 0){
			removeu = mao.remove(umaCarta);
		}
		return removeu;
	}

	/**
	 * Retorna uma string contendo uma representação textual da mão corrente.
	 * 
	 * @return Uma string do tipo CARTA DE VALOR ou CARTA1 DE VALOR1,CARTA2 DE VALOR2, ...
	 */
	public String toString(){
		Iterator<Carta> iterador = mao.iterator();
		String estaMao = "";
		while(iterador.hasNext()){
			estaMao += iterador.next() + ",";
		}
		return estaMao;
	}
}
