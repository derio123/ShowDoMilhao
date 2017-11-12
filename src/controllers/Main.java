package controllers;

import java.util.ArrayList;
import java.util.Scanner;

//import controller.Main.OnChangeScreen;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.sqlite.Pergunta;

public class Main {
	public static void main(String[] args) {
		System.out.println(">>>>>>> Show do Milhão <<<<<<<");
		RodadaController partida = new RodadaController();
		
		partida.iniciarRodada();
	}
}
