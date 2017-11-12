package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {
	@FXML
	protected void btniniciarRodada(ActionEvent e) {
		Mainoff.changeScreen("iniciarRodada");
	}
}
