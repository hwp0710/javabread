package my.study.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 将一个任务拆分为多个子任务去执行，可以很好的提升执行效率，但是并不是拆分的子任务越多执行效率越快，
 * 因为拆分子任务也是基于多线程思想执行，而系统中创建线程本来就是一种比较消耗时间和系统资源的。
 * 那么，在需要拆分任务的时候，应该拆分多少个任务才合理呢？参考如下算法：
 * <p>
 * 常见方法——计算密集型，设为CPU个数+1；IO密集型，设为2*CPU个数+1
 * 精确计算——（ IO等待时间/CPU计算时间 + 1 ）* CPU个数
 * https://www.ibm.com/developerworks/cn/java/j-lo-forkjoin/index.html
 */
public class ForkJoinCalculator implements Calculator {
    private ForkJoinPool pool;

    public ForkJoinCalculator() {
        // 也可以使用公用的 ForkJoinPool：设定线程池大小
        System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "5");
        pool = ForkJoinPool.commonPool();
//        pool = new ForkJoinPool();
    }

    @Override
    public long sumUp(long[] numbers) {
        return pool.invoke(new SumTask(numbers, 0, numbers.length - 1));
    }

    private static class SumTask extends RecursiveTask<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            // 当需要计算的数字小于6时，直接计算结果
            if (to - from < 100) {
                long total = 0;
                for (int i = from; i <= to; i++) {
//                    total += numbers[i];
                    total = CalculatorUtils.add(total, numbers[i]);
                }
                return total;
                // 否则，把任务一分为二，递归计算
            } else {
                int middle = (from + to) / 2;
                SumTask taskLeft = new SumTask(numbers, from, middle);
                SumTask taskRight = new SumTask(numbers, middle + 1, to);
                taskLeft.fork();
                taskRight.fork();
                return taskLeft.join() + taskRight.join();
            }
        }
    }
}
