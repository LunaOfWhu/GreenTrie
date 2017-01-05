package test.jpf;

import java.util.ArrayList;

import gov.nasa.jpf.Config;
import gov.nasa.jpf.JPF;

public class PolinomialsFunction_s1 {
	public static void main(String[] args)	{

//		
		for (Experiment e : experiments) {
			Config conf = JPF.createConfig(JPF_ARGS);
			conf.setProperty("target", e.target);
			conf.setProperty("symbolic.method", e.symbolicMethod);
			JPF jpf = new JPF(conf);
			jpf.run();
		}
	}

	private static final String[] JPF_ARGS = 
			new String[] {"+shell.port=4242", "+site=settings/site.properties", "settings/tsafe.jpf"};
	
	private static class Experiment {
		final String propertyClass;
		final int propertyNumber;
		final String property;
		final String target;
		final String symbolicMethod;
		
		private Experiment(String propertyClass, int propertyNumber) {
			this.propertyClass = propertyClass;
			this.propertyNumber = propertyNumber;
			this.property = this.propertyClass + "_" + this.propertyNumber;
			this.target = "test.driver.PolinomialsFunctionTest" ;
			this.symbolicMethod=this.target+"."+"polynomialsSpline"+"(sym#sym)";
		}
		
		private static class Continuation {
			private final ArrayList<Experiment> experiments = new ArrayList<Experiment>();
			
			public Continuation mk(String propertyClass, int propertyNumber) {
				Experiment e = new Experiment(propertyClass, propertyNumber);
				this.experiments.add(e);
				return this;
			}
			
			private final static Experiment[] ARRAY_OF_EXPERIMENTS = new Experiment[] { };
			
			public Experiment[] ret() {
				return this.experiments.toArray(ARRAY_OF_EXPERIMENTS);
			}
		}
		
		public static Continuation beg() {
			Continuation c = new Continuation();
			return c;			
		}
	}

	/** The list of all the experiments */
	private static final Experiment[] experiments = Experiment.beg().
		// prop_class	prop_n
		//mk("SC_C", 		1).
	//	mk("SC_C", 		2).
		mk("RT_S", 		6).
		/*
		mk("RT_S", 		2).
		mk("TS_D", 		1).
		mk("TS_D", 		2).
		mk("TS_D", 		3).
		mk("TS_D", 		4).
		mk("TS_D", 		5).
		mk("TS_D", 		6).
		mk("TS_R", 		1).
		mk("TS_R", 		2).
		mk("TS_R", 		3).
		mk("TS_R", 		4).
		mk("TS_R", 		5).*/
		ret();
}



//非线性和浮点�?tsafe 和math；－－－数据收集（重用率，执行时间）和Green和ＫＬＥＥ对比；／对green进行改进，使其支持非线�?�约束；
//回归分析�?�?将math的几个版本进行回归测试；
//测试不同的方法�??重用的情况；
//不同规模下：�?自动生成不同规模的程序�??效率比较；�??�?�?
