package equationSystem;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

public class EquationSystemTest {

	@Test
	public void reductionMethodTest() {
		double precission = 0.00001;
		String name1 = "x";
		String name2 = "y";
		EquationSystem equationSystem = new EquationSystemBuilder()
			.equation().term(2,name1).term(4,name2).equals().term(4)
			.equation().term(5,name1).term(-9,name2).equals().term(-2)
			.build();
		equationSystem.resolve(new ReductionMethod());
		assertEquals(0.73684216, equationSystem.getSolution(name1), precission);
		assertEquals(0.6315789, equationSystem.getSolution(name2), precission);
	}

	@Test
	public void reductionMethodUsingFractionsTest() {
		String name1 = "x";
		String name2 = "y";
		EquationSystem equationSystem = new EquationSystemBuilder()
				.equation().term(2,name1).term(4,name2).equals().term(4)
				.equation().term(5,name1).term(-9,name2).equals().term(-2)
				.build();
		equationSystem.resolveUsingFractions(new ReductionMethod());
		assertEquals(new Fraction(14,19), equationSystem.getSolutionUsingFractions(name1));
		assertEquals(new Fraction(12, 19), equationSystem.getSolutionUsingFractions(name2));
	}
	
	@Ignore
	public void substitutionMethodTest() {
		double precission = 0.00001;
		String name1 = "x";
		String name2 = "y";
		EquationSystem equationSystem = new EquationSystemBuilder()
			.equation().term(2,name1).term(4,name2).equals().term(4)
			.equation().term(5,name1).term(-9,name2).equals().term(-2)
			.build();
		equationSystem.resolve(new SubstitutionMethod());
		assertEquals(0.73684216, equationSystem.getSolution(name1), precission);
		assertEquals(0.6315789, equationSystem.getSolution(name2), precission);		
	}

	@Test
	public void substitutionMethodTestUsingFractions() {
		String name1 = "x";
		String name2 = "y";
		EquationSystem equationSystem = new EquationSystemBuilder()
				.equation().term(2,name1).term(4,name2).equals().term(4)
				.equation().term(5,name1).term(-9,name2).equals().term(-2)
				.build();
		equationSystem.resolveUsingFractions(new SubstitutionMethod());
		assertEquals(new Fraction(14,19), equationSystem.getSolutionUsingFractions(name1));
		assertEquals(new Fraction(12, 19), equationSystem.getSolutionUsingFractions(name2));
	}

}
