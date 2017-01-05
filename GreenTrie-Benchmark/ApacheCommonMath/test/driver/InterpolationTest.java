package test.driver;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.interpolation.SplineInterpolator;
import org.apache.commons.math3.analysis.interpolation.UnivariateInterpolator;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.polynomials.PolynomialFunctionLagrangeForm;
import org.apache.commons.math3.analysis.polynomials.PolynomialSplineFunction;
import org.apache.commons.math3.exception.MathArithmeticException;

public class InterpolationTest {

	


	/**
	 * 
	 * @ClassName: InterpolationTest 
	 * @Description: 函数插值
	 * @author zengfh 
	 * @date 2014年11月21日 下午3:13:39 
	 *
	 */

		public static void main(String[] args) {
			double x[] = { 0.0, -1.0, 0.5 };
			double y[] = { -3.0, -6.0, 0.0 };
			// TODO Auto-generated method stub
			polynomialsInterpolation(x,y);
			System.out.println("-------------------------------------------");
			interpolatioin();
		}

		private static void interpolatioin() {
			// TODO Auto-generated method stub
			// double x[] = { 0.0, 0.5, 1.0 };
			// double y[] = { 0.0, 0.5, 1.0 };
			double x[] = { 0.0, Math.PI / 6d, Math.PI / 2d, 5d * Math.PI / 6d,
					Math.PI, 7d * Math.PI / 6d, 3d * Math.PI / 2d,
					11d * Math.PI / 6d, 2.d * Math.PI };
			double y[] = { 0d, 0.5d, 1d, 0.5d, 0d, -0.5d, -1d, -0.5d, 0d };
			UnivariateInterpolator i = new SplineInterpolator();
			UnivariateFunction f = null;
			// interpolate y when x = 0.5
			try {
				f = i.interpolate(x, y);
				System.out.println("when x = 0.5, y = " + f.value(0.5));
			} catch (MathArithmeticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// check polynomials functions
			PolynomialFunction polynomials[] = ((PolynomialSplineFunction) f)
					.getPolynomials();
			for (int j = 0; j < polynomials.length; j++) {
				System.out
						.println("cubic spline:f" + j + "(x) = " + polynomials[j]);
			}
		}

		private static void polynomialsInterpolation(double[] x,double[] y) {
			// TODO Auto-generated method stub
			
			PolynomialFunctionLagrangeForm p = new PolynomialFunctionLagrangeForm(
					x, y);
			// output directly
			System.out.println("ugly output is " + p);
			// interpolate y when x = 1.0
			try {
				System.out.println("when x = 1.0, y = " + p.value(1.0));
			} catch (MathArithmeticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// degree
			System.out.println("polynomial degree is " + p.degree());
			// coefficients
			for (int i = 0; i < p.getCoefficients().length; i++) {
				System.out.println("coeff[" + i + "] is " + p.getCoefficients()[i]);
			}
			//
		}

	}

