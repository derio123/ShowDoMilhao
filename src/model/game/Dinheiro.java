package model.game;

public class Dinheiro{
	public float pontos = 0;
	
	public float analisarPontos(int numPerg, boolean acerto){
		
		if(numPerg == 1 && acerto) {
			pontos = 1;
		}else if(numPerg == 1) {
			pontos = 0;
		}
		if(numPerg == 2 && acerto) {
			pontos = 2;
		}else if(numPerg == 2) {
			pontos = 0.5f;
		}
		if(numPerg == 3 && acerto) {
			pontos = 3;
		}else if(numPerg == 3) {
			pontos = 1f;
		}
		if(numPerg == 4 && acerto) {
			pontos = 4;
		}else if(numPerg == 4) {
			pontos = 1.5f;
		}
		if(numPerg == 5 && acerto) {
			pontos = 5;
		}else if(numPerg == 5) {
			pontos = 2;
		}
		if(numPerg == 6 && acerto) {
			pontos = 10;
		}else if(numPerg == 6) {
			pontos = 2.5f;
		}
		if(numPerg == 7 && acerto) {
			pontos = 20;
		}else if(numPerg == 7) {
			pontos = 5;
		}
		if(numPerg == 8 && acerto) {
			pontos = 30;
		}else if(numPerg == 8) {
			pontos = 10;
		}
		if(numPerg == 9 && acerto) {
			pontos = 40;
		}else if(numPerg == 9) {
			pontos = 15;
		}
		if(numPerg == 10 && acerto) {
			pontos = 50;
		}else if(numPerg == 10) {
			pontos = 20;
		}
		if(numPerg == 11 && acerto) {
			pontos = 100;
		}else if(numPerg == 11) {
			pontos = 25;
		}
		if(numPerg == 12 && acerto) {
			pontos = 200;
		}else if(numPerg == 12) {
			pontos = 50;
		}
		if(numPerg == 13 && acerto) {
			pontos = 300;
		}else if(numPerg == 13) {
			pontos = 100;
		}
		if(numPerg == 14 && acerto) {
			pontos = 400;
		}else if(numPerg == 14) {
			pontos = 150;
		}
		if(numPerg == 15 && acerto) {
			pontos = 500;
		}else if(numPerg == 15) {
			pontos = 200;
		}
		if(numPerg == 16 && acerto) {
			pontos = 1000;
		}else if(numPerg == 16) {
			pontos = 0;
		}
		return pontos;
	}
	public String verMaleta() {
		String barras = "R$ ";
		
		/*
		barras = (pontos == 1 ? barras = barras + "R$ 1.000,00":"1111");
		barras = (pontos == 2 ? barras = barras + "R$ 2.000,00":"2222");
        barras = (pontos == 3 ? barras + "R$ 3.000,00":"");
        barras = (pontos == 4 ? "R$ 4.000,00":"");
        barras = (pontos == 5 ? "R$ 5.000,00":"");
        barras = (pontos == 10 ? "R$ 10.000,00":"");
        barras = (pontos == 20 ? "R$ 20.000,00":"");
        barras = (pontos == 30 ? "R$ 30.000,00":"");
        barras = (pontos == 40 ? "R$ 40.000,00":"");
        barras = (pontos == 50 ? "R$ 50.000,00":"");
        barras = (pontos == 100 ? "R$ 100.000,00":"");
        barras = (pontos == 200 ? "R$ 200.000,00":"");
        barras = (pontos == 300 ? "R$ 300.000,00":"");
        barras = (pontos == 400 ? "R$ 400.000,00":"");
        barras = (pontos == 500 ? "R$ 500.000,00":"");
        barras = (pontos == 1000 ? "R$ 1.000.000,00":"");
        */
		if(pontos == 0) {
			barras = barras + "0,00";
		}if(pontos == 0.5) {
			barras = barras + "500,00";
		}if(pontos == 1) {
			barras = barras + "1.000,00";
		}if(pontos == 1.5) {
			barras = barras + "1.500,00";
		}if(pontos == 2) {
			barras = barras + "2.000,00";
		}if(pontos == 2.5) {
			barras = barras + "2.500,00";
		}if(pontos == 3) {
			barras = barras + "3.000,00";
		}if(pontos == 4) {
			barras = barras + "4.000,00";
		}if(pontos == 5) {
			barras = barras + "5.000,00";
		}if(pontos == 10) {
			barras = barras + "10.000,00";
		}if(pontos == 15) {
			barras = barras + "15.000,00";
		}if(pontos == 20) {
			barras = barras + "20.000,00";
		}if(pontos == 25) {
			barras = barras + "25.000,00";
		}if(pontos == 30) {
			barras = barras + "30.000,00";
		}if(pontos == 40) {
			barras = barras + "40.000,00";
		}if(pontos == 50) {
			barras = barras + "50.000,00";
		}if(pontos == 100) {
			barras = barras + "100.000,00";
		}if(pontos == 150) {
			barras = barras + "150.000,00";
		}if(pontos == 200) {
			barras = barras + "200.000,00";
		}if(pontos == 300) {
			barras = barras + "300.000,00";
		}if(pontos == 400) {
			barras = barras + "400.000,00";
		}if(pontos == 500) {
			barras = barras + "500.000,00";
		}if(pontos == 1000) {
			barras = barras + "1.000.000,00";
		}
		return barras;
	}
}
