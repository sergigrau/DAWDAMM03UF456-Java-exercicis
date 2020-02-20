package edu.fje.daw2dam2;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 * JavaBean preparat per a treballar amb components tipus taula
 * representa una cotització
 * 
 * @author sergi.grau@fje.edu
 * @version 1.0 22.01.2015
 *
 */
public class Stock {
	private final SimpleStringProperty simbol = new SimpleStringProperty("");
	private final SimpleIntegerProperty preu = new SimpleIntegerProperty();
	private final SimpleIntegerProperty quantitat = new SimpleIntegerProperty();

	public Stock(){
        this("", 0,0);
	}
	
	public Stock(String s, int p, int q) {
		simbol.set(s);
		preu.set(p);
		quantitat.set(q);
	}

	public String getSimbol() {
		return simbol.get();
	}

	public void setSimbol(String s) {
		simbol.set(s);
	}

	public int getPreu() {
		return preu.get();
	}

	public void setPreu(int p) {
		preu.set(p);
	}
	public int getQuantitat() {
		return quantitat.get();
	}

	public void setQuantitat(int q) {
		quantitat.set(q);
	}

}
