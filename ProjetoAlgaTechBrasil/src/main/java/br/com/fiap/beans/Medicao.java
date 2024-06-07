package br.com.fiap.beans;

import java.sql.Timestamp;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Medicao {
	private int idMedicao;
    private int idSensor;
    private int idFazenda;
    private float valor;
    private Timestamp dataHora;
    private String clima;
    
    //Getters and setters
	public int getIdMedicao() {
		return idMedicao;
	}
	public void setIdMedicao(int idMedicao) {
		this.idMedicao = idMedicao;
	}
	public int getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}
	public int getIdFazenda() {
		return idFazenda;
	}
	public void setIdFazenda(int idFazenda) {
		this.idFazenda = idFazenda;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public Timestamp getDataHora() {
		return dataHora;
	}
	public void setDataHora(Timestamp dataHora) {
		this.dataHora = dataHora;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	
	//Construtor vazio
	public Medicao() {
		super();
	}
	
	//Construtor cheio
	public Medicao(int idMedicao, int idSensor, int idFazenda, float valor, Timestamp dataHora, String clima) {
		super();
		this.idMedicao = idMedicao;
		this.idSensor = idSensor;
		this.idFazenda = idFazenda;
		this.valor = valor;
		this.dataHora = dataHora;
		this.clima = clima;
	}
	
	//to string
	@Override
	public String toString() {
		return "Medicao [idMedicao=" + idMedicao + ", idSensor=" + idSensor + ", idFazenda=" + idFazenda + ", valor=" + valor + ", dataHora="
				+ dataHora + ", clima=" + clima + "]";
	}

		    

}
