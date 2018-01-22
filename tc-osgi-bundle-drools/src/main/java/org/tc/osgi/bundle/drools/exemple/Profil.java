package org.tc.osgi.bundle.drools.exemple;

public class Profil {

	private String nom;
	private Integer age; 

	public Profil() {
	}

	public Profil(String nom) {
		super();
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
