package projet_final;

public class AdaptateurFeu implements ElementInterface {
	private Feu feu; 
	
	public AdaptateurFeu(Feu feu) {
		this.feu = feu;
		}

	@Override
	public int getEnergie() {
		// TODO Auto-generated method stub
		return this.feu.energieMoins();
	}
	
}