import java.util.Arrays;

public class MyJVMTest_4663 {

    static byte[] array = { -44, 96, -42, -96, -36, -5, -8, -104, 16, -72 };

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
        System.out.println(Arrays.asList(new MyJVMTest_4663().reset(array)));
    }
}
