import java.util.Arrays;

public class MyJVMTest_8167 {

    static int sz = 1554156572;

    static int seed = 7;

    void init(int[] a, int seed) {
        for (int j = 0; j < a.length; j++) {
            a[j] = (j % 2 == 0) ? seed + j : seed - j;
        }
    }

    static int a = 3;

    int[] int1array(int sz, int seed) {
        int[] ret = new int[sz];
        init(ret, seed);
        return ret;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8167().int1array(sz, seed)));
    }
}
