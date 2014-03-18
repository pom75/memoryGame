import java.awt.Color;


public class GenerateurDeCartesMotsC extends GenerateurDeCartes{
	private int nbC = 0;
	private Color[] TabColor = {Color.BLUE,Color.cyan,Color.DARK_GRAY,Color.gray,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.pink,Color.RED,Color.YELLOW};
	public Carte[] TabC;
	private String[] TabMot = {"Blue" ,"Cyan","Dark_Gray","Gray","Green","Ligth_Gray","Magenta","Orange","Pink","Red","Yellow"};
	private static int [] c = new int[100];
	private static int i =0 ;
	
	public GenerateurDeCartesMotsC(int i){
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
		
		CarteMotC C = new CarteMotC(TabMot[p],TabColor[(int) (Math.random()*TabColor.length)]);
		return C;
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
