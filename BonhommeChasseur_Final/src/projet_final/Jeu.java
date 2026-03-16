package projet_final;

public class Jeu implements Observer{
	public Joueur tours; 
	public boolean partieEnCours;
	public Grille grille; 
	
	private Chasseur chasseur;
	private Bonhomme bonhomme;
	
	public Jeu(Grille grille, Chasseur chasseur, Bonhomme bonhomme) {
        this.grille = grille;
        this.chasseur = chasseur;
        this.bonhomme = bonhomme;
        this.partieEnCours = true;
        
        chasseur.addObserver(this); //jeu devient observer 
        bonhomme.addObserver(this);

    }
	
	public void jouerTour() {
		grille.afficherPourJoueur(bonhomme);

		if (!partieEnCours) return;
			
	        System.out.println("----- Nouveau Tour -----");
	        
	        // TOUR BONHOMME
	        if (partieEnCours) {
	            System.out.println("C'est au tour du bonhomme");
	            System.out.println("Position actuelle : (" + bonhomme.getPosition().x + "," + bonhomme.getPosition().y + ")");
	            
	            bonhomme.jouerTour(this.grille);
	        }
	        
	        // Vérifier si partie toujours en cours
	        if (!partieEnCours) {
	            return;
	        }
	        
	        // TOUR CHASSEUR
	        System.out.println("C'est au chasseur de jouer");
	        chasseur.jouerTourAuto(this.grille, this.bonhomme);

	    
	}
	
	public void verifierCollision() {
	    Cellule posChasseur = chasseur.getPosition();
	    Cellule posBonhomme = bonhomme.getPosition();

	    if (posChasseur.x == posBonhomme.x && posChasseur.y == posBonhomme.y) {
	        System.out.println("Le chasseur a attrapé le bonhomme. Vous avez perdu.");
	        this.partieEnCours = false;
	    
	    }
	    
	}
	    
	public void verifierCible() {
		Cellule posBonhomme = bonhomme.getPosition();
		if (posBonhomme.x == grille.cible.x && posBonhomme.y == grille.cible.y) {
			System.out.println("Bravo, vous avez atteint la cible!");
			this.partieEnCours = false;
		}
	}
	
	
	
	
	
	@Override
	  public void update(JeuEvent event) {
		
		// observer déclenché
        switch(event.getType()) {

            case POSITION_CHANGE:
                verifierCollision();
                verifierCible();
                break;

            case ENERGY_CHANGE:
                Joueur j = (Joueur) event.getSource(); 
                if (!j.estVivant()) {
                    System.out.println("Un joueur n'a plus d'énergie.");
                    partieEnCours = false;
                }
                break;

            case JEU_FINI:
                partieEnCours = false;
                break;
        }
	    }
	}
	



