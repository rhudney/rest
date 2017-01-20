/*
 * @Autor: Rhudney Simões
 * 
 */
package br.com.banksystem.desafio.time;

import javax.xml.bind.annotation.XmlRootElement;

//Classe dos atributos dos ponteiros e possível saída de JSON
@XmlRootElement
public class Time {

	private int hour;
	private int min;
	private double angle;
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public double getAngle() {
		return angle;
	}
	public void setAngle(double angle) {
		this.angle = angle;
	}	
}
