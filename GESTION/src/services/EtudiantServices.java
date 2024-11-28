package services;

import java.util.List;


import models.Etudiant;
import models.Filière;

public class EtudiantServices {
		
		public static void addEtud (String nom,String prénom,String email,int apogee,Filière filière){
			Etudiant etudiant = new Etudiant(nom,prénom,email,apogee,filière);
			etudiant.setid(DB.getid_ETUD());
			DB.etudiants.add(etudiant);
		}
		
		public static void updateEtud(int id ,String nom,String prénom,String email,int apogee,Filière filière){
			 for (Etudiant x:DB.etudiants){
				 if(x.getid()==id){
					x.setapogee(apogee);x.setemail(email); x.setFil(filière);x.setnom(nom);x.setprénom(prénom); 
				 }	 
			 }
		}
		public static void delelteEtud(int id){
			DB.etudiants.remove(getEtudById(id));
			
		}
		public static List<Etudiant> getAllEtud(){
			return   DB.etudiants;	
		}
		
		public static Etudiant getEtudById(int id){
	          for (Etudiant x : DB.etudiants){
	        if(x.getid()==id) return x;
	        }
			return null;
	        }
	}


