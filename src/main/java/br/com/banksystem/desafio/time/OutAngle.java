/*
 * @Autor: Rhudney Sim�es
 * 
 */
package br.com.banksystem.desafio.time;

import javax.xml.bind.annotation.XmlRootElement;

//Classe de defini��o do JSON de sa�da
@XmlRootElement
public class OutAngle {
	
	private double angle;
	
	public OutAngle(double angle){
		this.angle = angle;
	}

	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}

}
