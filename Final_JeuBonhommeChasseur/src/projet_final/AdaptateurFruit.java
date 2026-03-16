package projet_final;

public class AdaptateurFruit implements ElementInterface{
	private Fruit fruit; 
	public AdaptateurFruit (Fruit fruit) {
		this.fruit = fruit;
	} 
	
	@Override
	public int getEnergie() {
		return fruit.gainEnergie();
	}

}