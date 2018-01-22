package org.tc.osgi.bundle.drools.exemple;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Context {
	
	private String message;
	private String reponse;
	private Profil profilCourant;
	 
	public Context() {
	}

	public Context(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Profil getProfilCourant() {
		return profilCourant;
	}

	public void setProfilCourant(Profil profilCourant) {
		this.profilCourant = profilCourant;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}
	
	public void readMessage()
	{
		 BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		 try {
			this.setMessage(in.readLine());
//			System.out.println(this.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void pushReponse(String question)
	{
		this.setReponse(question);
		System.out.println(this.getReponse());
	}
	
	public String match(String spattern)
	{
		Pattern pattern = Pattern.compile(spattern) ;      
		Matcher matcher = pattern.matcher(this.getMessage()) ;
		matcher.matches();
		return matcher.group(1);
	}

	
}
			