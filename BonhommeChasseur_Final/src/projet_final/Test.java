package projet_final;

public class Test {
	public static void main(String[] args) {
		
		// Initialisation Grille
        Grille g = new Grille(5);
        g.placerElements(5, -3, 3);
        System.out.println("Grille initialisée.");
        
        Cellule cible = g.getCible(); 
        System.out.println("Position de la cible : (" + cible.x + ", " + cible.y + ")");
        
        // LEs joueurs
        Bonhomme b = new Bonhomme(1, g.grille[0][0], 100);
        Chasseur c = new Chasseur(2, g.grille[2][2], 100);

        // Adaptateurs
        Feu f = new Feu(); 
        AdaptateurFeu adpFeu = new AdaptateurFeu(f);
        g.grille[0][1].setElement(adpFeu);
        
        Fruit fr = new Fruit();
        AdaptateurFruit adpFruit = new AdaptateurFruit(fr);
        g.grille[1][0].setElement(adpFruit);

        System.out.println("=== DÉBUT DE LA PARTIE ===");
        
        Jeu nouveauJeu = new Jeu(g, c, b);
        
        while (nouveauJeu.partieEnCours) {
        	nouveauJeu.jouerTour();
        }
        
        System.out.println("Fin du jeu.");
		
		
	     
		}

}
