package services;

import java.util.List;

import models.Département;
import models.Enseignant;
import models.Filière;

public class FilièreServices {
	
	public static void addFil(String intitulé,Département dept,Enseignant Chef){
		Filière f = new Filière(intitulé,dept,Chef);
		f.setid(DB.getid_FIL());
		DB.filières.add(f);
	}
	
	public static void updateFil(int id ,String intitulé,Département dept,Enseignant Chef){
		for (Filière f : DB.filières){
			if(f.getid()==id){
				f.setdept(dept);
				 f.setchef(Chef);
				 f.setintitulé(intitulé);
				}
			}
	}
	public static void delelteFil(int id){
				DB.filières.remove(getFilById(id));
			}
	public static List <Filière> getAllFil(){
		return   DB.filières;	
	}
	
	public static Filière getFilById(int id){
		for (Filière f : DB.filières){
			if(f.getid()==id){
				return f;
			}
}
		return null;
}
}


