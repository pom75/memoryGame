import java.awt.Color;


public class GenerateurDeCartesCouleurs extends GenerateurDeCartes{
	private int nbC = 0;
	private Color[] TabColor = {Color.BLUE,Color.cyan,Color.DARK_GRAY,Color.gray,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.pink,Color.pink,Color.RED,Color.YELLOW};
	private Carte[] TabCo;
	private static int [] c = new int[100];
	private static int i =0 ;
	
	public GenerateurDeCartesCouleurs(int i){
		this.nbC=i;
		TabCo = generePairesDeCartesMelangees(i);
		
	}

	
	public Carte genereUneCarte() {
		int p=0;
		int a = 1;
		while(a==1){
			a=0;
			p = (int) (Math.random()*TabColor.length);
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
		
		CarteCouleur C = new CarteCouleur(TabColor[p]);
		return C;
	}

	
	public int nombreDeCartesDifferentes() {
		
		return TabColor.length;
	}
	public Carte[] getT(){
		return TabCo;
	}
	
	public Carte[] genereCartes(int n) {
		Carte[] c = new Carte[n];
		for(int i=0;i<n;i++){
			c[i] = genereUneCarte();
		}
		
		return c;
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
