package projet_final;

public class Bonhomme extends Joueur implements Constantes{
	private DeplacementStrategy strategie;

	
	public Bonhomme(int id, Cellule positionInitiale, int energie) {
		super(id, positionInitiale, energie);
		this.strategie = new StrategieManuelle();
	}
	
	public void jouerTour(Grille grille) {

	    if (this.energie > highValue) {
	        // Mode on choisit n'importe quelle case non explorée
	    	this.strategie = new StrategieAutre();
	        System.out.println("-MODE EXPLO- Énergie haute (" + energie + ") : Exploration en cours...");
	    } else {
	        // Mode manuel avec les touches
	    	this.strategie = new StrategieManuelle();
	        System.out.println("-MODE MANUEL- Énergie basse (" + energie + ") : À vous de jouer !");
	    }

	    // Là on demande la case à la stratégie
	    Cellule destination = this.strategie.choisirCase(this, grille);

	    //Déplacement
	    if (destination != this.position) { // Si on a choisi une nouvelle case
	        boolean success = this.seDeplacer(destination);
	        if (success) {
	            System.out.println("Déplacement vers (" + destination.x + "," + destination.y + ") réussi.");
	        }
	    } else {
	        System.out.println("Vous restez sur place.");
	    }
	}

	
}