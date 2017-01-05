package test.driver;

import org.apache.commons.math3.random.RandomDataGenerator;
import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.StatUtils;

public class RandomTest {
	/**
	 * 
	 * @ClassName: RandomTest
	 * @Description: 随机生成和统计初步
	 * @author zengfh
	 * @date 2014年11月21日 下午2:23:04
	 * 
	 */

		/**
		 * @param args
		 */
		public static void main(String[] args) {
			random(1,6,5,0,10,3);
		}

		private static void random(int one,int six,int five,int zero,int ten,int three) {
			// TODO Auto-generated method stub
			RandomDataGenerator randomData = new RandomDataGenerator();

			// Generate a random int value uniformly distributed between lower and
			// upper, inclusive
			System.out.println("a uniform value: " + randomData.nextInt(one, six));
			// Returns a random value from an Exponential distribution with the
			// given mean
			System.out.println("a Exponential value: "
					+ randomData.nextExponential(five));
			// Generate a random value from a Normal
			System.out.println("a Normal value: " + randomData.nextGaussian(zero, one));
			// Generates a random value from the Poisson distribution with the given
			// mean
			System.out.println("a Poisson value: " + randomData.nextPoisson(three));
			// Generates an integer array of length k whose entries are selected
			// randomly, without repetition, from the integers 0 through n-1
			int[] a = randomData.nextPermutation(ten, three);
			for (int i = 0; i < a.length; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println();

			// generate 1000 numbers between 0 and 3 inclusive, then using frequency
			// to see the distribution

			Frequency freq = new Frequency();
			int value = 0;
			for (int i = 0; i < 1000; i++) {
				value = randomData.nextInt(0, 3);
				freq.addValue(value);
			}
			long[] observed = new long[4];
			double[] perc = new double[4];
			for (int i = 0; i < 4; i++) {
				observed[i] = freq.getCount(i);
				perc[i] = freq.getPct(i);
				System.out.println("there are " + observed[i] + " " + i
						+ " in dataset with " + (perc[i] * 100) + "%");
			}

			// stat test
			double[] data = { 1d, 2d, 2d, 3d };
			System.out.println("sum of data is " + StatUtils.sum(data));
			System.out.println("sum of square of data is " + StatUtils.sumSq(data));
			System.out.println("var of data is " + StatUtils.variance(data));
			System.out.println("mean of data is " + StatUtils.mean(data));
			System.out.println("max value of data is " + StatUtils.max(data));
			System.out.println("min value of data is " + StatUtils.min(data));
			System.out.println("geometry mean of data is "
					+ StatUtils.geometricMean(data));
			System.out.println("product of data is " + StatUtils.product(data));
		}

	}

