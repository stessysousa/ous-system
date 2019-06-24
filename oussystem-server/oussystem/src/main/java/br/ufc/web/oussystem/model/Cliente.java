package br.ufc.web.oussystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cliente {

	@Id
	@GeneratedValue
	private int id;
	@Column(columnDefinition = "text")
	private String nome;
	@Column(columnDefinition = "text")
	private String telefone1;
	@Column(columnDefinition = "text")
	private String telefone2;
	@Column(columnDefinition = "text")
	private String estado;
	@Column(columnDefinition = "text")
	private String cidade;
	@Column(columnDefinition = "text")
	private String endereco;
	@Column(columnDefinition = "text")
	private String numero;
	@Column(columnDefinition = "text")
	private String bairro;
	
	
	public Cliente() {
		super();
	}
	public Cliente(String nome, String telefone1, String telefone2, String estado, String cidade, String endereco,
			String numero, String bairro) {
		super();
		this.nome = nome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
	}
	public Cliente(int id, String nome, String telefone1, String telefone2, String estado, String cidade,
			String endereco, String numero, String bairro) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
		this.estado = estado;
		this.cidade = cidade;
		this.endereco = endereco;
		this.numero = numero;
		this.bairro = bairro;
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
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}	
}
