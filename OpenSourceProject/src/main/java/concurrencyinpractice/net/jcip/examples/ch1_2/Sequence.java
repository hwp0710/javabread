package concurrencyinpractice.net.jcip.examples.ch1_2;

import concurrencyinpractice.net.jcip.annotations.GuardedBy;
import concurrencyinpractice.net.jcip.annotations.ThreadSafe;

/**
 * Sequence
 *
 * @author Brian Goetz and Tim Peierls
 */

@ThreadSafe
public class Sequence {
	@GuardedBy("this")
	private int nextValue;

	public synchronized int getNext() {
		return nextValue++;
	}
}
