package my.study.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceCalculator implements Calculator {
    private int parallelism;
    private ExecutorService pool;

    public ExecutorServiceCalculator() {
        parallelism = Runtime.getRuntime().availableProcessors(); // CPU的核心数
        pool = Executors.newFixedThreadPool(parallelism);
    }

    @Override
    public long sumUp(long[] numbers) {
        List<Future<Long>> results = new ArrayList<>();
        // 把任务分解为 n 份，交给 n 个线程处理
        int part = numbers.length / parallelism;
        for (int i = 0; i < parallelism; i++) {
            int from = i * part;
            int to = (i == parallelism - 1) ? numbers.length - 1 : (i + 1) * part - 1;
            results.add(pool.submit(new SumTask(numbers, from, to)));
        }
        // 把每个线程的结果相加，得到最终结果
        long total = 0L;
        for (Future<Long> f : results) {
            try {
                total += f.get();
            } catch (Exception ignore) {
            }
        }
        return total;
    }

    private static class SumTask implements Callable<Long> {
        private long[] numbers;
        private int from;
        private int to;

        public SumTask(long[] numbers, int from, int to) {
            this.numbers = numbers;
            this.from = from;
            this.to = to;
        }

        @Override
        public Long call() throws Exception {
            long total = 0;
            for (int i = from; i <= to; i++) {
//                total += numbers[i];
                total = CalculatorUtils.add(total, numbers[i]);
            }
            return total;
        }
    }
}
