package my.study.forkjoin;

public class ForLoopCalculator implements Calculator {
    public long sumUp(long[] numbers) {
        long total = 0;
        for (long i : numbers) {
//            total += i;
            total = CalculatorUtils.add(total, i);
        }
        return total;
    }
}