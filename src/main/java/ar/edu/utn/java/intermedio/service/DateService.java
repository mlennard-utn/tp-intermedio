package ar.edu.utn.java.intermedio.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.DateResponse;
import ar.edu.utn.java.intermedio.exception.InvalidMonthException;

@Service
public class DateService {
	
	public DateResponse ultimoDiaMesAno(Integer mes, Integer anio) throws InvalidMonthException  {
		
		if(mes > 12 || mes < 1) 
			throw new InvalidMonthException(String.format("Error: el mes ingresado %d no es un valor correcto" , mes));
		
		DateResponse response = new DateResponse();
		LocalDate date = LocalDate.of(anio, mes, 1);
		date = LocalDate.of(anio, mes, date.lengthOfMonth());
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		response.setFecha(date.format(formatter));
			
		return response;
	}
	
}
