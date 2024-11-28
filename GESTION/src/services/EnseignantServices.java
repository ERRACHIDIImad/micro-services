package services;

import java.util.List;

import models.Département;
import models.Enseignant;

public class EnseignantServices {
	
	public static void addEns(String nom,String prénom,String email,String grade ,Département dept){
		Enseignant m =new Enseignant(nom,prénom,email,grade,dept);
		m.setid(DB.getid_ENSEGNANT());
		DB.enseignants.add(m);
	}
	
	public static void updateEns(int id ,String nom,String prénom,String email,String grade ,Département dept){
		for (Enseignant e : DB.enseignants)
			if(e.getid()==id){
				e.setDept(dept);e.setemail(email);e.setgrade(grade);e.setnom(nom);e.setprénom(prénom);
			}
	}
	public static void delelteEns(int id){
		DB.enseignants.remove(getEnsById(id));
	}
	public static List<Enseignant> getAllEns(){
		return   DB.enseignants	;
	}
	
	public static Enseignant getEnsById(int id){
		for (Enseignant e: DB.enseignants)
			if(e.getid()==id){return e;}
		return null;
}
}

