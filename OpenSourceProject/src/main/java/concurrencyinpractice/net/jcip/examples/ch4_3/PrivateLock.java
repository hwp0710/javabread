package concurrencyinpractice.net.jcip.examples.ch4_3;

import concurrencyinpractice.net.jcip.annotations.GuardedBy;

/**
 * PrivateLock
 * <p/>
 * Guarding state with a private lock
 *
 * @author Brian Goetz and Tim Peierls
 * @param <Widget>
 */
public class PrivateLock<Widget> {
	private final Object myLock = new Object();
	@GuardedBy("myLock")
	Widget widget;

	void someMethod() {
		synchronized (myLock) {
			// Access or modify the state of widget
		}
	}
}
