package projet_final;

public class Element implements ElementInterface {
	public int valeur;
	
	public Element (int valeur) {
		this.valeur = valeur;
	}

	public int getValeur() {
		return valeur;
	}

	@Override
	public int getEnergie() {
		// TODO Auto-generated method stub
		return this.valeur;
	}

}
