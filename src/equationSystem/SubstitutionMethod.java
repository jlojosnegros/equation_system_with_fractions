package equationSystem;

public class SubstitutionMethod extends SolutionMethod {

	@Override
	protected void resolve() {
		super.resolve();
		String names[] = this.prepareNames();
		this.clearIncognitoLastEquation(2, names);
		this.clearIncognitoLastEquation(6, names);
		this.igualationTwoClearedIncognitoEquations(1, 6, names);
		System.out.println(this.equationList);
	}

	@Override
	protected void resolveUsingFractions() {
		super.resolve();
		String names[] = this.prepareNames();
		this.clearIncognitoLastEquationUsingFractions(2, names);
		this.clearIncognitoLastEquationUsingFractions(6, names);
		this.igualationTwoClearedIncognitoEquationsUsingFractions(1, 6, names);
		System.out.println(this.equationList);
	}
	private void clearIncognitoLastEquation(int before, String[] names) {
		this.copyLastEquation(before);
		this.getLastEquation(1).multiply(
				1 / this.getLastEquation(before + 1).getValue(names[0]));
		float valueY = this.getLastEquation(1).getValue(names[1]);
		if (valueY != 0) {
			this.copyLastEquation(1);
			this.getLastEquation(1).add(new Variable(-valueY, names[1]));
		}
		this.simplifyLasEquation(names);
	}

	private void clearIncognitoLastEquationUsingFractions(int before, String[] names) {
		this.copyLastEquation(before);
		this.getLastEquation(1).multiply(
				this.getLastEquation(before + 1).getFractionValue(names[0]).invert());
		Fraction valueY = this.getLastEquation(1).getFractionValue(names[1]);
		if (!valueY.isZero()) {
			this.copyLastEquation(1);
			this.getLastEquation(1).add(new Variable(valueY.multiply(-1), names[1]));
		}
		this.simplifyLasEquation(names);
	}

	private void igualationTwoClearedIncognitoEquations(int firstBefore,
			int secondBefore, String[] names) {
		Equation firstEquation = this.getLastEquation(firstBefore);
		Equation secondEquation = this.getLastEquation(secondBefore);
		this.equationList.add(new Equation(new Expression[] {
				firstEquation.getExpression(Side.RIGHT),
				secondEquation.getExpression(Side.RIGHT) }));
		this.copyLastEquation(1);
		this.getLastEquation(1).add(new Constant(-firstEquation.getValue(Side.RIGHT)));
		this.simplifyLasEquation(names);
	}

	private void igualationTwoClearedIncognitoEquationsUsingFractions(int firstBefore,
																	  int secondBefore, String[] names) {
		Equation firstEquation = this.getLastEquation(firstBefore);
		Equation secondEquation = this.getLastEquation(secondBefore);
		this.equationList.add(new Equation(new Expression[] {
				firstEquation.getExpression(Side.RIGHT),
				secondEquation.getExpression(Side.RIGHT) }));
		this.copyLastEquation(1);
		this.getLastEquation(1).add(new Constant(firstEquation.getFractionValue(Side.RIGHT).multiply(-1)));
		this.simplifyLasEquation(names);
	}
}
