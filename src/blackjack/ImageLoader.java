package blackjack;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.imageio.ImageIO;

import util.Carta;

/**
 * Carrega imagens inteiras e também partes de uma imagem.
 * 
 * @author Carlos A.
 * @version 0.1
 *
 */
public class ImageLoader {
	
	private HashMap<String,BufferedImage> map;
	
	/**
	 * Inicializa as variáveis de classe.
	 */
	public ImageLoader() {
		map = new HashMap<String, BufferedImage>();
	}
	
	/**
	 * Carrega as subimagens. Cada imagem é armazenada individualmente de acordo com
	 * os respectivos nomes de carta e adicionada no mapa nomeando-os
	 * adequadamente.
	 * 
	 * @param filename O nome do arquivo a processar.
	 * @param sliceWidth A largura da subimagem.
	 * @param sliceHeight A altura da subimagem.
	 */
	public void loadMultipleImages(String filename, int sliceWidth, int sliceHeight){
		BufferedImage image = null;
		int currentPositionX = 0;
		int currentPositionY = 0;
		
		try{
			image = ImageIO.read(this.getClass().getResourceAsStream(filename));
		}catch(Exception e){
			System.err.println("Não foi possível carregar o arquivo de imagem.");
		}
		for(int i = Carta.primeiroNaipe(); i <= Carta.ultimoNaipe(); i++){
			for(int j = Carta.menorValor(); j <= Carta.maiorValor(); j++){
				map.put("" + Carta.nomeDeCarta[j] + " DE " + Carta.nomeDeNaipe[i], image.getSubimage(currentPositionX, currentPositionY, sliceWidth, sliceHeight));
				currentPositionX += sliceWidth;
			}
			currentPositionX = 0;
			currentPositionY += sliceHeight;
		}
		map.put("VERSO", image.getSubimage(2 * sliceWidth, 4 * sliceHeight, sliceWidth, sliceHeight));
	}
	
	/**
	 * Retorna uma imagem de carta, especificada pelo nome da carta.
	 * 
	 * @param cardName O nome da carta.
	 * @return A imagem correspondente da carta.
	 */
	public BufferedImage getSubImage(String cardName){
		BufferedImage subImage = null;
		if(!map.isEmpty()){
			subImage = map.get(cardName);
		}
		return subImage;
	}
	
	/**
	 * Carrega e retorna a imagem do botão especificado no parâmetro buttonName.
	 * 
	 * @param buttonName O nome do botão a ser carregado.
	 * @return A imagem do respectivo botão.
	 */
	public BufferedImage getImage(String buttonName){
		BufferedImage image = null;
		try{
			image = ImageIO.read(this.getClass().getResourceAsStream(buttonName));
		}catch(Exception e){
			System.err.println("Não foi possível carregar o arquivo de imagem.");
		}
		return image;
	}
}
