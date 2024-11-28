package models;

import java.util.ArrayList;

public class Filière {
	private int id;
	private String intitulé;
	private Enseignant Chef;
	private Département dept;
	ArrayList<Module> modules = new ArrayList<Module>();
	
	  public Filière(String intitulé,Département dept,Enseignant Chef){
	    	this.Chef=Chef;this.dept=dept;this.intitulé=intitulé;
	    }
	  public int getid()
      {return this.id;} 
	  public void setid(int x)
      {this.id=x;}
	  
	  public String getintitulé()
      {return this.intitulé;} 
	  public void setintitulé(String x)
      {this.intitulé=x;}
	  
	  public Département getdept()
      {return this.dept;} 
	  public void setdept(Département x)
      {this.dept=x;}
	  
	  public Enseignant getchef()
      {return this.Chef;} 
	  public void setchef(Enseignant x)
      {this.Chef=x;}
	  
	  
	  public ArrayList<Module> getModules()
      {return this.modules;} 
	  public void setModules(ArrayList<Module> x)
      {this.modules=x;}
}
