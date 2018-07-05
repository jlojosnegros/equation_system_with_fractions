package equationSystem;

public class Fraction {

	private int num;

	private int den;

	public Fraction(int num, int den) {
		this.num = num;
		this.den = den;
	}

	public Fraction multiply(int value) {
		Fraction result = new Fraction(value * num, den);
		result.simplify();
		return result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + den;
		result = prime * result + num;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraction other = (Fraction) obj;
		if (den != other.den)
			return false;
		if (num != other.num)
			return false;
		return true;
	}

	public Fraction add(Fraction fraction) {
		final int num = this.num * fraction.den + fraction.num * this.den;
		final int den = this.den * fraction.den;
		Fraction result = new Fraction(num, den);
		result.simplify();
		return result;
	}

	private void simplify() {
		// ecluides's alg
		int a = Math.abs(num);
		int b = Math.abs(den);
		if (a > 0 && b > 0) {
			int gcd = this.gcd(a,b);
			this.num /= gcd;
			this.den /= gcd;
		}
	}
	private int gcd(int a, int b ) {
		if (a == b) return a;
		if (a > b) {
			return gcd(a-b, b);
		}
		else {
			return gcd(a,b-a);
		}
	}
	@Override
	public String toString() {
		return "(" + Math.abs(this.num )+ "/" + this.den + ")";
	}

	public float toNumber() {
		return (float)this.num / (float)this.den;
	}

	public boolean isZero() {
		return (this.num == 0) && (this.den != 0);
	}
}
