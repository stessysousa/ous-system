package br.ufc.web.oussystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OS {

	@Id
	@GeneratedValue
	private int id;
	@ManyToOne
	private Cliente cliente;
	private String aparelho;
	private String marca;
	private String corAparelho;
	private String modelo;
	private String status;
	private String descricaoDefeito;
	private String itensInclusos;
	private String servico;
	private Double valor;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getAparelho() {
		return aparelho;
	}
	public void setAparelho(String aparelho) {
		this.aparelho = aparelho;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getCorAparelho() {
		return corAparelho;
	}
	public void setCorAparelho(String corAparelho) {
		this.corAparelho = corAparelho;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescricaoDefeito() {
		return descricaoDefeito;
	}
	public void setDescricaoDefeito(String descricaoDefeito) {
		this.descricaoDefeito = descricaoDefeito;
	}
	public String getItensInclusos() {
		return itensInclusos;
	}
	public void setItensInclusos(String itensInclusos) {
		this.itensInclusos = itensInclusos;
	}
	public String getServico() {
		return servico;
	}
	public void setServico(String servico) {
		this.servico = servico;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
	public OS(Cliente cliente, String aparelho, String marca, String corAparelho, String modelo, String status,
			String descricaoDefeito, String itensInclusos, String servico, Double valor) {
		super();
		this.cliente = cliente;
		this.aparelho = aparelho;
		this.marca = marca;
		this.corAparelho = corAparelho;
		this.modelo = modelo;
		this.status = status;
		this.descricaoDefeito = descricaoDefeito;
		this.itensInclusos = itensInclusos;
		this.servico = servico;
		this.valor = valor;
	}
	public OS(int id, Cliente cliente, String aparelho, String marca, String corAparelho, String modelo, String status,
			String descricaoDefeito, String itensInclusos, String servico, Double valor) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.aparelho = aparelho;
		this.marca = marca;
		this.corAparelho = corAparelho;
		this.modelo = modelo;
		this.status = status;
		this.descricaoDefeito = descricaoDefeito;
		this.itensInclusos = itensInclusos;
		this.servico = servico;
		this.valor = valor;
	}
	public OS() {
		super();
	}
	
	

}
