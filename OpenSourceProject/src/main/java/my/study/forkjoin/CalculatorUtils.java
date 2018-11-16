package my.study.forkjoin;

public class CalculatorUtils {
    public static long add(long l1, long l2) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return l1 + l2;
    }
}