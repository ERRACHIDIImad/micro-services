package controllers;

import java.util.Scanner;

import models.Filière;
import services.DB;
import services.DepartementServices;
import services.EnseignantServices;
import services.FilièreServices;

public class FilièreController {
	static Scanner scan =new Scanner(System.in);
	public static void showMenu(){
		System.out.println("1- Show Filière. \n2- Create Filière.\n3- edit Filière.\n4- delete Filière.");
		int a= scan.nextInt();
		switch (a){
		case 1:showFil();break;
		case 2:createFil();break;
		case 3:editFil();break;
		case 4:destroyFil();break;
		default :break;
		}
	}
	
    public static void showFil(){
    	for (Filière d : DB.filières){
    		System.out.println("id: "+d.getid()+" | Intitulé: "+d.getintitulé()+" | Chef: "+d.getchef().getnom()+" "+d.getchef().getprénom()+"| Apogee: "+d.getdept().getintitulé());
    	    System.out.println("| Modules: "+d.getModules());
    		}
    }
    
    public static void destroyFil(){
    	
    	showFil();
    	System.out.println("Selectionner Filière par id");int id=scan.nextInt();
       FilièreServices.delelteFil(id);
    }
      
    public static void createFil(){
    	System.out.println("intitulé: ");String intitulé=scan.nextLine();
    	EnseignantController.showEnseignant();
 		System.out.println("Selectionner le Chef par id: ");int y=scan.nextInt();
 		DepartementsController.showDepartements();
 		System.out.println("Selectionner Le département par id: ");int b=scan.nextInt();
 		FilièreServices.addFil(intitulé,DepartementServices.getDeptById(b),EnseignantServices.getEnsById(y));	
 		  }
    	
    public static void editFil(){
    	showFil();
    	System.out.println("Selectionner Filière par id");int id=scan.nextInt();
    	System.out.println("intitulé: ");String x=scan.nextLine();
    	EnseignantController.showEnseignant();
 		System.out.println("Selectionner le Chef par id: ");int y=scan.nextInt();
 		DepartementsController.showDepartements();
 		System.out.println("Selectionner Le département par id: ");int b=scan.nextInt();
 		FilièreServices.updateFil(id,x,DepartementServices.getDeptById(b),EnseignantServices.getEnsById(y));
	   
}
}
