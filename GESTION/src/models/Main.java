package models;
import java.util.Scanner;

import controllers.DepartementsController;
import controllers.EnseignantController;
import controllers.EtudiantController;
import controllers.FilièreController;
import controllers.ModuleController;
import services.DB;

public class Main {
	
	private static Scanner x =new Scanner(System.in);
	private static void Menuprincipal(){
		
		System.out.println("1- Gestion des departements.");
		System.out.println("2- Gestion des Enseignants.");
		System.out.println("3- Gestion des Etudiants.");
		System.out.println("4- Gestion des Filières.");
		System.out.println("5- Gestion des Modules.");
		int a= x.nextInt();
		switch(a){
		case 1:DepartementsController.showDepartements();break;
		case 2:EnseignantController.showMenu();break;
		case 3:EtudiantController.showMenu();break;
		case 4:FilièreController.showMenu();break;
		case 5:ModuleController.showMenu();break;
		default : break;
		
		}
	}

	public static void main(String[] args) {
		
		Enseignant enseignant = new Enseignant();
        enseignant.setnom("Amine");
        enseignant.setprénom("Ben Charif");
        enseignant.setemail("test@gmail.com");
        enseignant.setgrade("PES");
        enseignant.setid(DB.getid_ENSEGNANT());
        DB.enseignants.add(enseignant);
        Menuprincipal();
	}

}
