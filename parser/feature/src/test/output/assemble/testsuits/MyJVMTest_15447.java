import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_15447 {

    static String[] escape_arr = {"0 /u?s_%1s","+n6HLhSpM ","SbY^?3C-wQ","g`@-P\"}RpJ","-zF$.zCFNP","5i[p\\K}uKH","F6mZx3 z6V","3)_z:c]>3f","FO&}3YVjzK","3\"?_;}v,Dk"};

    static String str1 = new String("1");

    static String str2 = new String("2");

    static String str3 = new String("3");

    static String str4 = new String("4");

    static String str5 = new String("5");

    String[] testCloneShortObjectArrayCopy() {
        String[] arr = new String[5];
        arr[0] = str1;
        arr[1] = str2;
        arr[2] = str3;
        arr[3] = str4;
        arr[4] = str5;
        escape_arr = arr;
        String[] arr2 = new String[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_15447().testCloneShortObjectArrayCopy()));
    }
}
