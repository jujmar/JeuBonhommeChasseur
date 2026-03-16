package projet_final;

public class JeuEvent {
	public enum Type{
		ENERGY_CHANGE, 
		POSITION_CHANGE, 
		JEU_FINI
	}
	
	private Type type;
	private Object source;
	
	public JeuEvent(Type type, Object source) {
		this.type = type;
		this.source=source; 
		
	}
	public Type getType() {
		return type;		
	}
	public Object getSource() { 
		return source; }
	
	
}