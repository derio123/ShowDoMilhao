package model.game;

import java.util.ArrayList;
import java.util.List;

import model.sqlite.ParticipanteDAO;

public class Ranking extends ParticipanteDAO{
	public void verificarPts(Participante p) {
		List<Participante> listaP = super.listarRanking();
		int cont = 0;
		for(Participante pDb:listaP) {
			if(p.getPontos() > pDb.getPontos() && cont < 10) {
				super.adicionarJogador(p);
			}
			cont++;
		}
	}
}
