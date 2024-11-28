package services;
import java.util.ArrayList;
import java.util.List;
import models.*;


public class DB {
	private static int dept_id=0;
	private static int FIL_id=0;
	private static int Etud_id=0;
	private static int Module_id=0;
	private static int ENSENGNANT_id=0;
	public static List <Département> départements =new ArrayList<Département>() ;
	public static List <Filière> filières= new ArrayList<Filière>();
	public static List <Module> modules=new ArrayList<Module>();
	public static List <Enseignant> enseignants=new ArrayList<Enseignant>();
	public static List <Note> notes=new ArrayList<Note>();
	public static List <Etudiant> etudiants=new ArrayList<Etudiant>();
	
	public static int getid_dept(){dept_id++;return dept_id;}
	public static int getid_FIL(){FIL_id++;return FIL_id;}
	public static int getid_ETUD(){Etud_id++;return Etud_id;}
	public static int getid_MODULE(){Module_id++;return Module_id;}
	public static int getid_ENSEGNANT(){ENSENGNANT_id++;return ENSENGNANT_id;}

}
