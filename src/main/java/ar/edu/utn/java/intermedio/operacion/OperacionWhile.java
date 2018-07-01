package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public class OperacionWhile extends Benchmark {

	@Override
	public void imprimir(List<Integer> items) {
		// TODO Implementar las operaciones
		int i=0;
		while(i < items.size()) {
			System.out.println("while: " + items.get(i));
			i++;
		}
	}

	@Override
	public Double sumar(List<Integer> items) {
		// TODO Implementar las operaciones
		double resultado = 0;
		int i = 0;
		
		while(i < items.size()) {
			resultado += items.get(i);
			i++;
		}
		return resultado;
	}

	@Override
	public Double maximo(List<Integer> items) {
		// TODO Implementar las operaciones
		double maximo = 0;
		int i = 0;
		while(i < items.size()) {
			if(maximo < items.get(i)) 
				maximo = items.get(i);
			i++;
		}
		return maximo;
	}

}
