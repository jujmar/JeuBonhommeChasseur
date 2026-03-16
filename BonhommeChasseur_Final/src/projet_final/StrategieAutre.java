package projet_final;

import java.util.List;

public class StrategieAutre implements DeplacementStrategy {

	@Override
	public Cellule choisirCase(Joueur j, Grille g) {
		List<Cellule> voisins = g.getVoisins(j.getPosition());
        
        // On cherche un voisin qui n'est pas dans l'historique du joueur
        for (Cellule v : voisins) {
            if (!j.getHistorique().contains(v)) {
                System.out.println("Nouvelle case détectée !");
                return v;
            }
        }
        // Si tout est visité, on prend le premier voisin par défaut
        return voisins.get(0);
	}

}
