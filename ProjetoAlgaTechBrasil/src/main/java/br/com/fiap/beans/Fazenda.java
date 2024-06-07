package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Fazenda {
	private int idFazenda;
    private String nome;
    private String localizacao;
    private String cep;
    private String endereco;
    
    
    //getters and setters
	public int getIdFazenda() {
		return idFazenda;
	}
	public void setIdFazenda(int idFazenda) {
		this.idFazenda = idFazenda;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocalizacao() {
		return localizacao;
	}
	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	
	//construtor vazio
	public Fazenda() {
		super();
	}
	
	//construtor cheio
	public Fazenda(int idFazenda, String nome, String localizacao, String cep, String endereco, String coordenadas) {
		super();
		this.idFazenda = idFazenda;
		this.nome = nome;
		this.localizacao = localizacao;
		this.cep = cep;
		this.endereco = endereco;

	}
	
	//to string
	@Override
	public String toString() {
		return "Fazenda [idFazenda=" + idFazenda+ ",nome=" + nome + ", localizacao=" + localizacao + ", cep=" + cep + ", endereco=" + endereco
				 + "]";
	}
    
	
    
    
}
