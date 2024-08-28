import java.lang.invoke.*;
import java.util.Arrays;

public class MyJVMTest_12875 {

    static String[] arr = { "\"1+SzaH3PG", "xsY!cDaxfA", "mTMM7Uk/g.", "I:VJnOW&X-", "\"wByJ)5dZ*", "7;\"m7K$3Dx", "f9R!Un.q_%", "t-J`2ukmyv", "6 \\=^=^OFH", "=x?db\"n13d" };

    String[] testCloneObjectArray(String[] arr) {
        return arr.clone();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12875().testCloneObjectArray(arr)));
    }
}
