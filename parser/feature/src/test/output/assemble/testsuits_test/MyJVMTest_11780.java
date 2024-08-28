import java.util.*;

public class MyJVMTest_11780 {

    static int a = 0;

    static int b = 0;

    static int passed = 0;

    int[][] test(int a, int b) throws Exception {
        int[][] ar;
        try {
            ar = new int[a][b];
        } catch (ThreadDeath e) {
            System.out.println("test got ThreadDeath");
            passed++;
            throw (e);
        }
        return ar;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11780().test(a, b)[0]));
        System.out.println(Arrays.asList(new MyJVMTest_11780().test(a, b)[1]));
    }
}
