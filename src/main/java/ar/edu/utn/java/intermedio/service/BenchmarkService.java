package ar.edu.utn.java.intermedio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import ar.edu.utn.java.intermedio.domain.BenchmarkResponse;
import ar.edu.utn.java.intermedio.exception.CantidadItemsException;
import ar.edu.utn.java.intermedio.operacion.Benchmark;
import ar.edu.utn.java.intermedio.operacion.OperacionFor;
import ar.edu.utn.java.intermedio.operacion.OperacionStreams;
import ar.edu.utn.java.intermedio.operacion.OperacionWhile;

@Service
public class BenchmarkService {
	
	private static final Integer CANTIDAD_MAXIMA_ITEMS = 50000000;
	
	public BenchmarkResponse imprimir(Integer cantidadItems) throws CantidadItemsException {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new CantidadItemsException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		double tiempo = System.currentTimeMillis();
		
		Benchmark operacionStreams = new OperacionStreams();
		operacionStreams.imprimirListado(response.getItems());
		
		response.setTiempoStreams((System.currentTimeMillis() - tiempo)/1000 );
		
		tiempo= System.currentTimeMillis();
		
		Benchmark operacionFor = new OperacionFor();
		operacionFor.imprimirListado(response.getItems());
		
		response.setTiempoFor((System.currentTimeMillis() - tiempo)/1000);
		
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.imprimirListado(response.getItems());
		
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)/1000);
		
		if(response.getItems().size() > 100) {
			response.setItems(reduceTo100(response.getItems()));
		}
		
		return response;
	}


	
	public BenchmarkResponse sumar(Integer cantidadItems) throws CantidadItemsException {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new CantidadItemsException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		double tiempo = System.currentTimeMillis();
		
		Benchmark operacionStreams = new OperacionStreams();
		response.setResultado(operacionStreams.sumarValores(response.getItems()));
		response.setTiempoStreams((System.currentTimeMillis() - tiempo)/1000 );
		
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionFor = new OperacionFor();
		System.out.println("ResultadoFor: " + operacionFor.sumarValores(response.getItems()));
		response.setTiempoFor((System.currentTimeMillis() - tiempo)/1000);

		tiempo = System.currentTimeMillis();
		
		Benchmark operacionWhile = new OperacionWhile();
		operacionWhile.sumarValores(response.getItems());
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)/1000);
		
		if(response.getItems().size() > 100) {
			response.setItems(reduceTo100(response.getItems()));
		}
		
		return response;
		
	}
	
	public BenchmarkResponse maximo(Integer cantidadItems) throws CantidadItemsException {
		
		if(cantidadItems > CANTIDAD_MAXIMA_ITEMS) {
			throw new CantidadItemsException(String.format("Error: la cantidad maximo de items %d no debe superar el valor %d", 
					cantidadItems, CANTIDAD_MAXIMA_ITEMS));
		}
		
		BenchmarkResponse response = inicializarResponse(cantidadItems);
		double tiempo = System.currentTimeMillis();
		
		Benchmark operacionStreams = new OperacionStreams();
		
		response.setResultado(operacionStreams.maximoValor(response.getItems()));
		response.setTiempoStreams((System.currentTimeMillis() - tiempo) /1000);
		
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionFor = new OperacionFor();
		
		System.out.println(operacionFor.maximoValor(response.getItems()));
		response.setTiempoFor((System.currentTimeMillis() - tiempo)/1000 );
		
		
		tiempo = System.currentTimeMillis();
		
		Benchmark operacionWhile = new OperacionWhile();
		
		System.out.println(operacionWhile.maximoValor(response.getItems()));
		response.setTiempoWhile((System.currentTimeMillis() - tiempo)/1000 );
		
		if(response.getItems().size() > 100) {
			response.setItems(reduceTo100(response.getItems()));
		}
		
		return response;
	}
	
	private List<Integer> generarItems(Integer cantidadItems){
		List<Integer> items = new ArrayList<>();
		Random numeros = new Random();
		for(int i = 0; i < cantidadItems; i++) {
			items.add(numeros.nextInt(cantidadItems));
		}
		return items;
	}

	private BenchmarkResponse inicializarResponse(Integer cantidadItems) {
		BenchmarkResponse response = new BenchmarkResponse();
		List<Integer> items = generarItems(cantidadItems);
		response.setItems(items);
		return response;
	}
	
	public List<Integer> reduceTo100 (List<Integer> lista) {
		List<Integer> reducida = new ArrayList<Integer>();
		for(int i=0; i<50; i++) {
			reducida.add(i, lista.get(i));
		}
		for(int i= 0; i < 50; i++ ) {
			reducida.add(i + 50, lista.get(lista.size() - 50 + i));
		}
		return reducida;
 	}
	
}
