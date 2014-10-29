package concurrencyinpractice.net.jcip.examples.ch8_6;

import java.util.concurrent.ThreadFactory;

import concurrencyinpractice.net.jcip.examples.ch8_7.MyAppThread;

/**
 * MyThreadFactory
 * <p/>
 * Custom thread factory
 *
 * @author Brian Goetz and Tim Peierls
 */
public class MyThreadFactory implements ThreadFactory {
	private final String poolName;

	public MyThreadFactory(String poolName) {
		this.poolName = poolName;
	}

	public Thread newThread(Runnable runnable) {
		return new MyAppThread(runnable, poolName);
	}
}
