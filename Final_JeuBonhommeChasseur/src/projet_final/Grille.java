package projet_final;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grille {
	public Cellule cible;
	private int n; // grille carre 
	public Cellule [][] grille; //grille composés de cellules 
	private Random random = new Random();
	
	public Grille(int n) {
		this.n = n; 
		this.grille = new Cellule[n][n];
        initialiser();
    }
	
	public int getTaille() {
	    return n;
	}
	
	
	public void initialiser() {
		for(int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				grille[i][j]= new Cellule(i,j);
			}
		}
		placerCible();
		placerElements(n,1,5);
	}
	
	public Cellule getCellule(int ligne, int colonne) {
		return grille [ligne][colonne];
	}
	
	public Cellule getCible() {
		return cible;
		
	}

	
	public void placerCible() {
		int i = random.nextInt(n);
		int j = random.nextInt(n);
		
		cible = grille[i][j];

	}
	
	public void placerElements(int nbElements, int valeurMin, int valeurMax ) {
	
		  int compteur = 0;
		  while (compteur < nbElements) {
		        int i = random.nextInt(n);
		        int j = random.nextInt(n);

		        Cellule c = grille[i][j];

		        if (c.equals(cible)) continue; // si cellule = cible non 
		        if (c.getElement() != null) continue; // si deja element 

		        int valeur = random.nextInt(valeurMax - valeurMin + 1) + valeurMin; // valeur aleatoire 

		        // on évite 0 
		        if (valeur == 0) continue;

		        c.setElement(ElementFactory.creerElement(valeur));		        
		        compteur++;
		    }
		
	}
		
	public List<Cellule> getVoisins(Cellule c) {
		List<Cellule> voisins = new ArrayList<>();
		int x = c.getX(); // On choppe le x puis le y de la cellule
		int y = c.getY(); // Tout ça pour trouver les cases adjacentes

	    if (x > 0) { //Voisin haut
	    	voisins.add(grille[x - 1][y]);
	    }
	    
	    if (x < n - 1) { // voisin bas
	    	voisins.add(grille[x + 1][y]);
	    }
	    
	    if (y > 0) { // Voisin gauche
	    	voisins.add(grille[x][y - 1]);
	    }
	    
	    if (y < n - 1) {//voisin droite
	    	voisins.add(grille[x][y + 1]); 
	    }
	    
	    return voisins; // ca donne ma liste de voisins
	}
	

    private int calcDistance(Cellule a, Cellule b) {
        return Math.abs(a.getX() - b.getX())
             + Math.abs(a.getY() - b.getY());
    }

	
	public Cellule getCaseVersCible(Cellule positionChasseur) {
		List<Cellule> voisins = getVoisins(positionChasseur);
		
		if (voisins.isEmpty()) return null;
		
		Cellule meilleureCase = voisins.get(0); // va prendre la position voisine la plus proche
		int distanceMin = calcDistance(voisins.get(0), cible); //pour avoir une valeur à comparer dès le premier passage
		
		for (Cellule v : voisins) { // pour chaque cellule v présente dans la liste voisin (v est une variable temp)
	        int d = calcDistance(v, cible);
	        if (d < distanceMin) {
	            distanceMin = d;
	            meilleureCase = v;
	        }
	    }
		
		return meilleureCase;

	}
	
	public void afficherPourJoueur(Bonhomme joueur) {

	    for(int i = 0; i < n; i++) {
	        for(int j = 0; j < n; j++) {

				Cellule c = grille[i][j];

	            if(c == joueur.getPosition()) {
	                System.out.print("J ");
	            }
	            else {
	                System.out.print(". ");
	            }

	        }
	        System.out.println();
	    }
	    
	}
} 