package blackjack;

import util.Baralho;

public class BlackJackTest {

	public static void main(String[] args) {
		MaoBlackJack minhaMao = new MaoBlackJack();
		MaoBlackJack outraMao = new MaoBlackJack();
		Baralho baralho = new Baralho();
		
		baralho.baralhar();
		
		boolean gameOver = false;
		
		minhaMao.recebeCarta(baralho.pegaCarta());
		minhaMao.recebeCarta(baralho.pegaCarta());
		outraMao.recebeCarta(baralho.pegaCarta());
		outraMao.recebeCarta(baralho.pegaCarta());
		
		while(!gameOver){
			if(minhaMao.valor() >= 21 || outraMao.valor() >= 21){
				gameOver = true;
				System.out.print("Minha mão: " + minhaMao + "\nValor: " + minhaMao.valor() + "\n");
				System.out.print("Outra mão: " + outraMao + "\nValor: " + outraMao.valor() + "\n");
			}else{
				minhaMao.recebeCarta(baralho.pegaCarta());
				outraMao.recebeCarta(baralho.pegaCarta());
			}
		}
	}

}
