import java.util.ArrayList;
import java.util.Arrays;

public class MyJVMTest_4924 {

    static ArrayList<Integer> list = new ArrayList<Integer>();

    static String name = "<6`C?/<9}E";

    ArrayList<Integer> deoptimize(ArrayList<Integer> list) {
        for (Integer x : list) if (x == null)
            throw new Error();
        return list;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4924().deoptimize(list);
    }
}
