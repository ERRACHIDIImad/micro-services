package models;

public class Enseignant {
	private int id;
	private String nom;
	private String prénom;
	private String email;
	private String grade;
	private Département Dept;
	public Enseignant(){}
	  public Enseignant(String nom,String prénom,String email,String grade ,Département dept){
	      this.Dept=dept;this.grade=grade;this.email=email;this.nom=nom;this.prénom=prénom;
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
	  
	  public String getemail()
      {return this.email;} 
	  public void setemail(String x)
      {this.email=x;}
	  
	  
	  public String getgrade()
      {return this.grade;} 
	  public void setgrade(String x)
      {this.grade=x;}
	  
	  public Département getDept()
      {return this.Dept;} 
	  public void setDept(Département x)
      {this.Dept=x;}
	  
	  
}
