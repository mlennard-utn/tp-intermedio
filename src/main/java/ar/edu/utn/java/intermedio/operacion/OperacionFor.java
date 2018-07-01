package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionFor extends Benchmark{

	@Override
	public void imprimir(List<Integer> items) {
		// TODO Implementar las operaciones
		for (Integer item : items) {
			System.out.println("for: "+ item);
		}
	}

	@Override
	public Double sumar(List<Integer> items) {
		// TODO Implementar las operaciones
		double resultado = 0;
		for (Integer item : items) {
			resultado += item;
		}
		return resultado;
	}

	@Override
	public Double maximo(List<Integer> items) {
		// TODO Implementar las operaciones
		double maximo = 0;
		for (Integer item : items) {
			if(item > maximo)
				maximo = item;
		}
		return maximo;
	}

}
