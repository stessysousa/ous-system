package br.ufc.web.oussystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue
	private int id;
	@Column(columnDefinition = "text")
	private String nome;
	@Column(columnDefinition = "text")
	private String sobrenome;
	@Column(columnDefinition = "text")
	private String contato;
	@Column(columnDefinition = "text")
	private String email;
	@Column(columnDefinition = "text")
	private String senha;
	@Column(columnDefinition = "text")
	private String cargo;

	public Funcionario() {
		super();
	}

	public Funcionario(int id, String nome, String sobrenome, String contato, String email, String senha,
			String cargo) {
		super();
		this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}

	public Funcionario(String nome, String sobrenome, String contato, String email, String senha, String cargo) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.contato = contato;
		this.email = email;
		this.senha = senha;
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
