import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_560 {

    static int i = -953096259;

    static boolean allaccesses = true;

    static int[] array = new int[10];

    int m4(int[] array, int i, boolean allaccesses) {
        int res = 0;
        res += array[i + 3];
        if (allaccesses) {
            res += array[i + 4];
            res += array[i + 1];
            res += array[i + 2];
            res += array[i + 5];
            res += array[i + 6];
            res += array[i + 7];
            res += array[i + 8];
            res += array[i + 9];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_560().m4(array, i, allaccesses));
    }
}
