import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_10105 {

    static int i = 0;

    static boolean allaccesses = true;

    static int[] array = new int[10];

    int m9(int[] array, int i, boolean allaccesses) {
        int res = 0;
        res += array[i + 3];
        if (allaccesses) {
            res += array[i - 2];
            res += array[i - 1];
            res += array[i - 4];
            res += array[i - 5];
            res += array[i - 6];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10105().m9(array, i, allaccesses));
    }
}
