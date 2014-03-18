import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;



public class PanneauDeCartes extends JPanel{
	private JPanel paneJ = new JPanel();
	private JPanel paneI = new JPanel();
	private int nRanges = 0;
	private int nColonnes = 0;
	private Carte[] TabC;
	private int delaiAI = 0;
	private int delaiAM = 0;
	private Carte C1 ;
	private Carte C2 ;
	private static int test = 0;	
	private JFrame frame = new JFrame("Jeu Memory! (By Stephane Ferreira)");
	private int nbTest = 0;
	private JLabel nbCoup;
	private int des = 1 ;
	private int coupB =0;
	
	public PanneauDeCartes(int nRangees, int nColonnes, Carte[] cartes,int delaiAffichageInitial, int delaiAffichageMauvaisePaire){
			this.nRanges = nRangees;
			this.nColonnes = nColonnes;
			this.TabC = cartes;
			this.delaiAI = delaiAffichageInitial;
			this.delaiAM = delaiAffichageMauvaisePaire;
			
			
			//Création des composent Graphique
			GridLayout layout = new GridLayout(nRangees,nColonnes);
			layout.setHgap(10);
			layout.setVgap(10);
			setLayout(layout);
			nbCoup = new JLabel("Coups joué : 0 coup");
			paneJ.setLayout(layout);

			//écouteur de fermeture de fenetre
			frame.addWindowListener(new MyWindowListener());
			paneJ.setLayout(layout);
			
			//ajout des carte dans le paneau avec un écouteur coté  visible
			for(int i =0;i < cartes.length;i++){
				paneJ.add(cartes[i]);
				cartes[i].addMouseListener(new MyActionListener());
			}
			//delai affichage initial
			Timer t;
			t = new Timer(delaiAI, new Test3());
			t.setRepeats(false);
			t.start();		

			
			
			//affichage de farme
			frame.getContentPane().add(paneJ, BorderLayout.CENTER); 
			frame.setSize(240*nColonnes+200,240*nRanges);
			//frame.pack();
			frame.show();

    }

	public void gagne(){
		JOptionPane.showMessageDialog(this,"Vous avez gagné en : " +nbTest+" coups !");
	}
	
	//fermer la fenetre
	private class MyWindowListener extends WindowAdapter { 
		public void windowClosing(WindowEvent event) {
			System.exit(0); 
		}
	}
	
	

	
	//gestion du clik
	class MyActionListener extends MouseAdapter{
		  
		public void mouseClicked(MouseEvent event){ 
			Timer tIdentique;
			tIdentique = new Timer(100, new Test());
			tIdentique.setRepeats(false);
			
			Timer tPabon;
			tPabon = new Timer(delaiAM, new Test1());
			tPabon.setRepeats(false);
			
			if(des ==0){		
				if(test == 0){
					C1 = (Carte) event.getSource();
					C1.retourne();
					test++;
					nbTest++;
					nbCoup.setText("Coups joué : "+Integer.toString(nbTest)+" coups");
					frame.repaint();
				}
				else{
					C2 = (Carte) event.getSource();
					if(C1!=C2){
						test--;
						if(C1.rectoIdentique(C2)){
							des=1;
							C2.retourne();
							frame.repaint();
							tIdentique.start();		
							coupB++;
							if(coupB==(TabC.length)/2){
								gagne();
							}
						}
						else{
							des=1;
							C2.retourne();
							frame.repaint();			
							tPabon.start();								
						}
					}
				}
			}
		}
		 class Test implements ActionListener{
			 public void actionPerformed(ActionEvent event)
			          {
			            C1.trouv();
						C2.trouv();
			            frame.repaint();
			            des=0;
			          }
		 }
		 class Test1 implements ActionListener{
			 public void actionPerformed(ActionEvent event)
			          {
				     	C2.retourne();
				     	C1.retourne();
					 	frame.repaint();
					 	des=0;
			          }
		 }
		
	}
	 class Test3 implements ActionListener{
		 public void actionPerformed(ActionEvent event)
		          {
					for(int i =0;i < TabC.length;i++){
						paneJ.add(TabC[i]);
						TabC[i].retourne();
						paneJ.add(nbCoup,BorderLayout.EAST);
						des=0;
						frame.repaint();
					}
		          }
	 }
}
