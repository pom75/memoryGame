import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;


public abstract class Carte extends JComponent{
	
	private boolean faceC = false; // true = Est Caché / false Est Montrer
	private boolean estT = false; // false = non / true = oui
	protected String id = "ok";

	
	//Constructeur 
	protected Carte(boolean b){
		this.faceC=b;
	}
	//Constructeur par copie
	protected Carte(Carte c){
		this(c.faceC);
	}
	
	public boolean estMontree(){
		return faceC == false;
	}
	
	public boolean estCachee(){
		return faceC == true;
	}	
	
	public void trouv(){
		estT = true;
	}
	
	public void montre(){	
		faceC = false;
	}
	public void cache(){
		faceC = true;
	}
	
	public String getId(){
		return id;
	}
	
	public void retourne(){
		if(this.estMontree()){
			faceC = true;
		}else{
			faceC = false;
		}
	}
	
	public void paintVerso(Graphics2D g){
		
	}
	
	abstract public void paintRecto(Graphics2D g);
	
	public void paintComponent(Graphics2D g){

	}
	
	public boolean estTrouve() {
		return estT;
	}
	abstract public boolean rectoIdentique(Carte c);
	
	public abstract Carte duplique();
	
	public static void melangeCartes(Carte[] cartes){
		Carte c ;
		
		for(int i=0;i<cartes.length;i++){
			int x = (int) (Math.random()*cartes.length);
			c = cartes[x];
			cartes[x]= cartes[i];
			cartes[i]=c;
			
		}
		for(int i=0;i<cartes.length;i++){
			int x = (int) (Math.random()*cartes.length);
			c = cartes[x];
			cartes[x]= cartes[i];
			cartes[i]=c;
			
		}
		
	
	}

}





