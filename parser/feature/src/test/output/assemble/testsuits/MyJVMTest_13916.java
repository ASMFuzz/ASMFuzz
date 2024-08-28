import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_13916 {

    static String[] escape_arr = {"|/ ^xOxPi\"","Ubcc?:\"%`4"," F>85U;]Ep","/o0HfNZaHt","Pv`e]\\w`(t","xVxx\"Ial0c","%rrlf|6D_.","KIE[zk\"skg",".}INu%4i0e","}x&]sJ [S\""};

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
        System.out.println(Arrays.asList(new MyJVMTest_13916().testCloneShortObjectArray()));
    }
}
