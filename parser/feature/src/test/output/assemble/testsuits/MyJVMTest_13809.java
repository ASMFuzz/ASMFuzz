import java.util.Arrays;

public class MyJVMTest_13809 {

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

    int processSubtasks(NQueensCS s) {
        s.compute();
        int ns = s.solutions;
        s = s.nextSubtask;
        while (s != null && s.tryUnfork()) {
            s.compute();
            ns += s.solutions;
            s = s.nextSubtask;
        }
        while (s != null) {
            s.join();
            ns += s.solutions;
            s = s.nextSubtask;
        }
        return ns;
    }

    static int boardSize = 0;

    static int[] sofar = {0,0,5,6,8,0,1263085404,1,-1207961653,8};

    static NQueensCS nextSubtask = null;

    static int solutions = 6;

    void compute() {
        NQueensCS subtasks;
        int bs = boardSize;
        if (sofar.length >= bs)
            solutions = 1;
        else if ((subtasks = explore(sofar, bs)) != null)
            solutions = processSubtasks(subtasks);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13809().compute();
    }
}
