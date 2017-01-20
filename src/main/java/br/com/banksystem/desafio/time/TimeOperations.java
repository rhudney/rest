/*
 * @Autor: Rhudney Simões
 * 
 */
package br.com.banksystem.desafio.time;

import br.com.banksystem.desafio.persistence.TimePersistence;

//Classe de operações do tempo
public class TimeOperations {
	
	private Time time;
	private TimePersistence tp;
	
	public TimeOperations(){
		tp = new TimePersistence();
		time = new Time();
	}
	
	//Persistir as posições dos ponteiros e o ângulo
	public void setTimeAngle(Time time){
		tp.getTimeAngleList().add(time);
	}
	
	//Procurar na lista se a consulta da posição dos ponteiros já foi feita, caso não faz o cálculo
	public double findTime(int hour, int min){
		double angle = -1;
		
		for(Time t:tp.getTimeAngleList()){
			if(t.getHour() == hour && t.getMin() == min){
				angle = t.getAngle();
			}
		}
		
		//Se o calculo nunca foi feito, então calcula o ângulo
		if(angle < 0){
			angle = calculateAngle(hour, min);
		}
		return angle;
	}
	
	//Calcular ângulo a partir das posições dos ponteiros
	public double calculateAngle(int hour, int min){
		
		double angle;
		double result = 0;
		
		//Verifica se as informações de entrada são válidas, caso contrário retorna -1
		if (hour < 0 || min < 0 || hour > 24 || min > 60) {
			result = -1;
		}
		else{
			//Salvar a hora e o minuto
			time.setHour(hour);
			time.setMin(min);			

			//Se minutos é igual a 60, então aumenta uma hora
			if (min == 60) {
				min = 0;
				hour += 1;
				if(hour > 24){
					hour = 1;
				}
			}
			
			//Se o ponteiro das horas é igual a 12 ou 24, então retorno a posição inicial
			if (hour == 12 || hour == 24) {
				hour = 0;
			}
			
			//Converto a notação 0h a 24h para 0h a 12 (pm/am) para simplificar
			if(hour > 12){
				hour -= 12;
			}
			
			//Calcular o ângulo
			double hourAngle = (hour * 60 + min) * 0.5;
			double minAngle = min * 6;
			double bwAngle = Math.abs(hourAngle - minAngle);
			angle = Math.min(360 - bwAngle, bwAngle);
			
			//Salvar o ângulo e persistir os dados
			time.setAngle(angle);
			setTimeAngle(time);	
			
			result = angle;
		}
				
		return result;
	}
}
