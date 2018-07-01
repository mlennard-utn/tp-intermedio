package ar.edu.utn.java.intermedio.operacion;

import java.util.List;
import java.util.OptionalDouble;


public class OperacionStreams extends Benchmark {

	@Override
	protected void imprimir(List<Integer> items) {
		items.stream().forEach(System.out::println);
	}

	@Override
	protected Double sumar(List<Integer> items) {
		return items.stream().mapToDouble(item -> item.doubleValue()).sum();
	}

	@Override
	protected Double maximo(List<Integer> items) {
		OptionalDouble max = items.stream().mapToDouble(item -> item.doubleValue()).max();
		return max.getAsDouble();
	}


}
