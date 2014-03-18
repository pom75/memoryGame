import java.awt.Color;

import javax.swing.ImageIcon;


public class GenerateurDeCartesImages2 extends GenerateurDeCartes{
	private int nbC = 0;
	private Carte[] TabC;
	private ImageIcon[] TabImg = {new ImageIcon("12.png") ,new ImageIcon("13.png") ,new ImageIcon("14.png") ,new ImageIcon("15.png") ,new ImageIcon("16.png") ,new ImageIcon("17.png") ,new ImageIcon("18.png") ,new ImageIcon("19.png") ,new ImageIcon("20.png") ,new ImageIcon("21.png") ,new ImageIcon("22.png") };
	private static int [] c = new int[100];
	private static int i =0 ;
	
	public GenerateurDeCartesImages2(int i){
		this.nbC=i;
		for(int ii=0;ii<100;ii++){
			c[ii]=-1;
		}
		TabC = generePairesDeCartesMelangees(i);
		
	}

	
	public Carte genereUneCarte() {
		//algo 2 carte diffŽrente
		int p=0;
		int a = 1;
		while(a==1){
			a=0;
			p = (int) (Math.random()*TabImg.length);
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
		
		CarteImage C = new CarteImage(TabImg[p]);
		return C;
	}

	
	public int nombreDeCartesDifferentes() {
		
		return TabImg.length;
	}

	public Carte[] getT(){
		return TabC;
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
		CarteImage C = new CarteImage(TabImg[1]);
		C.melangeCartes(c2);	
		return c2;
	}
	


	public int getNbC(){
		return nbC;
	}

}