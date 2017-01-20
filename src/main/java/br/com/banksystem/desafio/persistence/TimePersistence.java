/*
 * @Autor: Rhudney Sim�es
 * 
 */
package br.com.banksystem.desafio.persistence;

import java.util.ArrayList;
import java.util.List;


import br.com.banksystem.desafio.time.Time;


//Classe de persist�ncia
public class TimePersistence {
	
	private static List<Time> timeAngleList = new ArrayList<Time>();

	public List<Time> getTimeAngleList() {
		return timeAngleList;
	}

	public void setTimeAngleList(List<Time> timeAngleList) {
		this.timeAngleList = timeAngleList;
	}
	
}
