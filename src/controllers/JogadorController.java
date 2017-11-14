package controllers;
import java.util.Scanner;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.game.Participante;

public class JogadorController {
	public boolean hasPlusPoints;
	public static String nome;
	
	@FXML
	protected TextField nomePlayer;
	
	
	@FXML
	protected void initialize() {
		Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
					System.out.println("Entrou na tela do jogador");
			}
		});	
	}
	@FXML
	protected Button iniciar;
	
	@FXML
	protected void btnIniciarPartida(ActionEvent e) {
		nome = nomePlayer.getText();			
		Main.changeScreen("iniciarRodada", novoParticipante(0));
	}
	public Participante novoParticipante(int pontos){
		Participante p = new Participante();
		p.setNome(nome);
		p.setPontos(pontos);
		
		return p;
	}
}
