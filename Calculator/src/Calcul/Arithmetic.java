package Calcul;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Arithmetic extends JFrame implements ActionListener{
	JButton x;JButton y;JTextField a;JTextField b;JTextField c ;JRadioButton r1;JRadioButton r2;JRadioButton r3;
	JRadioButton r4;
	
	public Arithmetic(){
		
		setLayout(null);
		 
		 JLabel  label1=new JLabel("Nombre1"); label1.setBounds(80,5,150,100);label1.setFont(new Font("SERIF",Font.PLAIN, 30));
		 JLabel  label2=new JLabel("Nombre2"); label2.setBounds(310,5,150,100);label2.setFont(new Font("SERIF",Font.PLAIN, 30));
		 JLabel  label3=new JLabel("Resultat");label3.setBounds(560,5,150,100);label3.setFont(new Font("SERIF",Font.PLAIN, 30));
		 
		
	
		 a =new JTextField();a.setBounds(70,100,150,35);
		 b =new JTextField();b.setBounds(300,100,150,35);
		 c =new JTextField();c.setBounds(540,100,150,35);c.setEditable(false);
		 
		ButtonGroup  group =new ButtonGroup();
		
		r1 = new JRadioButton("+"); group.add(r1);r1.setBounds(240,80,50,20);
		r2= new JRadioButton("-"); group.add(r2);r2.setBounds(240,100,50,20);
	    r3= new JRadioButton("*"); group.add(r3);r3.setBounds(240,120,50,20);
		r4= new JRadioButton("/"); group.add(r4);r4.setBounds(240,140,50,20);
		
		r1.setFont(new Font(null,Font.PLAIN, 25));
		r2.setFont(new Font(null,Font.PLAIN, 25));
		r3.setFont(new Font(null,Font.PLAIN, 25));
		r4.setFont(new Font(null,Font.PLAIN, 25));
		
	    x =new JButton("=");x.setSize(50,35);x.setLocation(470,100);x.setFont(new Font("SERIF",Font.PLAIN, 25));
	    x.addActionListener(this);
	    y =new JButton("Effacer");y.setSize(150,35);y.setLocation(300,180);y.setFont(new Font("SERIF",Font.PLAIN, 25));
		y.addActionListener(this);
		

		add(label1);add(r1);add(r2);add(r3);add(r4);
		add(label2);add(label3);add(a);add(b);add(x);add(c);add(y);
		
	
		setTitle("Arithmetics");
		setSize(800,300);setLocation(500,300);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
			
 }
	
	public void actionPerformed(ActionEvent e){
	

		
	if (e.getSource()== x){
		double n=0;
		double field_one= Double.parseDouble(a.getText());
		double feild_tow= Double.parseDouble(b.getText());
		
		
		if(r1.isSelected()){n=field_one+feild_tow;}
		if(r2.isSelected()){n=field_one-feild_tow;}
		if(r3.isSelected()){n=field_one*feild_tow;}
		if(r4.isSelected()){n=field_one/feild_tow;}
		
		c.setText(String.valueOf(n));
	}
	
	else  {a.setText("");b.setText("");c.setText("");}	
	
	}

	public static void main(String args []){
	new Arithmetic();	
	}
	
	
	}

	

