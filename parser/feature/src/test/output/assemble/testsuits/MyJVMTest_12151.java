import java.util.Arrays;

public class MyJVMTest_12151 {

    static int[] array = { 0, 2, 5, 7, 0, 7, -1036465755, 0, -1743524805, 233709891 };

    int[] reset(int[] array) {
        if (null == array) {
            array = new int[3];
        }
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12151().reset(array)));
    }
}
