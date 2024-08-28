import java.util.Arrays;

public class MyJVMTest_16071 {

    static int[] arr = { 2, -1161156667, 3, 2, 1, 717512637, 1085668347, -615558453, 3, 1 };

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
        System.out.println(Arrays.asList(new MyJVMTest_16071().run(arr)));
    }
}
