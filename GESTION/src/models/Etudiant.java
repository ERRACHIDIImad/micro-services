package models;

import java.util.ArrayList;

import java.util.List;


public class Etudiant {
	   private int id;
       private String nom;
       private String prénom;
       private String email;
       private int apogee;
       private Filière filière;
       private List<Note> notes =new ArrayList<Note>();
       
       public Etudiant(String nom,String prénom,String email,int apogee,Filière filière){
	    	this.email=email;this.nom=nom;this.prénom=prénom;this.apogee=apogee;
	    	this.filière=filière;
	    	
	    }
       public int getid()
       {return this.id;} 
       public void setid(int x)
       {this.id=x;}
       
       public String getnom()
       {return this.nom;} 
       public void setnom(String x)
       {this.nom=x;}
       
       public String getprénom()
       {return this.prénom;} 
       public void setprénom(String x)
       {this.prénom=x;}
       
       public Filière getFil()
       {return this.filière;} 
       public void setFil(Filière x)
       {this.filière=x;}
       
       public String getemail()
       {return this.email;} 
       public void setemail(String x)
       {this.email=x;}
       
       public int getapogee()
       {return this.apogee;} 
       
       public void setapogee(int x)
       {this.apogee=x;}
       
       public List<Note> getnotes()
       {return this.notes;} 
       public void setnotes(List<Note> x)
       {this.notes=x;}
       
}

