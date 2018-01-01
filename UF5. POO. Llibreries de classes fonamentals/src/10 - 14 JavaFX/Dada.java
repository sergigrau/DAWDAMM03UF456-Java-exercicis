package edu.fje.daw2dam2;

import javafx.beans.property.SimpleStringProperty;
/**
 * JavaBean preparat per a treballar amb components tipus taula
 * 
 * @author sergi.grau@fje.edu
 * @version 1.0 22.01.2015
 *
 */
public class Dada {
	private final SimpleStringProperty tipus = new SimpleStringProperty("");
	private final SimpleStringProperty valor = new SimpleStringProperty("");

	public Dada(){
        this("", "");
	}
	
	public Dada(String t, String v) {
		tipus.set(t);
		valor.set(v);
	}

	public String getTipus() {
		return tipus.get();
	}

	public void setTipus(String t) {
		tipus.set(t);
	}

	public String getValor() {
		return valor.get();
	}

	public void setValor(String v) {
		valor.set(v);
	}

}
