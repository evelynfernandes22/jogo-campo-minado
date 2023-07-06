package br.com.evelyn.cm.model;

import java.util.ArrayList;
import java.util.List;

import br.com.evelyn.cm.exception.ExplosaoException;

public class Campo {

	private final int linha;
	private final int coluna;
	private boolean aberto = false;
	private boolean minado = false;
	private boolean marcado = false;
	private List<Campo> vizinhos = new ArrayList<>();
	
	Campo (int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	boolean adicionarVizinho(Campo vizinho) {
		boolean linhaDiferente = this.linha != vizinho.linha;
		boolean colunaDiferente = this.coluna != vizinho.coluna;
		boolean diagonal = linhaDiferente && colunaDiferente;
		
		int distanciaLinha = Math.abs(this.linha - vizinho.linha);
		int distanciaColuna = Math.abs(this.coluna - vizinho.coluna);
		
		int somatorioGeral = distanciaLinha + distanciaColuna;
		
		if(somatorioGeral == 1 && !diagonal) {
			vizinhos.add(vizinho);
			return true;
		}else if(somatorioGeral == 2 && diagonal) {
			vizinhos.add(vizinho);
			return true;
		}
		return false;
	}
	
	void alternarMarcacao() {
		if(!aberto) {
			marcado = !marcado;
		}
	}
	
	boolean abrir() {
		
		if(!aberto && !marcado) {
			aberto = true;
			
			if(minado) {
				throw new ExplosaoException();
			}
			if(vizinhancaSegura()) {
				vizinhos.forEach(v -> v.abrir());
			}
			return true;
		}
		return false;
	}
	
	boolean vizinhancaSegura() {
		return vizinhos.stream()
				.noneMatch(v -> v.minado);
	}
	
}
