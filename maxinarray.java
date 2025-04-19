import java.util.concurrent.*;

class MaxFinder extends RecursiveTask<Integer> {
    private int[] array;
    private int start, end;

    public MaxFinder(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected Integer compute() {
        if (end - start <= 1000) {
            int max = Integer.MIN_VALUE;
            for (int i = start; i < end; i++) max = Math.max(max, array[i]);
            return max;
        }

        int mid = (start + end) / 2;
        MaxFinder left = new MaxFinder(array, start, mid);
        MaxFinder right = new MaxFinder(array, mid, end);

        left.fork();
        int rightMax = right.compute();
        int leftMax = left.join();

        return Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) array[i] = i;

        ForkJoinPool pool = new ForkJoinPool();
        int max = pool.invoke(new MaxFinder(array, 0, array.length));
        System.out.println("Max: " + max);
    }
}
