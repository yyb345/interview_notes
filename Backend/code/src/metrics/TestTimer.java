package metrics;

/**
 * Created by yangyibo
 * Date: 2019/4/30
 * Time: 下午5:36
 */

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Timer;
import com.yammer.metrics.core.TimerContext;
import com.yammer.metrics.reporting.ConsoleReporter;

public class TestTimer {
	private static Timer timer = Metrics.newTimer(TestTimer.class, "responses", TimeUnit.MILLISECONDS,TimeUnit.SECONDS);
	/**
	 * TODO
	 *
	 * @param args
	 * void
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODOAuto-generated method stub
		ConsoleReporter.enable(2,TimeUnit.SECONDS);
		Random rn = new Random();
		timer.time();
		System.out.println();
		while(true){
			TimerContext context = timer.time();

			Thread.sleep(rn.nextInt(1000));
			context.stop();
		}
	}

}
