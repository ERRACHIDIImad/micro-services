package models;

public class Département {
	private int id;
	private String intitulé;
    private Enseignant chef;
    
    public Département(Enseignant chef,String intitulé){
    	this.chef=chef;
    	this.intitulé=intitulé;
    }
   
      public int getid()
      {return this.id;} 
    
      public void setid(int x)
      {this.id=x;}
      
      public Enseignant getchef()
      {return this.chef;} 
    
      public void setchef(Enseignant chef)
      {this.chef=chef;}
      
      public String getintitulé()
      {return this.intitulé;} 
    
      public void setintitulé(String intitulé)
      {this.intitulé=intitulé;}
      
      

}
