import java.util.concurrent.*;

class EvenOddCounter extends RecursiveTask<int[]> {
    private int[] array;
    private int start, end;

    public EvenOddCounter(int[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected int[] compute() {
        if (end - start <= 1000) {
            int even = 0, odd = 0;
            for (int i = start; i < end; i++) {
                if (array[i] % 2 == 0) even++;
                else odd++;
            }
            return new int[]{even, odd};
        }

        int mid = (start + end) / 2;
        EvenOddCounter left = new EvenOddCounter(array, start, mid);
        EvenOddCounter right = new EvenOddCounter(array, mid, end);
        left.fork();
        int[] rightResult = right.compute();
        int[] leftResult = left.join();

        return new int[]{
            leftResult[0] + rightResult[0],  // even
            leftResult[1] + rightResult[1]   // odd
        };
    }

    public static void main(String[] args) {
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) array[i] = i;

        ForkJoinPool pool = new ForkJoinPool();
        int[] result = pool.invoke(new EvenOddCounter(array, 0, array.length));

        System.out.println("Even: " + result[0] + ", Odd: " + result[1]);
    }
}
