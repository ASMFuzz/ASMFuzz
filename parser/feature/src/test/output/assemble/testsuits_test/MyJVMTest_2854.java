import java.util.Arrays;

public class MyJVMTest_2854 {

    static int[] array = { 6, 8, 7, 3, 8, 0, -212881249, -1609840310, 5, 6 };

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
        System.out.println(Arrays.asList(new MyJVMTest_2854().reset(array)));
    }
}
