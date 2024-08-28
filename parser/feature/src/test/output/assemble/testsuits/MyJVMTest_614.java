import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class MyJVMTest_614 {

    static int nonStaticPublicField = 9;

    Lookup getPublicLookup() {
        return MethodHandles.publicLookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_614().getPublicLookup());
    }
}
