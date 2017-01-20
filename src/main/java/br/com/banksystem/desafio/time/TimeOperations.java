/*
 * @Autor: Rhudney Sim�es
 * 
 */
package br.com.banksystem.desafio.time;

import br.com.banksystem.desafio.persistence.TimePersistence;

//Classe de opera��es do tempo
public class TimeOperations {
	
	private Time time;
	private TimePersistence tp;
	
	public TimeOperations(){
		tp = new TimePersistence();
		time = new Time();
	}
	
	//Persistir as posi��es dos ponteiros e o �ngulo
	public void setTimeAngle(Time time){
		tp.getTimeAngleList().add(time);
	}
	
	//Procurar na lista se a consulta da posi��o dos ponteiros j� foi feita, caso n�o faz o c�lculo
	public double findTime(int hour, int min){
		double angle = -1;
		
		for(Time t:tp.getTimeAngleList()){
			if(t.getHour() == hour && t.getMin() == min){
				angle = t.getAngle();
			}
		}
		
		//Se o calculo nunca foi feito, ent�o calcula o �ngulo
		if(angle < 0){
			angle = calculateAngle(hour, min);
		}
		return angle;
	}
	
	//Calcular �ngulo a partir das posi��es dos ponteiros
	public double calculateAngle(int hour, int min){
		
		double angle;
		double result = 0;
		
		//Verifica se as informa��es de entrada s�o v�lidas, caso contr�rio retorna -1
		if (hour < 0 || min < 0 || hour > 24 || min > 60) {
			result = -1;
		}
		else{
			//Salvar a hora e o minuto
			time.setHour(hour);
			time.setMin(min);			

			//Se minutos � igual a 60, ent�o aumenta uma hora
			if (min == 60) {
				min = 0;
				hour += 1;
				if(hour > 24){
					hour = 1;
				}
			}
			
			//Se o ponteiro das horas � igual a 12 ou 24, ent�o retorno a posi��o inicial
			if (hour == 12 || hour == 24) {
				hour = 0;
			}
			
			//Converto a nota��o 0h a 24h para 0h a 12 (pm/am) para simplificar
			if(hour > 12){
				hour -= 12;
			}
			
			//Calcular o �ngulo
			double hourAngle = (hour * 60 + min) * 0.5;
			double minAngle = min * 6;
			double bwAngle = Math.abs(hourAngle - minAngle);
			angle = Math.min(360 - bwAngle, bwAngle);
			
			//Salvar o �ngulo e persistir os dados
			time.setAngle(angle);
			setTimeAngle(time);	
			
			result = angle;
		}
				
		return result;
	}
}
