package blackjack;

import util.Baralho;

public class BlackJack {

	Baralho baralho = new Baralho();
	MaoBlackJack minhaMao = new MaoBlackJack();
	MaoBlackJack outraMao = new MaoBlackJack();
	boolean gameOver = false;
	int valorMinhaMao = 0;
	int valorOutraMao = 0;
	
	/*
	 * Embaralha o baralho antes de começar o jogo.
	 */
	public void embaralhar(){
		baralho.baralhar();
	}
	
	/*
	 * Puxa as 2 cartas inicias do jogador e da mesa, e guarda os valores das mãos.
	 */
	public void iniciarPartida(){
		if(!gameOver){
			minhaMao.recebeCarta(baralho.pegaCarta());
			outraMao.recebeCarta(baralho.pegaCarta());
			minhaMao.recebeCarta(baralho.pegaCarta());
			outraMao.recebeCarta(baralho.pegaCarta());
			valorMinhaMao = minhaMao.valor();
			valorOutraMao = outraMao.valor();
		}
	}
	
	/*
	 * Se as mãos dos jogadores estiverem abaixo de 21, puxam cada um uma carta.
	 */
	public void deal(){
		if(!gameOver){
			if(valorMinhaMao < 21 && valorOutraMao < 21){
				minhaMao.recebeCarta(baralho.pegaCarta());
				valorMinhaMao = minhaMao.valor();
				outraMao.recebeCarta(baralho.pegaCarta());
				valorOutraMao = outraMao.valor();
			}else{
				gameOver = true;
				verificarFimDeJogo();
			}
		}
	}
	
	/*
	 * Se a mão da mesa estiver abaixo de 17, puxa uma carta.
	 */
	public void stand(){
		if(!gameOver){
			if(valorOutraMao <= 17){
				outraMao.recebeCarta(baralho.pegaCarta());
				valorOutraMao = outraMao.valor();
			}else{
				gameOver = true;
				verificarFimDeJogo();
			}
		}
	}
	
	/*
	 * Verifica as mãos e diz quem venceu a partida.
	 */
	public void verificarFimDeJogo(){
		if(gameOver) {
			
		}
	}
	
	/*public static void main(String[] args){

		Baralho baralho = new Baralho();
		MaoBlackJack minhaMao = new MaoBlackJack();
		MaoBlackJack outraMao = new MaoBlackJack();
		boolean gameOver = false;
		int valorMinhaMao = 0;
		int valorOutraMao = 0;

		baralho.baralhar();
		while(!gameOver){
			minhaMao.recebeCarta(baralho.pegaCarta());
			outraMao.recebeCarta(baralho.pegaCarta());
			minhaMao.recebeCarta(baralho.pegaCarta());
			outraMao.recebeCarta(baralho.pegaCarta());
			valorMinhaMao = minhaMao.valor();
			valorOutraMao = outraMao.valor();
			while(valorMinhaMao < 21 && valorOutraMao < 21){
				minhaMao.recebeCarta(baralho.pegaCarta());
				valorMinhaMao = minhaMao.valor();
				outraMao.recebeCarta(baralho.pegaCarta());
				valorOutraMao = outraMao.valor();
			}
			gameOver = true;
			System.out.println(minhaMao);
			System.out.println("Valor: " + minhaMao.valor());
			System.out.println(outraMao);
			System.out.println("Valor: " + outraMao.valor());
		}
	}*/

}
