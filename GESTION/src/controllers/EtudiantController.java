package controllers;

import java.util.Scanner;

import models.Etudiant;
import services.DB;
import services.EtudiantServices;
import services.FilièreServices;

public class EtudiantController {

static Scanner scan =new Scanner(System.in);
	
	public static void showMenu(){
		System.out.println("1- Show Etudiant. \n2- Create Etudiant.\n3- edit Etudiant.\n4- delete Etudiant.");
		int a= scan.nextInt();
		switch (a){
		case 1:showEtudiant();break;
		case 2:createEtudiant();break;
		case 3:editEtudiant();break;
		case 4:destroyEtudiant();break;
		default :break;
		}
	}
	
    public static void showEtudiant(){
    	for (Etudiant d : DB.etudiants){
    		System.out.println("id: "+d.getid()+" | Nom: "+d.getnom()+" | Prénom: "+d.getprénom()+" | email: "+d.getemail()+"| Apogee: "+d.getapogee()+"| Filière: "+d.getFil().getintitulé());
    	    System.out.println("| Notes: "+d.getnotes());
    		}
    }
    
    
    
    public static void destroyEtudiant(){
    	showEtudiant();
    	System.out.println("Selectionner Etudiant par id");int id=scan.nextInt();
       EtudiantServices.delelteEtud(id);
    }
    
    public static void createEtudiant(){
    	System.out.println("Nom: ");String x=scan.nextLine();
    	System.out.println("Prénom: ");String y=scan.nextLine();
    	System.out.println("Email: ");String z=scan.nextLine();
    	System.out.println("apogee: ");int w=scan.nextInt();
    	FilièreController.showFil();
    	System.out.println("Selectionner une filière par id ");int i=scan.nextInt();
    	   EtudiantServices.addEtud(x,y,z,w,FilièreServices.getFilById(i));	
    			
	}
    	
    public static void editEtudiant(){
    	showEtudiant();
    	System.out.println("Selectionnez un Etudiant par son id : ");int x =scan.nextInt();
    	System.out.println("Nom: ");String i =scan.nextLine();
    	System.out.println("Email: ");String b =scan.nextLine();
    	System.out.println("Prénom: ");String intitulé =scan.nextLine();
    	System.out.println("apogee: ");int w=scan.nextInt();
    	FilièreController.showFil();
    	System.out.println("Selectionner filière par id: ");int i1=scan.nextInt();
    	EtudiantServices.updateEtud(x,i,intitulé,b,w,FilièreServices.getFilById(i1));
    	
		
}
}
