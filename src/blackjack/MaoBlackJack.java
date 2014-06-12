package blackjack;

import java.util.Iterator;

import util.Carta;
import util.Mao;

/**
 * Mão de Vinte e Um. Começa com duas cartas e pode receber mais cartas
 * conforme necessário.
 * 
 * @author Carlos A.
 * @version 0.1
 *
 */
public class MaoBlackJack extends Mao {

	/**
	 * O valor da mão corrente.
	 */
	private int valor;

	/**
	 * Constroi uma mão de cartas vazia.
	 */
	public MaoBlackJack() {
		super();
		valor = 0;
	}

	/**
	 * Processa as cartas na mão e calcula o valor corrente da mão no momento.
	 * AS vale 1 ou 11, VALETE, DAMA e REI valem 10 cada.
	 */
	private void atualizaValor(){
		
		Iterator<Carta> iterador = mao.iterator();
		boolean contemAs = false;
		valor = 0;
		while(iterador.hasNext()){
			Carta carta = iterador.next();
			switch(carta.getValor()){
			case Carta.AS:
				if(valor <= 10){
					valor += 11;
				}else{
					valor += 1;
				}
				contemAs = true;
				break;
			case Carta.VALETE:
				if((contemAs && mao.size() == 2) || (!contemAs)){
					valor += 10;
				}
				break;
			case Carta.DAMA:
				if((contemAs && mao.size() == 2) || (!contemAs)){
					valor += 10;
				}
				break;
			case Carta.REI:
				if((contemAs && mao.size() == 2) || (!contemAs)){
					valor += 10;
				}
				break;
			default:
				valor += carta.getValor();
			}
		}
	}
	
	/**
	 * Retorna o valor da mão corrente. VALETE, DAMA e REI valem 10 pontos. AS
	 * vale 1 ou 11 pontos, dependendo do valor das outras cartas na mão.
	 * 
	 * @return O valor da mão corrente.
	 */
	public int valor(){
		return valor;
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
			atualizaValor();
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
			atualizaValor();
		}
		return removeu;
	}
}
