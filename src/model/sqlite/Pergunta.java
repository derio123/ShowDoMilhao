package model.sqlite;

public class Pergunta {
	int id;
	String pergunta;
	String numero1;
	String numero2;
	String numero3;
	String numero4;
	int resposta;
	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getNumero1() {
		return numero1;
	}
	public void setNumero1(String numero1) {
		this.numero1 = numero1;
	}
	public String getNumero2() {
		return numero2;
	}
	public void setNumero2(String numero2) {
		this.numero2 = numero2;
	}
	public String getNumero3() {
		return numero3;
	}
	public void setNumero3(String numero3) {
		this.numero3 = numero3;
	}
	public String getNumero4() {
		return numero4;
	}
	public void setNumero4(String numero4) {
		this.numero4 = numero4;
	}
	public int getResposta() {
		return resposta;
	}
	public void setResposta(int resposta) {
		this.resposta = resposta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
