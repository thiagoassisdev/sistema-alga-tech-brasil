package br.com.fiap.beans;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Colheita {
	private int idColheita;
    private int idFazenda;
    private Date data;
    private float quantidade;
    
    //getters and setters
	public int getIdColheita() {
		return idColheita;
	}
	public void setIdColheita(int idColheita) {
		this.idColheita = idColheita;
	}
	public int getIdFazenda() {
		return idFazenda;
	}
	public void setIdFazenda(int idFazenda) {
		this.idFazenda = idFazenda;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public float getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(float quantidade) {
		this.quantidade = quantidade;
	}
	
	//construtor vazio
	public Colheita() {
		super();
	}
	
	//construtor cheio
	public Colheita(int idColheita, int idFazenda, Date data, float quantidade) {
		super();
		this.idColheita = idColheita;
		this.idFazenda = idFazenda;
		this.data = data;
		this.quantidade = quantidade;
	}
	
	//to string
	@Override
	public String toString() {
		return "Colheita [idColheita=" + idColheita + ",idFazenda=" + idFazenda + ", data=" + data + ", quantidade=" + quantidade + "]";
	}
    
    

}
