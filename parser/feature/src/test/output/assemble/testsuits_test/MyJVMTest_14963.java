import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_14963 {

    static int i = 3;

    static boolean allaccesses = false;

    static int[] array = new int[10];

    int m10(int[] array, int i, boolean allaccesses) {
        int res = 0;
        res += array[i + 3];
        if (allaccesses) {
            res += array[i - 2];
            res += array[i - 1];
            res += array[i - 3];
            res += array[i + 4];
            res += array[i + 5];
            res += array[i + 6];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14963().m10(array, i, allaccesses));
    }
}
