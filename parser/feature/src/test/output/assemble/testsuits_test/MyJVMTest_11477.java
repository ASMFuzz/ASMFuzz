import java.util.Arrays;

public class MyJVMTest_11477 {

    static int[] array = { 3, 8, 5, 0, 0, 3, 9, 1, 4, 14118398 };

    static int bs = 2070620907;

    static int[] sofar = {2,-1871965219,9,5,-1313032267,5,0,2,1793442226,0};

    static NQueensCS nextSubtask = null;

    NQueensCS explore(int[] array, int bs) {
        int row = array.length;
        NQueensCS s = null;
        outer: for (int q = 0; q < bs; ++q) {
            for (int i = 0; i < row; i++) {
                int p = array[i];
                if (q == p || q == p - (row - i) || q == p + (row - i))
                    continue outer;
            }
            NQueensCS first = s;
            if (first != null)
                first.fork();
            int[] next = Arrays.copyOf(array, row + 1);
            next[row] = q;
            NQueensCS subtask = new NQueensCS(next);
            subtask.nextSubtask = first;
            s = subtask;
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11477().explore(array, bs));
    }
}
