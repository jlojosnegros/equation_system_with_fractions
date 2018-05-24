package equationSystem;

import java.util.Set;

public abstract class Term {

	private float value;
	
	protected Term(float value){
		this.value = value;
	}
	
	public float getValue() {
		return value;
	}
	
	public void multiply(float value) {
		this.value *= value;
	}

	public boolean hasName(String name) {
		assert name != null;
		return false;
	}
	
	public boolean hasName(Set<String> nameSet) {
		assert nameSet != null;
		return false;
	}
	
	public boolean equal(Term term){
		assert term != null;
		return this.getValue()== term.getValue(); 
	}
	
	public abstract Term clon();
	
	@Override
	public String toString() {
		return " " + (value>=0?"+":"") + value;
	}
	
	public abstract void dispatch(TermVisitor termVisitor);

}
