import java.util.Arrays;

public class MyJVMTest_12706 {

    static short[] array = { -32768, -20635, -32768, -32768, 0, 0, 11536, -32768, 32767, -32768 };

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
        System.out.println(Arrays.asList(new MyJVMTest_12706().reset(array)));
    }
}
