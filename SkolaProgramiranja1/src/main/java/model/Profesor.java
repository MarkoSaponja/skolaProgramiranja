package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Profesor extends UserDetails {
	private String identificationNo;
	@ManyToMany
	private List<Predmet>predmetiKojePredaje = new ArrayList<>();

	public String getIdentificationNo() {
		return identificationNo;
	}

	public void setIdentificationNo(String identificationNo) {
		this.identificationNo = identificationNo;
	}

	public List<Predmet> getPredmetiKojePredaje() {
		return predmetiKojePredaje;
	}

	public void setPredmetiKojePredaje(List<Predmet> predmetiKojePredaje) {
		this.predmetiKojePredaje = predmetiKojePredaje;
	}
	
	

}
