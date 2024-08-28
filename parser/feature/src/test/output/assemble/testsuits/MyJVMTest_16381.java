import java.lang.invoke.MethodHandles;

public class MyJVMTest_16381 {

    MethodHandles.Lookup getLookup() {
        return MethodHandles.lookup();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16381().getLookup());
    }
}
