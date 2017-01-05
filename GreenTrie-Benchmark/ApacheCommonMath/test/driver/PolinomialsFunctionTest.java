package test.driver;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;

public class PolinomialsFunctionTest {




	/**
	 * 
	 * @ClassName: PolinomialsFunctionTest 
	 * @Description: 多项式函数 
	 * @author zengfh 
	 * @date 2014年11月21日 下午1:38:13 
	 *
	 */

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			
			double[] f1_coeff = { 3.0, 6.0, -2.0, 1.0 };
			double[] f2_coeff = { 1.0, 2.0, -1.0, -2.0 };
			// TODO Auto-generated method stub
			polynomials(f1_coeff,f2_coeff);
			System.out.println("-----------------------------------------------");
			polynomialsSpline();
		}

		private static void polynomialsSpline() {
			// TODO Auto-generated method stub
			PolynomialFunction[] polynomials = {
					new PolynomialFunction(new double[] { 0d, 1d, 1d }),
					new PolynomialFunction(new double[] { 2d, 1d, 1d }),
					new PolynomialFunction(new double[] { 4d, 1d, 1d }) };
			double[] knots = { -1, 0, 1, 2 };
			PolynomialSplineFunction spline = new PolynomialSplineFunction(knots,
					polynomials);
			// output directly
			System.out.println("poly spline func is " + spline);
			// get the value when x = 0.5
			try {
				System.out.println("f(0.5) = " + spline.value(0.5));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// the number of spline segments
			System.out.println("spline segments number is " + spline.getN());
			// the polynomials functions
			for (int i = 0; i < spline.getN(); i++) {
				System.out.println("spline:f" + i + "(x) = "
						+ spline.getPolynomials()[i]);
			}
			// function derivative
			System.out.println("spline func derivative is " + spline.derivative());
		}

		private static void polynomials(double[] f1_coeff,double[] f2_coeff) {
			// TODO Auto-generated method stub
			
			PolynomialFunction f1 = new PolynomialFunction(f1_coeff);
			PolynomialFunction f2 = new PolynomialFunction(f2_coeff);
			// output directly
			System.out.println("f1(x) is : " + f1);
			System.out.println("f2(x) is : " + f2);
			// polynomial degree
			System.out.println("f1(x)'s degree is " + f1.degree());
			// get the value when x = 2
			System.out.println("f1(2) = " + f1.value(2));
			// function add
			System.out.println("f1(x)+f2(x) = " + f1.add(f2));
			// function substract
			System.out.println("f1(x)-f2(x) = " + f1.subtract(f2));
			// function multiply
			System.out.println("f1(x)*f2(x) = " + f1.multiply(f2));
			// function derivative
			System.out.println("f1'(x) = " + f1.derivative());
			System.out.println("f2''(x) = "
					+ ((PolynomialFunction) f2.derivative()).derivative());

		}

	}
