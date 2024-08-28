import java.util.Arrays;

public class MyJVMTest_14511 {

    static String KEY = "this is the key in MyResourcesB";

    static String VALUE = "THIS IS THE VALUE IN MyResourcesB";

    Object[][] getContents() {
        return new Object[][] { { KEY, VALUE } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_14511().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_14511().getContents()[1]));
    }
}
