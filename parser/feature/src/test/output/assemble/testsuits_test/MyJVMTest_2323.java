import java.util.Arrays;

public class MyJVMTest_2323 {

    static boolean[] array = { true, true, true, false, true, true, true, false, false, true };

    boolean[] reset(boolean[] array) {
        if (null == array) {
            array = new boolean[4];
        }
        array[0] = true;
        array[1] = false;
        array[2] = true;
        array[3] = false;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_2323().reset(array)));
    }
}
