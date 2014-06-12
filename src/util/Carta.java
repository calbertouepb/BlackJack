package util;

/**
 * Carta de baralho comum. Uma carta tem um valor (ÁS, UM, DOIS, TRÊS, QUATRO,
 * CINCO, SEIS, SETE, OITO, NOVE, DEZ, VALETE, DAMA, REI) e um naipe (PAUS,
 * OUROS, COPAS, ESPADAS).
 * 
 * @author Carlos A.
 * @version 0.1
 * 
 */
public class Carta {

	/**
	 * Valor do ÁS.
	 */
	public static final int AS = 1;

	/**
	 * Valor do VALETE.
	 */
	public static final int VALETE = 11;

	/**
	 * Valor da DAMA.
	 */
	public static final int DAMA = 12;

	/**
	 * Valor do REI.
	 */
	public static final int REI = 13;

	/**
	 * valor do naipe de PAUS.
	 */
	public static final int PAUS = 0;

	/**
	 * Valor do naipe de OUROS.
	 */
	public static final int OUROS = 1;

	/**
	 * Valor do naipe de COPAS.
	 */
	public static final int COPAS = 2;

	/**
	 * Valor do naipe de ESPADAS.
	 */
	public static final int ESPADAS = 3;

	/**
	 * O valor da carta.
	 */
	private int valor;

	/**
	 * O naipe da carta.
	 */
	private int naipe;

	/**
	 * Os nomes que as cartas podem ter.
	 */
	public static final String[] nomeDeCarta = {
		"",
		"AS",
		"DOIS",
		"TRES",
		"QUATRO",
		"CINCO",
		"SEIS",
		"SETE",
		"OITO",
		"NOVE",
		"DEZ",
		"VALETE",
		"DAMA",
		"REI"
	};

	/**
	 * Os naipes que as cartas podem ter.
	 */
	public static final String[] nomeDeNaipe = {
		"PAUS",
		"OUROS",
		"COPAS",
		"ESPADAS"
	};
	
	/**
	 * Constrói uma carta de baralho com o valor e o naipe passados como
	 * parâmetros. 
	 * @param valor O valor da carta.
	 * @param naipe O naipe da carta.
	 */
	public Carta(int valor, int naipe) {
		this.valor = valor;
		this.naipe = naipe;
	}

	/**
	 * Retorna o valor da carta.
	 * @return O valor da carta.
	 */
	public int getValor() {
		return this.valor;
	}

	/**
	 * Retorna o naipe da carta.
	 * @return O naipe da carta.
	 */
	public int getNaipe() {
		return this.naipe;
	}
	
	/**
	 * Retorna o menor valor de carta.
	 * @return O menor valor de carta.
	 */
	public static int menorValor() {
		return AS;
	}

	/**
	 * Retorna o maior valor de carta.
	 * @return O maior valor de carta.
	 */
	public static int maiorValor() {
		return REI;
	}

	/**
	 * Retorna o primeiro naipe.
	 * @return O primeiro naipe.
	 */
	public static int primeiroNaipe() {
		return PAUS;
	}

	/**
	 * Retorna o último naipe.
	 * @return O último naipe.
	 */
	public static int ultimoNaipe() {
		return ESPADAS;
	}

	/**
	 * Compara duas cartas de baralho
	 * @param outraCarta A carta a ser comparada.
	 * @return Zero se as cartas tiverem o mesmo valor, um valor maior que zero
	 * se o valor da carta for maior que o valor da outra carta e um valor menor
	 * que zero se o valor da carta for menor que o valor da outra carta.
	 */
	public int compareTo(Carta outraCarta) {
		return getValor() - outraCarta.getValor();
	}

	/**
	 * Testa se duas cartas são iguais.
	 * @param objeto Um objeto para comparar com esta carta.
	 * @return true caso o objeto seja igual a esta carta e false caso
	 * contrário.
	 */
	public boolean equals(Object objeto) {
		if(!(objeto instanceof Carta)){
			return false;
		}
		Carta outraCarta = (Carta) objeto;
		return getValor() == outraCarta.getValor()
				&& getNaipe() == outraCarta.getNaipe();
	}

	/**
	 * Retorna uma representação textual da carta.
	 * @return A string "VALOR DE NAIPE".
	 */
	public String toString() {
		return nomeDeCarta[getValor()] + " DE " + nomeDeNaipe[getNaipe()];
	}
}
