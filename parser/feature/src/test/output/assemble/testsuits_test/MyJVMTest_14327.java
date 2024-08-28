import java.util.ArrayList;
import java.util.Arrays;

public class MyJVMTest_14327 {

    static ArrayList<Integer> list = new ArrayList<Integer>();

    static String name = "sK4`Jcm{O/";

    ArrayList<Integer> deoptimize(ArrayList<Integer> list) {
        for (Integer x : list) if (x == null)
            throw new Error();
        return list;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14327().deoptimize(list);
    }
}
