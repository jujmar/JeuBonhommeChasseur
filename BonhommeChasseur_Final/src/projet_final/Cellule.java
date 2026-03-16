package projet_final;

public class Cellule {
	public int x; 
	public int y; 
	public ElementInterface element; 
	
	public Cellule (int x, int y) {
		this.x = x; 
		this.y = y;
		this.element = null; 
	}
	
	public int getX() {
		return x;
		}
	
	public int getY() {
		return y;
	}

	public ElementInterface getElement() {
		return element;
	}
	

	
	public void setElement(ElementInterface element) {
		this.element = element;
	}

	@Override
	public String toString() {
	    return "(" + x + ", " + y + ")";
	}


	


	

	
	
	
}
