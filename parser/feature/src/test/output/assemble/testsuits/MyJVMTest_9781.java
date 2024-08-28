import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class MyJVMTest_9781 {

    static int nonStaticPublicField = 0;

    Lookup getPublicLookup() {
        return MethodHandles.publicLookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9781().getPublicLookup());
    }
}
