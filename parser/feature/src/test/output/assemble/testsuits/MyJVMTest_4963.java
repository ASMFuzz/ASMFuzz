import java.util.Arrays;

public class MyJVMTest_4963 {

    static char[] arr1 = { Character.MIN_VALUE, '0', '*', Character.MIN_VALUE, '0', ';', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static int v1 = 6;

    static int v2 = 0;

    boolean m3(char[] arr1) {
        int l = v2 - v1;
        char[] arr2 = new char[l];
        arr2[0] = 'a';
        return Arrays.equals(arr2, arr1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4963().m3(arr1));
    }
}
