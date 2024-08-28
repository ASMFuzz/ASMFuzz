import java.util.Arrays;

public class MyJVMTest_14369 {

    static char[] arr1 = { '0', Character.MAX_VALUE, 'I', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'f', '0', '0' };

    static int v1 = 6;

    static int v2 = 9;

    boolean m3(char[] arr1) {
        int l = v2 - v1;
        char[] arr2 = new char[l];
        arr2[0] = 'a';
        return Arrays.equals(arr2, arr1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14369().m3(arr1));
    }
}
