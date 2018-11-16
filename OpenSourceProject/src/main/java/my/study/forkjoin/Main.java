package my.study.forkjoin;

import java.util.stream.LongStream;

/**
 * 参考https://blog.csdn.net/qq_32331073/article/details/81504262
 */
public class Main {
    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 10000).toArray();
        Calculator calculator1 = new ForLoopCalculator();
        Calculator calculator2 = new ExecutorServiceCalculator();
        Calculator calculator3 = new ForkJoinCalculator();
        long begin = System.currentTimeMillis();
        System.out.println(calculator1.sumUp(numbers)); // 打印结果500500
        long total = System.currentTimeMillis() - begin;
        System.out.printf("ForLoop total:%sms%n", total);
        begin = System.currentTimeMillis();
        System.out.println(calculator2.sumUp(numbers)); // 打印结果500500
        total = System.currentTimeMillis() - begin;
        System.out.printf("ExecutorService total:%sms%n", total);
        begin = System.currentTimeMillis();
        System.out.println(calculator3.sumUp(numbers)); // 打印结果500500
        total = System.currentTimeMillis() - begin;
        System.out.printf("ForkJoin total:%sms%n", total);
        System.exit(0);
    }
}

