package test.driver;


import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.exception.MathArithmeticException;

public class DistrubuteTest {

	


	/**
	 * 
	 * @ClassName: DistributionTest 
	 * @Description: 分布
	 * @author zengfh 
	 * @date 2014年11月21日 下午3:32:15 
	 *
	 */

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			poisson(0.8);
			System.out.println("------------------------------------------");
			normal();
			test();
		}

		/**
		 * test for example 《饮料装填量不足与超量的概率》
		 * 某饮料公司装瓶流程严谨，每罐饮料装填量符合平均600毫升，标准差3毫升的常态分配法则
		 * 。随机选取一罐，容量超过605毫升的概率？容量小于590毫升的概率 容量超过605毫升的概率 = p ( X > 605)= p ( ((X-μ)
		 * /σ) > ( (605 – 600) / 3) )= p ( Z > 5/3) = p( Z > 1.67) = 0.0475
		 * 容量小于590毫升的概率 = p (X < 590) = p ( ((X-μ) /σ) < ( (590 – 600) / 3) )= p ( Z
		 * < -10/3) = p( Z < -3.33) = 0.0004
		 */
		private static void test() {
			// TODO Auto-generated method stub
			NormalDistribution normal = new NormalDistribution(600, 3);
			try {
				System.out.println("P(X<590) = "
						+ normal.cumulativeProbability(590));
				System.out.println("P(X>605) = "
						+ (1 - normal.cumulativeProbability(605)));
			} catch (MathArithmeticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private static void poisson(double onepointeight) {
			// TODO Auto-generated method stub
			PoissonDistribution dist = new PoissonDistribution(4.0);
			try {
				//System.out.println("P(X<=2) = " + dist.cumulativeProbability(2));
				//System.out.println("mean value is " + dist.getMean());
				//System.out.println("P(X=1) = " + dist.probability(1));
				System.out.println("P(X=x)=0.8 where x = "
						+ dist.inverseCumulativeProbability(onepointeight));
			} catch (MathArithmeticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		private static void normal() {
			// TODO Auto-generated method stub
			NormalDistribution normal = new NormalDistribution(0, 1);
			try {
				System.out.println("P(X<2.0) = "
						+ normal.cumulativeProbability(2.0));
				System.out.println("mean value is " + normal.getMean());
				System.out.println("standard deviation is "
						+ normal.getStandardDeviation());
				System.out.println("P(X=1) = " + normal.density(1.0));
				System.out.println("P(X<x)=0.8 where x = "
						+ normal.inverseCumulativeProbability(0.8));
			} catch (MathArithmeticException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
