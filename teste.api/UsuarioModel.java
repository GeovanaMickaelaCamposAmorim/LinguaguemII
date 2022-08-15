package br.ifba.teste.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "usuario")

public class UsuarioModel {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	
	@Column (name = "id_usuario")
	private long id_usuario;  
	
	@Column (name = "login_usuario", nullable = false, unique = true)
	private  String login_usuario;
	
	@Column (name = "senha_usuario", nullable = false)
	private String senha_usuario;
    
	public UsuarioModel() {
		super();
	}
	

	public UsuarioModel(long id_usuario, String login_usuario, String senha_usuario) {
		this.id_usuario = id_usuario;
		this.login_usuario = login_usuario;
		this.senha_usuario = senha_usuario;
	}


	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getLogin_usuario() {
		return login_usuario;
	}

	public void setLogin_usuario(String login_usuario) {
		this.login_usuario = login_usuario;
	}

	public String getSenha_usuario() {
		return senha_usuario;
	}

	public void setSenha_usuario(String senha_usuario) {
		this.senha_usuario = senha_usuario;
	}
	
	
    
    
    
}
