import java.util.Arrays;

public class MyJVMTest_2289 {

    static int[] arr = { 0, 2, 0, 8, 600592789, -558766947, -1029776478, 3, 0, 1 };

    static int[] array = new int[5];

    int[] m(int[] arr) {
        int i = 0;
        for (; i < 2; i++) {
        }
        if (i == 2) {
            arr = array;
        }
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2289().m(arr)));
    }
}
