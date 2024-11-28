package models;

public class Module{
	private int id;
	private String intitulé;
    private Filière filière;
    private Enseignant prof;
	
	  public Module(String intitulé,Filière filière,Enseignant prof){
	    	this.prof=prof;this.intitulé=intitulé;this.filière=filière;
	  }
	  public int getid()
      {return this.id;} 
	  public void setid(int x)
      {this.id=x;}
	  
	  public String getintitulé()
      {return this.intitulé;} 
	  public void setintitulé(String x)
      {this.intitulé=x;}
	  
	  public Filière getfilière()
      {return this.filière;} 
	  public void setfilière(Filière x)
      {this.filière=x;}
	  public Enseignant getprof()
      {return this.prof;} 
	  public void setprof(Enseignant x)
      {this.prof=x;}
	  
}

