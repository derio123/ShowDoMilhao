package model.sqlite;
/**
* @descrition Classe Dao que realiza toda a manipulação pura com o banco de dados.
* @date 10-24-2017
* @author Gabriel Ripardo
*/

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.game.Participante;

public class PerguntasDAO {
private Connection conexao;
private boolean isEmpty;

	public PerguntasDAO(){
		conexao = null;
		isEmpty = true;
		criarTables();
	}
	public void abrirConexao() {
		if(this.conexao == null){
			this.conexao = new ConnectionAgenda().getConnection();
		}
	}
	void criarTables() {
		try {                              

			this.abrirConexao();
			String sql1 = "create table if not exists perguntas(id integer primary key not null, pergunta varchar(60), numero1 varchar(15), numero2 varchar(15) , numero3 varchar(15), numero4 varchar(15), resposta int)";
			PreparedStatement stmt1 = this.conexao.prepareStatement(sql1);
			String sql2 = "create table if not exists participantes(id integer primary key not null, nome varchar(20), pontos int)";
			PreparedStatement stmt2 = this.conexao.prepareStatement(sql2);
			
			stmt1.execute();
			stmt1.close();
			stmt2.execute();
			stmt2.close();
			isEmpty = false;
		}catch(SQLException e) {
			System.out.print("Não foi possível criar campos! "+e);
		}finally {
			this.fecharConexao();
		}
	}
	public int verificarTotal(){
		int totalPerg = 0;
		
		try {
			abrirConexao();
			String sqlSelect = "select * from perguntas";
			PreparedStatement stmt = this.conexao.prepareStatement(sqlSelect);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				totalPerg++;
			}
			rs.close();
			stmt.close();
		}catch(SQLException e) {
			System.out.print("Ocorrreu um erro ao verificar!");
		}
		finally {
			this.fecharConexao();
		}
		return totalPerg;
	}
	public Pergunta buscarId(int question) { 
		try {
			this.abrirConexao();
			String sql = "select * from perguntas where id = ?";
			PreparedStatement stmt = this.conexao.prepareStatement(sql);
			stmt.setInt(1, question);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Pergunta p = new Pergunta();
				p.setPergunta(rs.getString("PERGUNTA")); // Inseri o valor de Nome do DB em um objeto pontato
				p.setNumero1(rs.getString("NUMERO1"));
				p.setNumero2(rs.getString("NUMERO2"));
				p.setNumero3(rs.getString("NUMERO3"));
				p.setNumero4(rs.getString("NUMERO4"));
				p.setResposta(rs.getInt("RESPOSTA"));
				p.setId(rs.getInt("ID"));
				return p;
			}
			rs.close();
			stmt.close();
			
		}catch(SQLException e) {
			System.out.println("Erro ao listar pergunta: "+e);
		}finally {
			this.fecharConexao();
		}
		return null; 
	}
	public void fecharConexao() {
		try{
			if(this.conexao != null){
				this.conexao.close();
				this.conexao = null;
			}
		}catch(SQLException e){
			if(isEmpty) {
				this.criarTables();
				this.fecharConexao();
			}
		}
	}
	/*
	public void realocarContatos() {
		int setId = 0;
		List<Contato> contatos = this.listarData();
		Contato conta = new Contato();
		for(Contato c:contatos) {
			conta.setId(c.getId());
			setId++;
		}
		try{
			this.abrirConexao();
				String sql = "update contatos set id=? where id=?";
				PreparedStatement stmt = this.conexao.prepareStatement(sql);
				stmt.setInt(1, setId);
				stmt.setInt(2, conta.getId());
				
				stmt.execute();
				stmt.close();
		}catch(SQLException e){
			System.out.println("Erro ao realocar id "+e);
		}finally {
			this.fecharConexao();
		}
	}
	public void realocarContatos(int idDeleted) { // Método auxiliar para evitar que os campos fiquem sem sequência  
		List<Contato> contatos = this.listarData(); 
		int totalContacts = 0;
		for (int i = 0; i < contatos.size(); i++) {
			totalContacts++;
		}
		int setId = idDeleted;
		int whereDel = setId + 1;
		try{
			this.abrirConexao();
			for(int i=0; i<=totalContacts-idDeleted; i++) {

				String sql = "update contatos set id=? where id=?";
				PreparedStatement stmt = this.conexao.prepareStatement(sql);
				stmt.setInt(1, setId);
				stmt.setInt(2, whereDel);
				
				stmt.execute();
				stmt.close();
				
				setId++;
				whereDel++;
			}
		}
		catch(SQLException e){
			System.out.println("Erro ao realocar id "+e);
		}finally {
			this.fecharConexao();
		}
	}
	public void deletarContato(int ctId) {
		try {
			this.abrirConexao();
			String sqlDel = "delete from contatos where id=?";
			PreparedStatement stmt = this.conexao.prepareStatement(sqlDel);
			stmt.setInt(1, ctId);	
			stmt.execute();
			stmt.close();
			this.realocarContatos(ctId);
			
		}catch(SQLException e){
			System.out.println("Error ao deletar no Banco de dados: "+e);
		}finally {
			this.fecharConexao();
		}
	}*/
}