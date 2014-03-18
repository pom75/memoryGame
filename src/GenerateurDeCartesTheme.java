import java.awt.Color;

import javax.swing.ImageIcon;



public class GenerateurDeCartesTheme extends GenerateurDeCartes{
	private int nbC = 0;
	public Carte[] TabC;
	private String[] TabMot = {"Blue" ,"Cyan","Dark_Gray","Gray","Green","Ligth_Gray","Magenta","Orange","Pink","Red","Yellow"};
	private Color[] TabColor = {Color.BLUE,Color.cyan,Color.DARK_GRAY,Color.gray,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.pink,Color.pink,Color.RED,Color.YELLOW};
	private ImageIcon[] TabImg = {new ImageIcon("1.png") ,new ImageIcon("10.png") ,new ImageIcon("2.png") ,new ImageIcon("11.png") ,new ImageIcon("3.png") ,new ImageIcon("4.png") ,new ImageIcon("5.png") ,new ImageIcon("6.png") ,new ImageIcon("7.png") ,new ImageIcon("8.png") ,new ImageIcon("9.png") };
	private ImageIcon[] TabImg2 = {new ImageIcon("12.png") ,new ImageIcon("13.png") ,new ImageIcon("14.png") ,new ImageIcon("15.png") ,new ImageIcon("16.png") ,new ImageIcon("17.png") ,new ImageIcon("18.png") ,new ImageIcon("19.png") ,new ImageIcon("20.png") ,new ImageIcon("21.png") ,new ImageIcon("22.png") };
	private static int [] c = new int[100];
	private static int i =0 ;
	
	public GenerateurDeCartesTheme(int i){
		this.nbC=i;
		for(int ii=0;ii<100;ii++){
			c[ii]=-1;
		}
		TabC = generePairesDeCartesMelangees(i);
		
	}
	public Carte[] getT(){
		return TabC;
	}
	
	public Carte genereUneCarte() {
		//algo 2 carte diffŽrente
		int p=0;
		int a = 1;
		while(a==1){
			a=0;
			p = (int) (Math.random()*TabMot.length);
			for(int jj=0;jj<c.length;jj++){
				if(i == 0){
					c[0] = p;
					a=0;
					i++;
					break;
				}else{
					if(c[jj]==p){
					 a =1;
					}
				}	
			}
			if(a==0){
				c[i]=p;
				i++;
			}
			
		}
		
		int alea = (int) (Math.random()*5+1);
		switch (alea) {
        	case 1:   
        		CarteMot C = new CarteMot(TabMot[p]);
        		return C;
        	case 2:
        		CarteCouleur C1 = new CarteCouleur(TabColor[p]);
        		return C1;
        	case 3:
        		CarteMotC C2 = new CarteMotC(TabMot[p],TabColor[(int) (Math.random()*TabColor.length)]);
        		return C2;
        	case 4:
        		CarteImage C3 = new CarteImage(TabImg[p]);
        		return C3;
        	case 5:
        		CarteImage C4 = new CarteImage(TabImg2[p]);
        		return C4;
        	default:
        		return null;
		}
	}

	
	public int nombreDeCartesDifferentes() {
		
		return TabMot.length;
	}

	
	public Carte[] genereCartes(int n) {			
		Carte[] cc = new Carte[n];
		for(int j=0;j<n;j++){
			cc[j]=genereUneCarte();
		}
			
	
		return cc;
	}


	public Carte[] generePairesDeCartesMelangees(int n) {
		Carte[] c= genereCartes(n);
		Carte[] c2 = new Carte[2*n];
		for(int i=0;i<n;i++){
			c2[i] = c[i];
			c2[i+n]= (Carte) c[i].duplique();
		}
			
		return c2;
	}
	
	public int getNbC(){
		return nbC;
	}

}