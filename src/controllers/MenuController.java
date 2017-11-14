package controllers;

import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {
	
	@FXML
	protected void btnIniciar(ActionEvent e) {
		Main.changeScreen("novoJogador");
	}
	@FXML
	protected void btnVerPlacar(ActionEvent e) {
		Main.changeScreen("ranking");
	}
	@FXML
	protected void btnEditarPerguntas(ActionEvent e) {
		Main.changeScreen("editarPergunta");
	}
	@FXML
	protected void btnSair(ActionEvent e) {
		System.exit(0);
	}
}
