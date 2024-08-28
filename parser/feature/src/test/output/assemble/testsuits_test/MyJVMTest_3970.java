import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodHandles.Lookup;

public class MyJVMTest_3970 {

    Lookup getPublicLookup() {
        return MethodHandles.publicLookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3970().getPublicLookup());
    }
}
