import java.util.*;

public class MyJVMTest_11935 {

    static int[] c = { 0, 0, 1495497536, -1201850230, 0, 0, 5, -1895388103, 1395109857, 8 };

    int[] f(int[] c) {
        for (Integer i : c) {
            System.out.println(i);
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11935().f(c);
    }
}
