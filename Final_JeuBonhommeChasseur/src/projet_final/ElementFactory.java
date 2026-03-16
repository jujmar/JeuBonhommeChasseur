package projet_final;

public interface ElementFactory {
	public static ElementInterface creerElement(int valeur){
		if (valeur > 0) {
			Fruit fruit = new Fruit();
			return new AdaptateurFruit(fruit);
		} else {
			Feu feu = new Feu();
			return new AdaptateurFeu(feu);
		}
	}
}
