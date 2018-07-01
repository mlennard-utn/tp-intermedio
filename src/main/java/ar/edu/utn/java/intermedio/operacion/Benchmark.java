package ar.edu.utn.java.intermedio.operacion;

import java.util.List;

public abstract class Benchmark {

	protected abstract void imprimir(List<Integer> items);
	
	protected abstract Double sumar(List<Integer> items);
	
	protected abstract Double maximo(List<Integer> items);
	
	public void imprimirListado(List<Integer> items) {
		imprimir(items);
	}
	
	public Double sumarValores(List<Integer> items) {
		return sumar(items);
	}
	
	public Double maximoValor(List<Integer> items) {
		return maximo(items);
	}
	
}
