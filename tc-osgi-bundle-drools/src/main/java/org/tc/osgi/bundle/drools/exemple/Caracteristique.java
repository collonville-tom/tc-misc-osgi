package org.tc.osgi.bundle.drools.exemple;

public class Caracteristique {
	private int numDossier;


	private String nom;
	private int valeur;

	public Caracteristique() {
	}

	public Caracteristique(int numDossier, String nom, int valeur) {
		super();
		this.numDossier = numDossier;
		this.nom = nom;
		this.valeur = valeur;

	}
	
	
	public int getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(int numDossier) {
		this.numDossier = numDossier;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}
}
