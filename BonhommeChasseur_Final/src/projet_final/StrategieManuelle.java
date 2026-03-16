package projet_final;
import java.util.Scanner;

public class StrategieManuelle implements DeplacementStrategy {
	private static Scanner scanner = new Scanner(System.in);
	
	@Override
	public Cellule choisirCase(Joueur j, Grille g) {
		 System.out.println("Z: Haut, S: Bas, Q: Gauche, D: Droite");
	        System.out.print("Votre choix : ");
	        
	        String choix = scanner.nextLine().toUpperCase();
	        
	        int x = j.getPosition().x;
	        int y = j.getPosition().y;

	        // Calcul de la nouvelle position selon la touche
	        switch (choix) {
	            case "Z": x--; break;
	            case "S": x++; break;
	            case "Q": y--; break;
	            case "D": y++; break;
	            default:
	                System.out.println("Touche invalide, vous ne bougez pas.");
	                return j.getPosition();
	        }
	        
			if (x >= 0 && x < g.grille.length && y >= 0 && y < g.grille[0].length) {
				return g.grille[x][y]; //retourne la cellule choisie
	        } else {
	            System.out.println("Déplacement impossible : hors grille !");
	            return j.getPosition();	
	        }
	}

}
