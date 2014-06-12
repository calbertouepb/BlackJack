package blackjack;

import java.awt.Toolkit;

import javax.swing.JFrame;

public class BlackJackGame {
	public static void main(String[] args){
	
		JFrame frame = new JFrame();
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		
		final int SCREEN_WIDTH = (int) toolkit.getScreenSize().getWidth();
		final int SCREEN_HEIGHT = (int) toolkit.getScreenSize().getHeight();
		
		frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
		frame.setTitle("BlackJack Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GamePanel gamePanel = new GamePanel();
		
		frame.add(gamePanel);
		frame.setVisible(true);
	}
}
