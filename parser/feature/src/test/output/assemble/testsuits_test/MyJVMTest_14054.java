import java.util.Arrays;

public class MyJVMTest_14054 {

    static byte[] array = { -96, 31, 24, 71, 25, -79, 63, 95, -31, 45 };

    byte[] reset(byte[] array) {
        if (null == array) {
            array = new byte[3];
        }
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14054().reset(array)));
    }
}
