import java.util.Arrays;

public class MyJVMTest_5098 {

    static String KEY = "this is the key in MyResourcesB";

    static String VALUE = "THIS IS THE VALUE IN MyResourcesB";

    Object[][] getContents() {
        return new Object[][] { { KEY, VALUE } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_5098().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_5098().getContents()[1]));
    }
}
