package projet_final;
import java.util.ArrayList;
import java.util.List;

public class Joueur {
	
    private List<Observer> observers = new ArrayList<>();
    
    public void addObserver(Observer o) {
        observers.add(o);
    }

    protected void notifyObservers(JeuEvent event) {
        for (Observer o : observers) {
            o.update(event);
            }
    }
    
	
	protected int idJoueur; 
	protected int energie; 
	protected Cellule position; 	
	protected List<Cellule> historique = new ArrayList<>();
	
	public Joueur(int idJoueur, Cellule positionInitiale, int energie) {
        this.idJoueur = idJoueur;
        this.position = positionInitiale; // peut etre la rendre random 
        this.energie = energie;
        this.historique.add(positionInitiale);
     
    }

	
	public int getEnergie() {
		return energie;
	}
	public boolean estVivant() {
	    return this.energie > 0;
	}
	
	
	public Cellule getPosition() {
		return position;
	}
	
	public void setPosition(Cellule nouvellePosition) {
        this.position = nouvellePosition;
    }
	

	public List<Cellule> getHistorique(){
		return historique;
	}
	
	public boolean seDeplacer(Cellule nouvelle) {
		Cellule actuelle = this.position;
		
	    int dx = Math.abs(nouvelle.x - actuelle.x);
	    int dy = Math.abs(nouvelle.y - actuelle.y);

	    if (dx + dy != 1) {
	        // pas une case adjacente
	    	System.out.println("Déplacement impossible (pas adjacent)");
	        return false;
	    
	    }

		// element
		ElementInterface elementSurCase = nouvelle.getElement();

	    if (elementSurCase != null) {
	    	int valeur = elementSurCase.getEnergie(); // getEnergie c'est l'interface

	        if (valeur > 0) {
	            System.out.println("Vous avez mangé un fruit : vous regagnez de l'énergie.");
	        } else {
	            System.out.println("Vous vous brûlez, cela vous fait perdre de l'énergie.");
	        }
	        
	        this.energie = this.energie + valeur - 1;
	        
	        nouvelle.setElement(null);
	
	
	} else {
		this.energie -= 1;
	}
	    

		// Déplacement effectif
		this.setPosition(nouvelle);
		
		this.historique.add(nouvelle);
		
		notifyObservers(new JeuEvent(JeuEvent.Type.POSITION_CHANGE, this)); // observer maj
		notifyObservers(new JeuEvent(JeuEvent.Type.ENERGY_CHANGE, this));

		if (!estVivant()) {
		        notifyObservers(new JeuEvent(JeuEvent.Type.JEU_FINI, this));
		    }

		return true;
			
		}
	
	}
	  



	
