package br.com.evelyn.cm.view;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import br.com.evelyn.cm.exception.ExplosaoException;
import br.com.evelyn.cm.exception.SairException;
import br.com.evelyn.cm.model.Tabuleiro;

public class TabuleiroConsole {

	private Tabuleiro tabuleiro;
	private Scanner scan = new Scanner(System.in);

	public TabuleiroConsole(Tabuleiro tabuleiro) {
		this.tabuleiro = tabuleiro;
		
		executarJogo();
	}

	private void executarJogo() {
		try {
			boolean continuar = true;
			
			while(continuar) {
				
				cicloDoJogo();
				
				System.out.println("Outra partida? (S/n");
				String resposta = scan.nextLine();
				
				if("n".equalsIgnoreCase(resposta)) {
					continuar = false;
				} else {
					tabuleiro.reinicializar();
				}
			}
			
		} catch (SairException e) {
			System.out.println("Bye!!");
		}finally {
			scan.close();
		}
		
	}

	private void cicloDoJogo() {
		try {
			
			while(!tabuleiro.objetivoAlcancado()) {
				System.out.println(tabuleiro);
				
				String digitado = capturarValorDigitado("Digite (x, y): ");
				
				Iterator<Integer> xy = Arrays.stream(digitado.split(","))
						.map(e -> Integer.parseInt(e.trim())).iterator();
				
				digitado = capturarValorDigitado("1 - abrir ou 2 - (Des)Marcar: ");
				
				if("1".equals(digitado)) {
					tabuleiro.abrir(xy.next(), xy.next());
				}else if("2".equals(digitado)) {
					tabuleiro.alternarMarcacao(xy.next(), xy.next());
				}
			}
			
			System.out.println("Congratulations!!");
		} catch (ExplosaoException e) {
			System.out.println(tabuleiro);
			System.out.println("Game Over!!");
		}
		
	}
	
	private String capturarValorDigitado(String texto) {
		System.out.print(texto);
		
		String digitado = scan.nextLine();
		
		if("sair".equalsIgnoreCase(digitado)) {
			throw new SairException();
		}
		return digitado;
	}
	
//	tabuleiro.abrir(4, 4);
//	tabuleiro.alternarMarcacao(5, 5);
//	tabuleiro.alternarMarcacao(4, 6);
//	
//	System.out.println(tabuleiro);
}
