package models;


public class Note {
	private float note; 
	private Etudiant etudiant;
	private Filière filière;
	
		
	public Note(float note,Etudiant etudiant,Filière filière){
	this.etudiant=etudiant;
	this.filière=filière;
	this.note=note;
	}
	 
}
