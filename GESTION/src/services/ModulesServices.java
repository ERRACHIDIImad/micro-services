package services;

import java.util.List;


import models.Enseignant;
import models.Filière;
import models.Module;

public class ModulesServices {
	
	public static void addModule(String intitulé,Filière filière,Enseignant prof){
		Module m =new Module(intitulé,filière,prof);
		m.setid(DB.getid_ETUD());
		DB.modules.add(m);
	}
	
	public static void updateModule(int id, String intitulé,Filière filière,Enseignant prof){
		for (Module d : DB.modules)
			if(d.getid()==id){
				d.setfilière(filière);d.setintitulé(intitulé);d.setprof(prof);
			}
	}
	public static void delelteModule(int id){
		DB.modules.remove(getModuleById(id));
	}
	public static List<Module> getAllModule(){
		return  DB.modules	;
	}
	
	public static Module getModuleById(int id){
		for (Module d : DB.modules)
			if(d.getid()==id){return d;}
		return null;
}
}
