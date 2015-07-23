package chap1;
// Lesson 1 exercise on Algo analysis. input two args a&b to get log2(a/b)


class Logarithm {

	static public double log(double value, double base) {

		return Math.log(value) / Math.log(base);

	}

}

public class Log {

	public static void main(String[] args) {
		double a = Double.parseDouble(args[0]);
		double b = Double.parseDouble(args[1]);
		double m = Logarithm.log(a/b,2.000);
		System.out.println(m);
	}

}
