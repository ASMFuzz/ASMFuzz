import java.util.Arrays;

public class MyJVMTest_13874 {

    void fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
    }

    static int ARRAY_SIZE = 10000;

    static int[] a = {1291677048,3,0,2,9,6,6,0,0,8};

    static int[] b = {6,-126228024,2,0,0,447362888,2,0,7,0};

    void test() {
        int[] a1 = new int[ARRAY_SIZE];
        int[] b1 = new int[ARRAY_SIZE];
        fillArray(a);
        System.arraycopy(a, 0, b, 0, ARRAY_SIZE);
        if (!Arrays.equals(a, b)) {
            throw new RuntimeException("arrays not equal");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13874().test();
    }
}
