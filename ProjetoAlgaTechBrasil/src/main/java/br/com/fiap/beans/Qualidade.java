package br.com.fiap.beans;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Qualidade {
	private int idQualidade;
    private int idFazenda;
    private Date data;
    private float ph;
    private float salinidade;
    private float temperatura;
    private float nutrientes;
    
    //getters and setters
	public int getIdQualidade() {
		return idQualidade;
	}
	public void setIdQualidade(int idQualidade) {
		this.idQualidade = idQualidade;
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
	public float getPh() {
		return ph;
	}
	public void setPh(float ph) {
		this.ph = ph;
	}
	public float getSalinidade() {
		return salinidade;
	}
	public void setSalinidade(float salinidade) {
		this.salinidade = salinidade;
	}
	public float getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	public float getNutrientes() {
		return nutrientes;
	}
	public void setNutrientes(float nutrientes) {
		this.nutrientes = nutrientes;
	}
	
	//construtor vazio
	public Qualidade() {
		super();
	}
	
	//construtor cheio
	public Qualidade(int idQualidade, int idFazenda, Date data, float ph, float salinidade, float temperatura, float nutrientes) {
		super();
		this.idQualidade = idQualidade;
		this.idFazenda = idFazenda;
		this.data = data;
		this.ph = ph;
		this.salinidade = salinidade;
		this.temperatura = temperatura;
		this.nutrientes = nutrientes;
	}
	
	//to string
	@Override
	public String toString() {
		return "Qualidade [idQualidade=" + idQualidade + ", idFazenda=" + idFazenda + ", data=" + data + ", ph=" + ph + ", salinidade=" + salinidade
				+ ", temperatura=" + temperatura + ", nutrientes=" + nutrientes + "]";
	}

	

}
