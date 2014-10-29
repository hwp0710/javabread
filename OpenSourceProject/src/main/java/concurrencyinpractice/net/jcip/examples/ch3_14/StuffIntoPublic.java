package concurrencyinpractice.net.jcip.examples.ch3_14;

import concurrencyinpractice.net.jcip.examples.ch3_15.Holder;

/**
 * StuffIntoPublic
 * <p/>
 * Unsafe publication
 *
 * @author Brian Goetz and Tim Peierls
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
