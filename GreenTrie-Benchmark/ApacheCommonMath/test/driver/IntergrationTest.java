package test.driver;

import org.apache.commons.math3.analysis.UnivariateFunction;
import org.apache.commons.math3.analysis.function.Sin;
import org.apache.commons.math3.analysis.integration.BaseAbstractUnivariateIntegrator;
import org.apache.commons.math3.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math3.exception.ConvergenceException;


public class IntergrationTest {


	/**
	 * 
	 * @ClassName: IntegrationTest 
	 * @Description: 函数积分 
	 * @author zengfh 
	 * @date 2014年11月21日 下午2:59:58 
	 *
	 */
		/**
		 * @param args
		 */
		public static void main(String[] args) {
			integration(0.0,3.14);
		}

		private static void integration(double d,double f2) {
			// TODO Auto-generated method stub
			UnivariateFunction f = new Sin();
			BaseAbstractUnivariateIntegrator integrator = new SimpsonIntegrator();

			// integrate
			System.out.println("f(x)=sin(x)");
			try {
				System.out.println("integration of f(x) from 0 to Pi is "
						+ integrator.integrate(100,f, d, f2));
			} catch (ConvergenceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

