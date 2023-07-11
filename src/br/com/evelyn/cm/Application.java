package br.com.evelyn.cm;

import br.com.evelyn.cm.model.Tabuleiro;
import br.com.evelyn.cm.view.TabuleiroConsole;

public class Application {

	public static void main(String[] args) {

		Tabuleiro tabuleiro = new Tabuleiro(7, 7, 7);
		
		new TabuleiroConsole(tabuleiro);

	}

}
