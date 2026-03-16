package projet_final;

public class Chasseur extends Joueur {
	
	public Chasseur (int id, Cellule positionInitiale, int energie) {
		super(id, positionInitiale, energie);
	}
	
	public void jouerTourAuto(Grille grille, Bonhomme cibleBonhomme) {
	    // Voisins du chasseur pour checker si il y a le bonhomme
	    java.util.List<Cellule> voisins = grille.getVoisins(this.position);
	    
	    for (Cellule v : voisins) {
	        if (v.equals(cibleBonhomme.getPosition())) {
	            System.out.println("Bonhomme DETECTE ! Le chasseur attrape le bonhomme");
	            this.seDeplacer(v);
	            return; 
	        }
	    }

	    Cellule destination = grille.getCaseVersCible(this.position);
	    this.seDeplacer(destination);
	    System.out.println("Energie du chasseur : " + energie);
	}


}
