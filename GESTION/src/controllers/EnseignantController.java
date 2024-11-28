package controllers;

import java.util.Scanner;

import models.Enseignant;
import services.DB;
import services.DepartementServices;
import services.EnseignantServices;

public class EnseignantController {
	static Scanner scan =new Scanner(System.in);
	
	public static void showMenu(){
		System.out.println("1- Show Enseignant. \n2- Create Enseignant.\n3- edit Enseignant.\n4- delete Enseignant.");
		int a= scan.nextInt();
		switch (a){
		case 1:showEnseignant();break;
		case 2:createEnseignant();break;
		case 3:editEnseignant();break;
		case 4:destroyEnseignant();break;
		default :break;
		}
	}
	
	
	  public static void showEnseignant(){
	    	for (Enseignant d : DB.enseignants){
	    		System.out.print("id: "+d.getid()+" | Nom: "+d.getnom()+" | Prénom: "+d.getprénom()+" | email: "+d.getemail()+"| Grade: "+d.getgrade());
	    	   if (d.getDept()!=null)System.out.println("| Département: "+d.getDept().getintitulé());
	    	   else System.out.println();}
	    }
    
    public static void destroyEnseignant(){
    	showEnseignant();
    	System.out.println("Selectionner enseignant par id");int id=scan.nextInt();
       EnseignantServices.delelteEns(id);
    }
    
    
   
    public static void createEnseignant(){
    	String v=scan.nextLine();
    	System.out.println("Nom: ");String x=scan.nextLine();
    	System.out.println("Prénom: ");String y=scan.nextLine();
    	System.out.println("Email: ");String z=scan.nextLine();
    	System.out.println("grade: ");String w=scan.nextLine();
    	DepartementsController.showDepartements();
    	System.out.println("Selectionner département par id ");int i=scan.nextInt();
    	   EnseignantServices.addEns(x,y,z,w,DepartementServices.getDeptById(i));
    	   showMenu();
	}
    	
    public static void editEnseignant(){
    	showEnseignant();
    	System.out.println("Selectionner enseignant par id");int id=scan.nextInt();
    	System.out.println("Nom: ");String x=scan.nextLine();
    	System.out.println("Prénom: ");String y=scan.nextLine();
    	System.out.println("Email: ");String z=scan.nextLine();
    	System.out.println("grade: ");String w=scan.nextLine();
    	DepartementsController.showDepartements();
    	System.out.println("Selectionner département par id ");int i=scan.nextInt();
    	 EnseignantServices.updateEns(id,x,y,z,w,DepartementServices.getDeptById(i));
		
}

}
