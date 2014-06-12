package blackjack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.Baralho;

public class GamePanel extends JPanel{
	private final int PANEL_WIDTH = super.getWidth();
	private final int PANEL_HEIGHT = super.getHeight();
	private BufferedImage background;
	private ClickButtonListener buttonListener;
	private ImageLoader loader;
	private Baralho baralho;
	private MaoBlackJack minhaMao, outraMao;
	private StringTokenizer minhasCartas, outrasCartas;
	
	private JPanel sidePanel, dealerCards, myCards;
	private JLabel hitButton, standButton, againButton, exitButton;
	private ImageIcon hitButtonImage1, hitButtonImage2, standButtonImage1, standButtonImage2,
	againButtonImage1, againButtonImage2, exitButtonImage1, exitButtonImage2;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public GamePanel(){
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		this.setLayout(new BorderLayout());
		
		loader = new ImageLoader();
		loader.loadMultipleImages("/images/allCards.png", 165, 240);
		
		baralho = new Baralho();
		minhaMao = new MaoBlackJack();
		outraMao = new MaoBlackJack();
		
		background = loader.getImage("/images/background.jpg");
		
		hitButtonImage1 = new ImageIcon(loader.getImage("/images/buttons/hitButton1.png"));
		hitButtonImage2 = new ImageIcon(loader.getImage("/images/buttons/hitButton2.png"));
		standButtonImage1 = new ImageIcon(loader.getImage("/images/buttons/standButton1.png"));
		standButtonImage2 = new ImageIcon(loader.getImage("/images/buttons/standButton2.png"));
		againButtonImage1 = new ImageIcon(loader.getImage("/images/buttons/againButton1.png"));
		againButtonImage2 = new ImageIcon(loader.getImage("/images/buttons/againButton2.png"));
		exitButtonImage1 = new ImageIcon(loader.getImage("/images/buttons/exitButton1.png"));
		exitButtonImage2 = new ImageIcon(loader.getImage("/images/buttons/exitButton2.png"));
		
		buttonListener = new ClickButtonListener();
		
		this.startGame();
	}
	
	private void startGame(){
		
		sidePanel = new JPanel(new FlowLayout());
		sidePanel.setOpaque(false);
		
		hitButton = new JLabel(hitButtonImage1);
		hitButton.setName("hit");
		hitButton.addMouseListener(buttonListener);
		
		standButton = new JLabel(standButtonImage1);
		standButton.setName("stand");
		standButton.addMouseListener(buttonListener);
	
		againButton = new JLabel(againButtonImage1);
		againButton.setName("again");
		againButton.addMouseListener(buttonListener);
		
		exitButton = new JLabel(exitButtonImage1);
		exitButton.setName("exit");
		exitButton.addMouseListener(buttonListener);
		
		baralho.baralhar();
		
		minhaMao.recebeCarta(baralho.pegaCarta());
		outraMao.recebeCarta(baralho.pegaCarta());
		minhaMao.recebeCarta(baralho.pegaCarta());
		outraMao.recebeCarta(baralho.pegaCarta());
		
		this.run();
	}
	
	private void stopGame(){
	}
	
	private void run(){
		this.gameRender();
		this.gameUpdate();
		this.stopGame();
}
	
	private void gameUpdate(){
		
	}
	
	private void gameRender(){
		//cria os botoes
		sidePanel.add(hitButton);
		sidePanel.add(standButton);
		System.out.println(outraMao.toString());
		//cria as listas de cartas
		outrasCartas = new StringTokenizer(outraMao.toString(), ",");
		outrasCartas.nextToken();
		minhasCartas = new StringTokenizer(minhaMao.toString(), ",");
		//desenha a carta oculta do dealer
		JLabel cartaOculta = new JLabel(new ImageIcon(loader.getSubImage("VERSO")));
		dealerCards = new JPanel(new FlowLayout());
		dealerCards.setOpaque(false);;
		dealerCards.add(cartaOculta);
		JLabel minhaCarta = new JLabel(new ImageIcon(loader.getSubImage(minhasCartas.nextToken())));
		myCards = new JPanel(new FlowLayout());
		myCards.setOpaque(false);
		myCards.add(minhaCarta);
		//desenha as cartas
		while(minhasCartas.hasMoreTokens()){
			JLabel novaCarta = new JLabel(new ImageIcon(loader.getSubImage(outrasCartas.nextToken())));
			dealerCards.add(novaCarta);
			novaCarta = new JLabel(new ImageIcon(loader.getSubImage(minhasCartas.nextToken())));
			myCards.add(novaCarta);
		}
		//adiciona os paineis
		this.add(sidePanel, BorderLayout.EAST);
		this.add(dealerCards, BorderLayout.NORTH);
		this.add(myCards, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, this.getWidth(), this.getHeight(), this);
	}
	
	class ClickButtonListener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			switch(e.getComponent().getName()){
			case "hit":
				minhaMao.recebeCarta(baralho.pegaCarta());
				outraMao.recebeCarta(baralho.pegaCarta());
				gameRender();
				break;
			case "stand":
				// TODO
				break;
			case "again":
				startGame();
				break;
			case "exit":
				System.exit(0);
				break;
			}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			switch(e.getComponent().getName()){
			case "hit":
				hitButton.setIcon(hitButtonImage2);
				break;
			case "stand":
				standButton.setIcon(standButtonImage2);
				break;
			case "again":
				againButton.setIcon(againButtonImage2);
				break;
			case "exit":
				exitButton.setIcon(exitButtonImage2);
				break;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			switch(e.getComponent().getName()){
			case "hit":
				hitButton.setIcon(hitButtonImage1);
				break;
			case "stand":
				standButton.setIcon(standButtonImage1);
				break;
			case "again":
				againButton.setIcon(againButtonImage1);
				break;
			case "exit":
				exitButton.setIcon(exitButtonImage1);
				break;
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}
	}
}
