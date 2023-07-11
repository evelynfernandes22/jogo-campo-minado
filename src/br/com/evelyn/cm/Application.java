package br.com.evelyn.cm;

import br.com.evelyn.cm.model.Tabuleiro;

public class Application {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(7, 7, 7);
		tabuleiro.abrir(4, 4);
		tabuleiro.alternarMarcacao(5, 5);
		tabuleiro.alternarMarcacao(4, 6);
		
		System.out.println(tabuleiro);

	}

}
