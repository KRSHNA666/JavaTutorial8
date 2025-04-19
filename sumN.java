import java.util.concurrent.*;

public class NaturalSumTask implements Callable<Integer> {
    private int n;

    public NaturalSumTask(int n) {
        this.n = n;
    }

    public Integer call() {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> future = executor.submit(new NaturalSumTask(100));
        System.out.println("Sum of first 100 numbers: " + future.get());
        executor.shutdown();
    }
}
