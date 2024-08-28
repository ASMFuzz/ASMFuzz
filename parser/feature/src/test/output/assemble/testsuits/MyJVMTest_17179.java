import java.util.Arrays;

public class MyJVMTest_17179 {

    static char[] array = { Character.MAX_VALUE, '"', 'r', '0', '0', '>', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    char[] reset(char[] array) {
        if (null == array) {
            array = new char[3];
        }
        array[0] = '1';
        array[1] = '2';
        array[2] = '3';
        return array;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_17179().reset(array)));
    }
}
