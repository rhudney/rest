/*
 * @Autor: Rhudney Simões
 * 
 */
package br.com.banksystem.desafio.time;

import javax.xml.bind.annotation.XmlRootElement;

//Classe de definição do JSON de saída
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
