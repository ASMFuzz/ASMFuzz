import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_4985 {

    static int i = 8;

    static boolean allaccesses = false;

    static int[] array = new int[10];

    int m11(int[] array, int i, boolean allaccesses) {
        int res = 0;
        res += array[i + 3];
        res += array[i - 2];
        if (allaccesses) {
            res += array[i + 5];
            res += array[i + 6];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4985().m11(array, i, allaccesses));
    }
}
