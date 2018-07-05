package equationSystem;

import java.util.Set;

public abstract class Term {

	private float value;
	private Fraction fractionValue;
	
	protected Term(float value){
		this.value = value;
        this.fractionValue = fractionate(value);
	}
	protected Term(int num, int denom) {
		this.fractionValue = new Fraction(num,denom);
		this.value = this.fractionValue.toNumber();
	}
	protected Term(Fraction fraction) {
		this.fractionValue = fraction;
		this.value = this.fractionValue.toNumber();
	}

	public float getValue() {
		return value;
	}

	public Fraction getFractionValue() {
		return fractionValue;
	}

    private Fraction fractionate(float value) {
        float threshold = (float) 0.000005;
        int denominator = 1;
        while (Math.abs(value - Math.round(value)) > threshold)
        {
            value *= 10.0;
            threshold *= 10.0;
            denominator*= 10;
        }
        return new Fraction((int) value, denominator);
    }

	public void multiply(float value) {
		this.value *= value;
		this.fractionValue = fractionate(this.value);
	}

	public void multiply(Fraction value) {
		this.fractionValue = this.fractionValue.multiply(value);
		this.value = this.fractionValue.toNumber();
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
		return " " + (value>=0?"+":"-") + this.fractionValue.toString();
	}
	
	public abstract void dispatch(TermVisitor termVisitor);

}
