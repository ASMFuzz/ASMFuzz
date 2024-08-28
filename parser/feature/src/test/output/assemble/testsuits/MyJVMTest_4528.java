import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_4528 {

    static String[] escape_arr = {"J97b^'ey`^","F'hO@)[84a","sUPHvA7,0k","R2?wOU|)_3","=b@,~Wz6YI","i R$t(_}tn","C0R7>'iP5^","l:?]a  hV=","K{8KlUlf|e","dR{:_i(3cG"};

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
        System.out.println(Arrays.asList(new MyJVMTest_4528().testCloneShortObjectArray()));
    }
}
