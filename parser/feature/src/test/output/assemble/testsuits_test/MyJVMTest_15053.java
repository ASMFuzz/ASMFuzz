import java.io.File;

public class MyJVMTest_15053 {

    static int[] array = { 1, 1981119249, 6, 0, 2, 0, 0, 5, 679449860, 9 };

    static int p = 0;

    static int inc = 5;

    int arrMethod(int[] array, int p, int inc) {
        array[p] += inc;
        return inc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15053().arrMethod(array, p, inc);
    }
}
