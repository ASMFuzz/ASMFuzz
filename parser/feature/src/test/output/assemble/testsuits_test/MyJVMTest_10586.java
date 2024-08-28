import java.lang.annotation.*;
import java.lang.reflect.*;
import java.util.*;

public class MyJVMTest_10586 {

    static int i = 0;

    static boolean allaccesses = false;

    static int[] array = new int[10];

    int m12(int[] array, int i, boolean allaccesses) {
        int res = 0;
        res += array[i + 3];
        res += array[i + 6];
        if (allaccesses) {
            res += array[i - 2];
            res += array[i - 3];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10586().m12(array, i, allaccesses));
    }
}
