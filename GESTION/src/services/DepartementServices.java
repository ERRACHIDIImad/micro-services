package services;
import models.Département;
import models.Enseignant;

public class DepartementServices {
	
	public static void addDept(Enseignant chef,String intitulé){
		Département departement = new Département(chef,intitulé);
		departement.setid(DB.getid_dept());
		DB.départements.add(departement);
	}
	
	public static void updateDept(int id ,Enseignant chef,String intitulé){
		for (Département d : DB.départements)
		if(d.getid()==id){
			d.setintitulé(intitulé);d.setchef(chef);
		}
		
	}
	public static void delelteDept(int id){
		DB.départements.remove(getDeptById(id));
	}
	public static Département[] getAllDept(){
		return  (Département[]) DB.départements.toArray();	
	}
	
	public static Département getDeptById(int id){
		for (Département d : DB.départements){
			if(d.getid()==id){
				return d;
			}
}
		return null;
	}
}
