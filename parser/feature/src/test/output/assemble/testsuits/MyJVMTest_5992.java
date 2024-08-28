import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_5992 {

    static String[] escape_arr = {"Y9aX9NrkVa","[qty^G#RH:",";-]e7z/'E!","xM:)&AiZ,)","\\foTgzlkA|","Um&B4A.\\/'","~mz(^o&<u-","$~@3<g}AGo","XYo^=[)]aW","q2r.mFw/^M"};

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
        System.out.println(Arrays.asList(new MyJVMTest_5992().testCloneShortObjectArrayCopy()));
    }
}
