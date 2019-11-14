package br.edu.unicid.bean;

public class Professor {
	
	private String pis;
	private String nomeProfessor;
	
	
	public Professor (String pis, String nomeProfessor) {
		
		this.pis = pis;
		this.nomeProfessor = nomeProfessor;
	}
	
	public Professor() {
		
	}


	public String getPis() {
		return pis;
	}


	public void setPis(String pis) {
		this.pis = pis;
	}


	public String getNomeProfessor() {
		return nomeProfessor;
	}


	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	
	
	
	
}
