
abstract public class GenerateurDeCartes {
	private String nom=null;//nom du theme
	
	public String getNom(){
		return nom;
	}
	
	abstract public Carte genereUneCarte();
	
	abstract public int nombreDeCartesDifferentes();
	
	abstract Carte[] genereCartes(int n);
	
	abstract public Carte[] generePairesDeCartesMelangees(int n);
	
	
	
	
}
