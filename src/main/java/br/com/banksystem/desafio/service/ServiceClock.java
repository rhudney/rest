/*
 * @Autor: Rhudney Simões
 * 
 */
package br.com.banksystem.desafio.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.banksystem.desafio.time.OutAngle;
import br.com.banksystem.desafio.time.TimeOperations;

@Path("/clock")
public class ServiceClock {
	
	TimeOperations timeOperations = new TimeOperations();
	
	
	//Formato de entrada com os minutos separados por ":"
	@GET
	@Path("/{hour}:{min}")
	@Produces({MediaType.APPLICATION_JSON})
	public OutAngle getTime(@PathParam("hour") int hour, @PathParam("min") int min) throws Exception{
		
		//Verifico se o ângulo já foi calculado,
		//retorna o ângulo ou
		//retorna -1 se a entrada não for permitida
		double angle = timeOperations.findTime(hour, min);
		
		if(angle == -1){
			Throwable t = new IllegalArgumentException("Wrong input");
			throw new Exception("There is one error", t);
		}	
		
		OutAngle out = new OutAngle(angle);
		
		return out;
	}
	
	
	//Formato de entrada do exemplo do desafio
	@GET
	@Path("/{hour}")
	@Produces({MediaType.APPLICATION_JSON})
	public OutAngle getTime(@PathParam("hour") int hour) throws Exception {
		
		//Dependendo do formato de entrada, defino minutos como 0
		int min = 0;
		
		//Verifico se o ângulo já foi calculado,
		//retorna o ângulo ou
		//retorna -1 se a entrada não for permitida
		double angle = timeOperations.findTime(hour, min);
		
		if(angle == -1){
			Throwable t = new IllegalArgumentException("Wrong input");
			throw new Exception("There is one error", t);
		}	
		
		OutAngle out = new OutAngle(angle);
		
		return out;
	}

}
