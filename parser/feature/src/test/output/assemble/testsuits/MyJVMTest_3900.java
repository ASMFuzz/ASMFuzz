import java.util.Arrays;

public class MyJVMTest_3900 {

    static int ARR_SIZE = 10;

    static int x = 2;

    static String s = "r$OAxl\"{pq";

    Object[] getObjArray() {
        x++;
        return new Object[ARR_SIZE];
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_3900().getObjArray()));
    }
}
