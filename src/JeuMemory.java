// Stéphnae Ferreira

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class JeuMemory extends JPanel {
	private static Carte[] TabC = new Carte[10];
	private static int nivo = 0;
	private static int dai = 0;
	private static int dap = 0;
	private static int them = 0;
	
	public static void main(String[] args) {
		int lign;
		int col;
		String buff;
		String err = "Enter le niveau de difficulté que vous voulez";
		int sec = 1;
		
		//GenerateurDeCartesMots c = new GenerateurDeCartesMots(3);
	    //Carte [] tab = c.TabC;
		
			//niveau de dificulté
			while(nivo !=1 && nivo != 2 && nivo != 3){
			buff = JOptionPane.showInputDialog(err+" : \n 1 : 2 Cartes différentes (Facile) \n 2 : 7 Cartes différentes (Intermédiaire) \n 3 : 11 Cartes différentes (Dificile)");
			try{
			nivo = Integer.parseInt(buff); 
			}catch(NumberFormatException e){
				err = "Erreur, veuillez recommencer";
			}
		    }
		    
			while(sec==1){
				buff = JOptionPane.showInputDialog("Enter le delais d'affichage initial des cartes (ms)");
				try{
					dai  = Integer.parseInt(buff); 
					sec=0;
					}catch(NumberFormatException e){
						sec = 1;
					}
			}
			sec=1;
			while(sec==1){
				buff = JOptionPane.showInputDialog("Enter le delais d'affichage de mauvaise paires (ms)");
				try{
					dap  = Integer.parseInt(buff); 
					sec=0;
					}catch(NumberFormatException e){
						sec = 1;
					}
			}
			
			
			while(them !=1 && them != 2 && them != 3 && them != 4 && them != 5 && them != 6){
				buff = JOptionPane.showInputDialog("Enter le theme de cartes que vous voulez : \n 1 : Cartes couleurs \n 2 : Cartes mots \n 3 : Cartes mots et couleurs \n 4 : Cartes images de lolcats \n 5 : Cartes Image \n 6 : Cartes mélange de tous les thmes");
				try{
					them  = Integer.parseInt(buff); 
					}catch(NumberFormatException e){
					}
			}
			
			switch (nivo) {
		        case 1:  nivo = 2;
		        		lign=3;
		        		col=2;
		                 break;
		        case 2:  nivo = 7;
		        		lign=4;
		        		col=3;
		                 break;
		        case 3:  nivo = 11;
		        		lign=5;
		        		col=5;
		        		break;
		        default: nivo = 11;
		        		lign=5;
		        		col=5;
	                 break;
			}
			
			
			switch (them) {
	        case 1:   
	        	GenerateurDeCartesCouleurs c = new GenerateurDeCartesCouleurs(nivo);
		    	    TabC = c.getT();
		    		PanneauDeCartes pane = new PanneauDeCartes(lign,col,TabC,dai,dap);
	                 break;
	        case 2:  GenerateurDeCartesMots c1 = new GenerateurDeCartesMots(nivo);
				    TabC = c1.getT();
					PanneauDeCartes pane1 = new PanneauDeCartes(lign,col,TabC,dai,dap);
	                 break;
	        case 3:  GenerateurDeCartesMotsC c2 = new GenerateurDeCartesMotsC(nivo);
				    TabC = c2.getT();
					PanneauDeCartes pane2 = new PanneauDeCartes(lign,col,TabC,dai,dap);
	        		break;
	        case 4:GenerateurDeCartesImages c3 = new GenerateurDeCartesImages(nivo);
				    TabC = c3.getT();
					PanneauDeCartes pane3 = new PanneauDeCartes(lign,col,TabC,dai,dap);
			break;
	        case 5:GenerateurDeCartesImages2 c4 = new GenerateurDeCartesImages2(nivo);
				    TabC = c4.getT();
					PanneauDeCartes pane4 = new PanneauDeCartes(lign,col,TabC,dai,dap);
			break;
	        case 6:GenerateurDeCartesTheme c5 = new GenerateurDeCartesTheme(nivo);
				    TabC = c5.getT();
					PanneauDeCartes pane5 = new PanneauDeCartes(lign,col,TabC,dai,dap);
					break;
	        default: GenerateurDeCartesImages c6 = new GenerateurDeCartesImages(nivo);
				    TabC = c6.getT();
					PanneauDeCartes pane6 = new PanneauDeCartes(lign,col,TabC,dai,dap);
					break;
			}
		}
		
		
	}


 