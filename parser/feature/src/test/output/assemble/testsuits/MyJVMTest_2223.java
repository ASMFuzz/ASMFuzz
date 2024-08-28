import java.util.Arrays;

public class MyJVMTest_2223 {

    static int[] array = { 0, 7, 9, 1, 3, 0, 4, 9, 0, 2 };

    static int bs = -1532852838;

    static int[] sofar = {9,0,5,9,0,0,0,0,3,2};

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
        System.out.println(new MyJVMTest_2223().explore(array, bs));
    }
}
