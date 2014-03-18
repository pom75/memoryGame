import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class CarteCouleur extends Carte{
	
	private Color nomC =null; //RED,GREEN,BLUE,CYAN, MAGENTA,YELLOW,PINK,ORANGE
	private String id;
	private static int var = 0;
	private int SQUARE_LENGTH = 200;
	private Graphics2D g2;

	
	//Constructeur par défaut
	public CarteCouleur(Color i){
		super(false);
		this.nomC=i;
		id = var+"imgC1";
		var++;
	}

	//Constructeur par copie
	public CarteCouleur(CarteCouleur C){
		this(C.nomC);
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
	
	
	public String getId(){
		return id;
	}
	
	//Paint la couleur de la carte
	public void paintRecto(Graphics2D g) {
		g2 = (Graphics2D) g;
		g2.setColor(nomC);
		Rectangle square = new Rectangle(20,20,SQUARE_LENGTH,SQUARE_LENGTH);
		g2.fill(square);
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

	
	public CarteCouleur duplique() {
		CarteCouleur C = new CarteCouleur(this);
		C.id = this.id;
		return C;
	}


}
