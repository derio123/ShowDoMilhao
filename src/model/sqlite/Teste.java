package model.sqlite;

import java.util.ArrayList;
import java.util.List;

import model.game.Participante;

public class Teste {

	public static void main(String[] args) {
		ParticipanteDAO db = new ParticipanteDAO();
		Participante jogador = new Participante();
		
		List<Participante> listaP = db.listarRanking();
		for(Participante p:listaP) {
			System.out.println("Nome: "+p.getNome()+" Pontos: "+p.getPontos());
		}
		
	}
}