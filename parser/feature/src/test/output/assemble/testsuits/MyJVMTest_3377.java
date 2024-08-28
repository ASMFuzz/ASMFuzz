import java.util.Arrays;

public class MyJVMTest_3377 {

    static short[] array = { -15067, 32767, -15335, 20346, -32768, 27971, -20347, -32768, 6426, -32768 };

    short[] reset(short[] array) {
        if (null == array) {
            array = new short[3];
        }
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3377().reset(array)));
    }
}
