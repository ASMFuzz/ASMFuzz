import java.util.Arrays;

public class MyJVMTest_6575 {

    static int[] arr = { 5, 3, 0, 3, 2, 0, 7, 7, -1669293838, 0 };

    int[] run(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        int[] counts = new int[10];
        int i = 0;
        for (i = 0; i < counts.length; i += 1) {
            for (int j = 0; j < counts[i]; j += 1) {
            }
        }
        while (i < max) {
            for (int j = 0; j < counts[i]; j += 1) {
                arr[0] = i;
            }
        }
        return arr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_6575().run(arr)));
    }
}
