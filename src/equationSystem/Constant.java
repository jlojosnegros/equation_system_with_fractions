package equationSystem;

public class Constant extends Term {

	public Constant(float value){
		super(value);
	}
	public Constant (int num, int den) {
		super (num, den);
	}
	public Constant (Fraction fraction) {
		super (fraction);
	}
	@Override
	public boolean equal(Term term) {
		assert term != null;
		return super.equal(term) && term instanceof Constant;
	}

	@Override
	public Term clon() {
		return new Constant(this.getFractionValue());
	}

	@Override
	public void dispatch(TermVisitor termVisitor) {
		assert termVisitor != null;
		termVisitor.visit(this);
	}
	
}
