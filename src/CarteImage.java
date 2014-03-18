import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CarteImage extends Carte{
	private static int var = 0;
	private String id ;
	private int SQUARE_LENGTH = 200;
	private Graphics2D g2;
	private Image img ; 
	private ImageIcon imgg;
	public int test = 3;
	
	
	
	//Constructeur par défaut
	public CarteImage(ImageIcon i){
		super(false);
		img = i.getImage();
		imgg =i;
		id = var+"imgC";
		var++;
	}

	//Constructeur par copie
	public CarteImage(CarteImage C){
		this(C.imgg);
		
	}
	

	//Affichage des Cartes
	public void paintComponent(Graphics g){
		if(this.estCachee()){
			paintVerso((Graphics2D) g);
		}
		else{
			if(this.estTrouve()){
				trouveI((Graphics2D) g);
			}else{
				paintRecto((Graphics2D) g);
			}
		}
    }
	

	//Paint la couleur de la carte
	public void paintRecto(Graphics2D g) {
		g2 = (Graphics2D) g;
		g2.drawImage(img,20,20,200,200, this);
	}
		
	
	public void trouveI(Graphics2D g){
		g2 = (Graphics2D) g;
		Rectangle square = new Rectangle(0,0,0,0);
		g2.fill(square);
	}
	
	public String getId(){
		return id;
	}
	
	//Cache la carte 
	public void paintVerso(Graphics2D g){
		g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Rectangle square = new Rectangle(20,20,SQUARE_LENGTH,SQUARE_LENGTH);
		g2.fill(square);
	}
	
	
	public boolean rectoIdentique(Carte C) {
		return (C.getId() == this.id);

	}

	
	public CarteImage duplique() {
		CarteImage C = new CarteImage(this);
		C.id = this.id;
		return C;
	}
	
	public String toString(){
		return " "+id;
	}


}
