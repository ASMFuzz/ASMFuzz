import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_8789 {

    static String[] escape_arr = {"k%/tEa9{Pp","kYk@[rRB%#","dUgn>R?E2[","iZWP#H-CV&","+=U\\om}KJ+","OyYm|FyfC.","j$PNz>uYB&",",0eBZ+m>vS","=WQ%PC4leY","Xu(obTfs|/"};

    static String str1 = new String("1");

    static String str2 = new String("2");

    static String str3 = new String("3");

    static String str4 = new String("4");

    static String str5 = new String("5");

    String[] testCloneShortObjectArray() {
        String[] arr = new String[5];
        arr[0] = str1;
        arr[1] = str2;
        arr[2] = str3;
        arr[3] = str4;
        arr[4] = str5;
        escape_arr = arr;
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_8789().testCloneShortObjectArray()));
    }
}
