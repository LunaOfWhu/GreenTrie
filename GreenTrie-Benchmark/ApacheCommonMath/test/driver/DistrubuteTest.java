package test.driver;


import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.exception.MathArithmeticException;

public class DistrubuteTest {

	


	/**
	 * 
	 * @ClassName: DistributionTest 
	 * @Description: �ֲ�
	 * @author zengfh 
	 * @date 2014��11��21�� ����3:32:15 
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
		 * test for example ������װ���������볬���ĸ��ʡ�
		 * ĳ���Ϲ�˾װƿ�����Ͻ���ÿ������װ��������ƽ��600��������׼��3�����ĳ�̬���䷨��
		 * �����ѡȡһ�ޣ���������605�����ĸ��ʣ�����С��590�����ĸ��� ��������605�����ĸ��� = p ( X > 605)= p ( ((X-��)
		 * /��) > ( (605 �C 600) / 3) )= p ( Z > 5/3) = p( Z > 1.67) = 0.0475
		 * ����С��590�����ĸ��� = p (X < 590) = p ( ((X-��) /��) < ( (590 �C 600) / 3) )= p ( Z
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
