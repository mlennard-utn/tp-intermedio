package ar.edu.utn.java.intermedio.domain;

import java.util.List;


public class BenchmarkResponse extends Response {

	private List<Integer> items;
	private Double resultado;
	private double tiempoFor;
	private double tiempoWhile;
	private double tiempoStreams;
	
	public List<Integer> getItems() {
		return items;
	}
	public void setItems(List<Integer> items) {
		this.items = items;
	}	
	public Double getResultado() {
		return resultado;
	}
	public void setResultado(Double resultado) {
		this.resultado = resultado;
	}
	public double getTiempoFor() {
		return tiempoFor;
	}
	public void setTiempoFor(double tiempoFor) {
		this.tiempoFor = tiempoFor;
	}
	public double getTiempoWhile() {
		return tiempoWhile;
	}
	public void setTiempoWhile(double tiempoWhile) {
		this.tiempoWhile = tiempoWhile;
	}
	public double getTiempoStreams() {
		return tiempoStreams;
	}
	public void setTiempoStreams(double tiempoStreams) {
		this.tiempoStreams = tiempoStreams;
	}
}
