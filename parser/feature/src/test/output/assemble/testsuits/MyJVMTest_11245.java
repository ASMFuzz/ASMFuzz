import java.util.Arrays;

public class MyJVMTest_11245 {

    static Class<?>[] array = null;

    Class<?>[] reset(Class<?>[] array) {
        if (null == array) {
            array = new Class<?>[3];
        }
        array[0] = Object.class;
        array[1] = String.class;
        array[2] = ClassLoader.class;
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_11245().reset(array)));
    }
}
