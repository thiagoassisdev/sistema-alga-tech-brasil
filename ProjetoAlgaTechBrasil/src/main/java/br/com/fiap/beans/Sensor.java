package br.com.fiap.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sensor {
	private int idSensor;
    private String tipo;
    private String unidade;
    
    //getters and setters
	public int getIdSensor() {
		return idSensor;
	}
	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getUnidade() {
		return unidade;
	}
	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	
	//construtor vazio
	public Sensor() {
		super();
	}
	
	//construtor cheio
	public Sensor(int idSensor, String tipo, String unidade) {
		super();
		this.idSensor = idSensor;
		this.tipo = tipo;
		this.unidade = unidade;
	}
	
	//to string
	@Override
	public String toString() {
		return "Sensor [idSensor=" + idSensor + ", tipo=" + tipo + ", unidade=" + unidade + "]";
	}




}
