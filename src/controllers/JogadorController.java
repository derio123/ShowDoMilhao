package controllers;
import java.util.Scanner;

import model.game.Participante;
import model.game.Questionario;

public class JogadorController {
	public boolean hasPlusPoints;
	String nome = null;
	

	public void escreverNome(Scanner entry){
		System.out.println("Insira seu Nome: ");
		nome = entry.nextLine();
	}
	/*
	public void verificarPontos(float pontos){
		Participante player = new Participante();
		player.setNome(nome);
		player.setPontos((int) pontos);
		
		List<Participante> lista = 
		for
		boolean isRanked = super.db.adicionarParticipante(player);
		
		/*
		if(isRanked){
			for() {
				int pontos = plays.getIndex(i).getPoint;
			}
		}
		*/
}
