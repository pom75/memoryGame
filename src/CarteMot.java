import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CarteMot extends Carte{
	private String nC;
	private static int var = 0;
	private String id ;
	private int SQUARE_LENGTH = 200;
	private Graphics2D g2;

	
	//Constructeur par défaut
	public CarteMot(String s){
		super(false);
		this.nC=s;
		id = var+"mot2";
		var++;
		
	}

	//Constructeur par copie
	public CarteMot(CarteMot C){
		this(C.nC);
		
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
	
	public void trouveI(Graphics2D g){
		g2 = (Graphics2D) g;
		Rectangle square = new Rectangle(0,0,0,0);
		g2.fill(square);
	}
	
	//Paint la couleur de la carte
	public void paintRecto(Graphics2D g) {
		g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Rectangle square = new Rectangle(20,20,SQUARE_LENGTH,SQUARE_LENGTH);
		g2.fill(square);
		g2.setColor(Color.WHITE);
		g2.drawString(nC, 100, 100);

	}
	
	//Cache la carte 
	public void paintVerso(Graphics2D g){
		g2 = (Graphics2D) g;
		g2.setColor(Color.BLACK);
		Rectangle square = new Rectangle(20,20,SQUARE_LENGTH,SQUARE_LENGTH);
		g2.fill(square);
	}
	
	public String getId(){
		return id;
	}
	
	public boolean rectoIdentique(Carte C) {
		return (C.getId() == this.id);

	}

	
	public CarteMot duplique() {
		CarteMot C = new CarteMot(this);
		C.id = this.id;
		return C;
		
	}


}