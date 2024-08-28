import java.util.Arrays;

public class MyJVMTest_4487 {

    void fillArray(int[] array) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            int val = (int) (Math.random() * Integer.MAX_VALUE);
            array[i] = val;
        }
    }

    static int ARRAY_SIZE = 10000;

    static int[] a = {1176176915,8,3,0,0,1723050627,2,3,1358530410,5};

    static int[] b = {-217729837,1,761400427,5,9,0,5,0,0,689968265};

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
        new MyJVMTest_4487().test();
    }
}
