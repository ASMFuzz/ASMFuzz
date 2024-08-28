import java.util.Arrays;

public class MyJVMTest_12153 {

    static String KEY = "this is the key in MyResourcesA";

    static String VALUE = "THIS IS THE VALUE IN MyResourcesA";

    Object[][] getContents() {
        return new Object[][] { { KEY, VALUE } };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12153().getContents()[0]));
        System.out.println(Arrays.asList(new MyJVMTest_12153().getContents()[1]));
    }
}
